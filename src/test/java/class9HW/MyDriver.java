package class9HW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MyDriver {

    private static WebDriver driver;


    @BeforeClass
    public static void runBefore(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IMOE001\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public static void q1Driver()  {

         driver.get("https://www.walla.co.il");

//        System.setProperty("webdriver.fireFox.driver", "C:\\Users\\IMOE001\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        driver1 = new FirefoxDriver();
//        driver1.get("https://www.walla.co.il");

    }

    @Test
    public void q2Driver()  {
       String title= "וואלה! - האתר המוביל בישראל - עדכונים מסביב לשעון"  ;
        System.out.println(driver.getTitle());
        driver.navigate().refresh();
        Assert.assertEquals(driver.getTitle(),title);

    }

    @Test
    public void q3Driver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IMOE001\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.get("https://www.youtube.com/");
        String title= "YouTube";
        String url = "https://www.youtube.com/";
        Assert.assertEquals(driver.getTitle(),title);
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }


}




