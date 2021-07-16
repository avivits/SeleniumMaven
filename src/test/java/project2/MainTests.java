package project2;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

////------------------------------ “BuyMe” website sanity test -----------------------------------------------------

public class MainTests {

    private static WebDriver driver;
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
    private static WebDriverWait wait;



    @BeforeClass
    public static void beforeAll() throws Exception {
        if(getData("browserType").equals("Chrome")) {   //reading from external XML file
            driver = DriverSingleton2.getDriverInstance();          //browser
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get(getData("URL"));                       //reading from external XML file

        String cwd = System.getProperty("user.dir");              //creating html file inside the project
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO, "before test method");

    }



//////----------------------------------------- step 1 -------------------------------

    @Test(priority = 1)
    public void introAndRegister() throws InterruptedException {
        try {
            new LoginPage2().login();
        }catch (NoSuchElementException e){
            test.fail("details: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot ("step1")).build());
        }

        //assert register details
        Thread.sleep(5000);
        String name = "avivit1";
        String mail = "avivits8@gmal.com";
        String password = "An123456";
        String password2 = "An123456";

        Assert.assertEquals(driver.findElement(By.className("ember-text-field")).getText(),name);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[placeholder=מייל]")).getText(),mail);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[placeholder=סיסמה]")).getText(),password);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[placeholder=\"אימות סיסמה\"]")).getText(),password2);

    }

//////----------------------------------------- step 2 -------------------------------
    @Test(priority = 2)
    public  static void homeScreenPick(){

        try {
            new HomeScreen().onceLogin();

        }catch (NoSuchElementException e){
            test.fail("details: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot ("step2")).build());
        }

    }


//    //////----------------------------------- step 3 -------------------------------
//
    @Test(priority = 3)

    public static void businessChoosing() throws InterruptedException {
        Thread.sleep(5000);
        String  url = "https://buyme.co.il/search?budget=3&category=16&region=11";
        Assert.assertEquals(driver.getCurrentUrl(),url);


        try {
                new PickBusiness().pickPresent();

        }catch (NoSuchElementException e) {
            test.fail("details: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot ("step3")).build());
        }
    }

//
//    //////---------------------------------- step 4 ------------------------------
//

    @Test(priority = 4)
    public static void senderAndReceiver() throws InterruptedException {
        try {

            new SendingPresent().send();
        } catch (NoSuchElementException e) {
            test.fail("details: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("step4")).build());
            System.out.println("locator not found3");
        }

        //assert receiver and sender
//        Thread.sleep(5000);
        String receiver = "אבא";
        String sender = "אביבית";
        Assert.assertEquals(driver.findElement(By.id("friendName")).getText(),receiver);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[placeholder=\"שם שולח המתנה\"]")).getText(),sender);
    }


    //creating an external XML file to store url and browser
    private static String getData (String keyName) throws Exception{
        File fXmlFile = new File("C:\\Users\\IMOE001\\Downloads\\SeleniumMaven (1)\\SeleniumMaven\\src\\main\\resources\\data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    //screen shot method
    public static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }



    @AfterClass
    public void afterAll(){
        extent.flush();
//        driver.quit();
    }
}
