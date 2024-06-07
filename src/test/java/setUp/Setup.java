
package setUp;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PreferencesPage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class Setup {

    //public AppiumDriver
    public AndroidDriver driver;
    public PreferencesPage preferencesPage;

    @BeforeMethod
    public void Configuration() throws MalformedURLException, URISyntaxException {
        // Configurar capabilities
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=ApiDemos-debug.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:automationName", "UiAutomator2");

        // Configurar sauceOptions
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "oauth-jensonpg08-865c3");
        sauceOptions.setCapability("accessKey", "b7f67755-1921-481d-9b68-19287d6e4e7f");
        sauceOptions.setCapability("build", "appium-build-67YV9");
        sauceOptions.setCapability("name", "My Test");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");

        // Añadir sauceOptions a las capabilities
        caps.setCapability("sauce:options", sauceOptions);

        // URL del servidor de Sauce Labs
        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        driver = new AndroidDriver(url, caps);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        preferencesPage = new PreferencesPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}







//    public AndroidDriver driver;
//    public AppiumDriverLocalService service;
//    public PreferencesPage preferencesPage;
//
//    @BeforeMethod
//    public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
//        service = new AppiumServiceBuilder()
//                .withAppiumJS(new File("C://Users//jenperez1//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
//                .withIPAddress("127.0.0.1")  // Sin "http://"
//                .usingPort(4723)
//                .build();
//
//        // Iniciar el servicio
//        service.start();
//
//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setDeviceName("pixel_8_pro");
//        options.setApp("C://Users//jenperez1//Documents//AppiumMaven//src//test//java//resources//ApiDemos-debug.apk");
//
//
//        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        preferencesPage = new PreferencesPage(driver);
//
//    }
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//        service.stop();
//    }

