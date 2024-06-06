package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PreferencesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public PreferencesPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(accessibility = "Preference")
    private WebElement preferencesButton;

    public WebElement getPreferencesButton(){
        wait.until(ExpectedConditions.visibilityOf(preferencesButton));
        return preferencesButton;
    }


}
