package project2;

import class9and10.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PickBusiness extends BasePage2{

    private WebDriver driverOfBusiness;

    public PickBusiness() throws MalformedURLException {
        driverOfBusiness = DriverSingleton2.getDriverInstance();

    }

    public void pickPresent() throws MalformedURLException {
        pickBusiness();
        PressChooseBttn();
    }


    private void pickBusiness() throws MalformedURLException {

        clickElement(By.linkText("TAIZU - טאיזו"));

    }



    private void PressChooseBttn(){

        List<WebElement>chooseBttnList = driverOfBusiness.findElements(By.className("mx-12"));   //button בחירה
        chooseBttnList.get(3).click();

    }


}
