package project2;

//import org.apache.commons.io.FileUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;



public class BasePage2 {

    private WebDriver driver;



        public void clickElement(By locator) {
            getWebElement(locator).click();
          }

        public void sendKeysToElement(By locator, String text) {
            getWebElement(locator).sendKeys(text);
        }

        public void submitElement(By locator){
            getWebElement(locator).submit();
        }

        private WebElement getWebElement(By locator) {

            return DriverSingleton2.getDriverInstance().findElement(locator);
        }



    }
