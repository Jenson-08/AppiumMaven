package teststeps;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import setUp.BaseTest;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

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
        //set wifi name

    }
}
