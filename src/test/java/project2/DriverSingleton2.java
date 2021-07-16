package project2;


//a Singleton for instantiating and getting Webderiver instance

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverSingleton2 {

    private static WebDriver driver=null;

    private DriverSingleton2() {

    }

    public static WebDriver getDriverInstance(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\IMOE001\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        return driver;
    }

}
