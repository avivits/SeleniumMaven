package project2;
// picking price, area, present category from dropbox

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.*;

public class HomeScreen extends BasePage2 {

    private WebDriver driverOfHomeScreen;

    public HomeScreen() {
        driverOfHomeScreen = DriverSingleton2.getDriverInstance();

    }

    public void   onceLogin(){

        pickPrice();
        pickArea();
        pickCategory();
        pressPickingPresent();

    }

    private void pickPrice(){
        clickElement(By.linkText("סכום")); //open price list
        List<WebElement> priceList = driverOfHomeScreen.findElements(By.className("active-result"));
        priceList.get(3).click();

    }

    private void pickArea()  {
        clickElement(By.linkText("אזור")); //open area list
        List<WebElement> areaList = driverOfHomeScreen.findElements(By.className("active-result"));
        areaList.get(2).click();

    }

    private void pickCategory(){
        clickElement(By.linkText("קטגוריה")); //open category list
        List<WebElement> categoryList = driverOfHomeScreen.findElements(By.className("active-result"));
        categoryList.get(2).click();
    }

    private void pressPickingPresent(){

        JavascriptExecutor js = (JavascriptExecutor) driverOfHomeScreen; // pop-up interrupting, scrolling down
        js.executeScript("window.scrollBy(0,250)", "");

        clickElement(By.cssSelector("a[rel=nofollow]")); //"find me a present" button
    }



}



