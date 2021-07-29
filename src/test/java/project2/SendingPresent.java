package project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;


import java.awt.*;
import java.net.MalformedURLException;
import java.util.List;

public class SendingPresent extends BasePage2{

    private WebDriver driverOfSending;

    public SendingPresent() throws MalformedURLException {
        driverOfSending=DriverSingleton2.getDriverInstance();

    }

    public void send() throws MalformedURLException {
//        printColor(); //extra
        sendingTo();
        receiverName();
        pickEvent();
        blessingText();
//        uploadPict();
        goOnButtn();
        paymentRadioButtn();
        howSending();
        senderName();
        paymentBttn();
    }

    private void printColor(){
        driverOfSending.get("https://buyme.co.il/package/348972/11617734");
////        String buttonColor = driverOfSending.findElement(By.name("submit")).getCssValue("background-color");
//        String textColor = driverOfSending.findElement(By.className("label bottom-xs")).getCssValue("background-color");
//        String textColor1 = driverOfSending.findElement(By.className("label bottom-xs")).getCssValue("color");
//        System.out.println("text color: " + textColor);
//        List<WebElement>labalList = driverOfSending.findElements(By.className("bottom-xs"));
//       String textColor= labalList.get(0).getCssValue("background-color");
//        System.out.println(" color: " + textColor);

        Color colorBtn = Color.fromString(driverOfSending.findElement(By.className("button-forSomeone")).getCssValue("background"));
        System.out.println("colorBtn: " + colorBtn);
//         String textColor = driverOfSending.findElement(By.className("button-forSomeone")).getCssValue("background");
//        System.out.println(" bckColor: " + textColor);
//        String hex = Color.fromString(textColor).asHex();
//        System.out.println("hex: " + hex);

    }

    private void sendingTo() throws MalformedURLException {
//        clickElement(By.className("button-forMyself"));
        clickElement(By.className("button-forSomeone"));
    }

    private void receiverName() throws MalformedURLException {
        sendKeysToElement((By.id("friendName")), "אבא");

    }

    private void pickEvent() throws MalformedURLException {  //לא הצלחתי לבחור אירוע בגלילה
        JavascriptExecutor js = (JavascriptExecutor) driverOfSending; //  scrolling down
        js.executeScript("window.scrollBy(0,250)", "");
        clickElement(By.className("selected-name"));
//        clickElement(By.linkText("יום הולדת"));
//        Select dropBoxList = new Select(driverOfSending.findElement(By.name("eventType")));
//        dropBoxList.selectByValue("44");
//        List<WebElement>eventsList = driverOfSending.findElements(By.className("bm-select-option"));
//        eventsList.get(1).click();
//
    }

    private void blessingText() throws MalformedURLException {
        sendKeysToElement(By.cssSelector("textarea[data-parsley-group=voucher-greeting]"), "happyB"); //works
    }

    private void uploadPict() throws MalformedURLException {
        sendKeysToElement(By.cssSelector("input[type=file") , "C:\\Users\\IMOE001\\Desktop\\IMG-20191020-WA0003.jpg");
    }

    private void goOnButtn() throws MalformedURLException {

        clickElement(By.cssSelector("button[gtm=המשך]"));
    }

    private void paymentRadioButtn() throws MalformedURLException {

//      clickElement(By.className("button-later"));
        clickElement(By.className("button-now"));

    }

    private void howSending() throws MalformedURLException {

        List<WebElement>howSendinList = driverOfSending.findElements(By.className("circle-area"));
        howSendinList.get(1).click();
        sendKeysToElement(By.cssSelector("input[type=email]") , "avivit@gmail.com");

    }
    private void senderName() throws MalformedURLException {

        sendKeysToElement(By.cssSelector("input[placeholder=\"שם שולח המתנה\"]"), "אביבית");
//        sendKeysToElement(By.xpath("//*[@id=\"ember1595\"]"), "אביבית");
    }

    private void paymentBttn() throws MalformedURLException {

        submitElement(By.cssSelector("button[type=submit]"));

    }
}
