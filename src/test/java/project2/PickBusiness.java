package project2;

import class9and10.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PickBusiness extends BasePage2{

    private WebDriver driverOfBusiness;

    public PickBusiness(){
        driverOfBusiness = DriverSingleton2.getDriverInstance();

    }

    public void pickPresent(){
        pickBusiness();
        PressChooseBttn();
    }


    private void pickBusiness() {

        clickElement(By.linkText("TAIZU - טאיזו"));

    }



    private void PressChooseBttn(){

//        driverOfBusiness.get("https://buyme.co.il/supplier/348972?budget=3&category=16&query=&region=11"); //****

        List<WebElement>chooseBttnList = driverOfBusiness.findElements(By.className("mx-12"));          //button בחירה
        chooseBttnList.get(3).click();

    }


}
