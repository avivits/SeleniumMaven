package class9and10;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverMethodsTest {
    private static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IMOE001\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://translate.google.com");
    }

    @Test
    public void test01_getCurrentURL(){
        System.out.println(driver.findElement(By.className("er8xn")));
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.className("er8xn")).click();
        driver.findElement(By.className("er8xn")).sendKeys("hello");
    }
//
//    @Test
//    public void test02_getTitle(){
//        System.out.println(driver.getTitle());
//    }
//
//    @Test
//    public void test03_getPageSource(){
//
//        //System.out.println(driver.getPageSource());
//    }
//
//    @Test
//    public void test04_getCurrentTabHandle(){
//        System.out.println(driver.getWindowHandle());
//    }
//
//    @Test
//    public void test05_getAllTabsHandles(){
//        System.out.println(driver.getWindowHandles());
//    }
//
//    @Test
//    public void test06_navigateToGoogle(){
//        driver.navigate().to("https://www.google.com");
//    }
//
//    @Test
//    public void test07_navigateBackToTranslate(){
//        driver.navigate().back();
//    }
//
//    @Test
//    public void test08_navigateForwardToGoogle(){
//        driver.navigate().forward();
//    }
//
//    @Test
//    public void test09_closeCurrentTab(){
//        driver.close();
//    }
//
//    @AfterClass
//    public static void tearDown(){
//        driver.quit();
//    }
}
