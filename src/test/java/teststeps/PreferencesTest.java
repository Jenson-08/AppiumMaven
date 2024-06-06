package teststeps;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import setUp.BaseTest;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.rmi.Remote;

public class PreferencesTest extends BaseTest {

    @Test
    public void WifiSettingsName() throws MalformedURLException, URISyntaxException {

        //Actual automation
        //Xpath, id, accesibilityId, classname, AndroidUIAutomator
        preferencesPage.getPreferencesButton().click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]")).click();
        driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
        String popUp = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]")).getText();
        Assert.assertEquals(popUp, "WiFi settings");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys("test1");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();


    }

    @Test
    public void LongPressGesture(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement ele = driver.findElement((By.xpath("//android.widget.TextView[@text=\"People Names\"]")));
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
        String menuText = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(menuText,"Sample Menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
    }




}
