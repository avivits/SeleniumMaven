package project2;


//a Singleton for instantiating and getting Webderiver instance

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverSingleton2 {

    private static WebDriver driver=null;

    private DriverSingleton2() {

    }

    public static WebDriver getDriverInstance() throws MalformedURLException {
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\IMOE001\\Downloads\\chromedriver_win32\\chromedriver.exe");
////           ChromeOptions chromeOptions = new ChromeOptions();
////           chromeOptions.addArguments("--headless");
////            driver = new ChromeDriver(chromeOptions);
//            driver = new ChromeDriver();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("username", "oauth-avivitn2504-02550");
            capabilities.setCapability("accessKey", "a3693b86-4a66-4216-94ed-11a8ff6a85e0");
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("platform", "Windows 10");
            capabilities.setCapability("version", "81.0");
            capabilities.setCapability("build", "Onboarding Sample App - Java-TestNG");
            capabilities.setCapability("name", "3-cross-browser");
            driver = new RemoteWebDriver(new URL("http://ondemand.saucelabs.com/wd/hub"), capabilities);
        }

        return driver;
    }

}
