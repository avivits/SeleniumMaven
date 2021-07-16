package class10HW;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainDriver {


    private static WebDriver driver;

//-----------------------------------Q1-----------------------------------------
    @BeforeClass
    public static void myDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IMOE001\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");

    }


    @Test
    public static void removeBtn(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("btn")).click();
        driver.findElement(By.id("message")).isDisplayed();

    }

    @Test
    public static void showHideBtn() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("hidden")).click();
       // driver.findElement(By) ???

    }

    @Test
    public static void renderBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("rendered")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish2")));
        String text = driver.findElement(By.id("finish2")).getText();
        Assert.assertEquals(text,"This is a new element");

    }

//    //-----------------------------------Q2-----------------------------------------


    @Test
    public static void openAngularSite() {
        NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngWebDriver.waitForAngularRequestsToFinish();
        driver.get("https://dgotlieb.github.io/AngularJS/main.html");
//      driver.findElement(ByAngular.model("firstName")).clear();
//      driver.findElement(ByAngular.model("firstName")).sendKeys("Avivit");

        WebElement nameField =  driver.findElement((ByAngular.model("firstName")));
        nameField.clear();
        nameField.sendKeys("Avivit");
        String personName = ngWebDriver.retrieveAsString(nameField, "Avivit");
        System.out.println(personName);


    }

//    //-----------------------------------Q3-----------------------------------------
//
//    //PageLoadTimeOut: One of the timeouts is focused on the time a webpage needs to be loaded –
//    //the pageLoadTimeout limits the time that the script allots for a web page to
//    //be displayed.
//
//
//    //-----------------------------------Q4-----------------------------------------
//
//    @Test
//    public static void calculatorSite(){
//        driver.get("https://dgotlieb.github.io/WebCalculato");
//
//        driver.findElement(By.id("seven"));
////          ?????????
//    }

}
