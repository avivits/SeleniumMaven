package project2;
// picking price, area, present category from dropbox

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

import static java.lang.Thread.*;

public class HomeScreen extends BasePage2 {

    private WebDriver driverOfHomeScreen;

    public HomeScreen() throws MalformedURLException {
        driverOfHomeScreen = DriverSingleton2.getDriverInstance();

    }

    public void   onceLogin() throws MalformedURLException {

        pickPrice();
        pickArea();
        pickCategory();
        pressPickingPresent();

    }

    private void pickPrice() throws MalformedURLException {
        clickElement(By.linkText("סכום")); //open price list
        List<WebElement> priceList = driverOfHomeScreen.findElements(By.className("active-result"));
        priceList.get(3).click();

    }

    private void pickArea() throws MalformedURLException {
        clickElement(By.linkText("אזור")); //open area list
        List<WebElement> areaList = driverOfHomeScreen.findElements(By.className("active-result"));
        areaList.get(2).click();

    }

    private void pickCategory() throws MalformedURLException {
        clickElement(By.linkText("קטגוריה")); //open category list
        List<WebElement> categoryList = driverOfHomeScreen.findElements(By.className("active-result"));
        categoryList.get(2).click();
    }

    private void pressPickingPresent() throws MalformedURLException {

        JavascriptExecutor js = (JavascriptExecutor) driverOfHomeScreen; // pop-up interrupting, scrolling down
        js.executeScript("window.scrollBy(0,250)", "");
        clickElement(By.cssSelector("a[rel=nofollow]")); //"find me a present" button
    }



}



