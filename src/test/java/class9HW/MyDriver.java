package class9HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MyDriver {

    private static WebDriver driver;
    private static FirefoxDriver driver1;


    @BeforeClass
    public static void runBefore(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IMOE001\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.fireFox.driver", "C:\\Users\\IMOE001\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        driver1 = new FirefoxDriver();
    }

    @Test
    public static void q1Driver()  {

//         driver.get("https://www.walla.co.il");
//        driver1.get("https://www.ynet.co.il");
        driver.get("https://www.linkedin.com/");
        String buttonColor = driver.findElement(By.name("submit")).getCssValue("background-color");
        String buttonTextColor = driver.findElement(By.name("submit")).getCssValue("color");
        System.out.println("Button color: " + buttonColor);
        System.out.println("Text color " + buttonTextColor);

    }

//    @Test
//    public void q2Driver()  {
//       String title= "וואלה! - האתר המוביל בישראל - עדכונים מסביב לשעון"  ;
//        System.out.println(driver.getTitle());
//        driver.navigate().refresh();
//        Assert.assertEquals(driver.getTitle(),title);
//
//    }
//
//    @Test
//    public void q3Driver(){
////        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IMOE001\\Downloads\\chromedriver_win32\\chromedriver.exe");
////        driver = new ChromeDriver();
//        String title= "YouTube";
//        String url = "https://www.youtube.com/";
//        Assert.assertEquals(driver.getTitle(),title);
//        Assert.assertEquals(driver.getCurrentUrl(),url);
//    }
//
//    @Test
//    public void q4Driver(){
//        driver.get("https://translate.google.com/");
//        System.out.println(driver.findElement(By.className("P6w8m")));
//        System.out.println(driver.findElement(By.tagName("c-wiz")));
//    }
//
//    @Test
//    public void q7Driver(){
//        driver.get("https://www.amazon.com/");
//        String title = "Amazon.com. Spend less. Smile more." ;
//        Assert.assertEquals(driver.getTitle() , title);
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Leather shoes");
//
//    }
//    @Test
//    public void q8Driver(){
//        driver.get("https://translate.google.com/");
//        driver.findElement(By.tagName("textarea")).sendKeys("שלום");
//    }
//
//    @Test
//    public void q9Driver(){
//        driver.get("https://www.youtube.com/");
//        driver.findElement(By.id("search")).sendKeys("רסיסים");
//        driver.findElement(By.id("search-icon-legacy")).click();
//    }
//
//    @Test
//    public void q10Driver() {
//        driver.get("https://dgotlieb.github.io/Controllers/");
//        Select mySelection = new Select(driver.findElement(By.name("dropdownmenu")));
//        mySelection.selectByValue("Cheese");
//        for (int i = 0; i < mySelection.getOptions().size(); i++) {
//            System.out.println(mySelection.getOptions().get(i).getText());
//        }
//    }
//        @Test
//        public void q11Driver() {
//            driver.get("https://www.facebook.com/");
//            driver.findElement(By.id("email")).sendKeys("avivit");
//            driver.findElement(By.id("pass")).sendKeys("avivit");
//
//        }

}







