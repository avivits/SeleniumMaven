package project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SendingPresent extends BasePage2{

    private WebDriver driverOfSending;

    public SendingPresent(){
        driverOfSending=DriverSingleton2.getDriverInstance();

    }

    public void send(){
       // printColor(); //extra
        sendingTo();
        receiverName();
        pickEvent();
        blessingText();
        uploadPict();
        goOnButtn();
        paymentRadioButtn();
        howSending();
        senderName();
        paymentBttn();
    }

//    private void printColor(){
////        String buttonColor = driverOfSending.findElement(By.name("submit")).getCssValue("background-color");
        String textColor = driverOfSending.findElement(By.className("label bottom-xs")).getCssValue("background-color");
        String textColor1 = driverOfSending.findElement(By.className("label bottom-xs")).getCssValue("color");
//        System.out.println("text color: " + textColor);
//    }

    private void sendingTo(){
//        clickElement(By.className("button-forMyself"));
        clickElement(By.className("button-forSomeone"));
    }

    private void receiverName(){
        sendKeysToElement((By.id("friendName")), "אבא");

    }

    private void pickEvent(){  //לא הצלחתי לבחור אירוע בגלילה
        clickElement(By.className("selected-name"));
//        Select dropBoxList = new Select(driverOfSending.findElement(By.name("eventType")));
//        dropBoxList.selectByValue("44");
//        List<WebElement>eventsList = driverOfSending.findElements(By.className("selected-text"));
//        eventsList.get(3).click();
//
    }

    private void blessingText(){
        sendKeysToElement(By.cssSelector("textarea[data-parsley-group=voucher-greeting]"), "happyB"); //works
    }

    private void uploadPict(){
        sendKeysToElement(By.cssSelector("input[type=file") , "C:\\Users\\IMOE001\\Desktop\\IMG-20191020-WA0003.jpg");
    }

    private void goOnButtn(){

        clickElement(By.cssSelector("button[gtm=המשך]"));
    }

    private void paymentRadioButtn(){

//      clickElement(By.className("button-later"));
        clickElement(By.className("button-now"));

    }

    private void howSending(){

        List<WebElement>howSendinList = driverOfSending.findElements(By.className("circle-area"));
        howSendinList.get(1).click();
        sendKeysToElement(By.cssSelector("input[type=email]") , "avivit@gmail.com");

    }
    private void senderName(){

        sendKeysToElement(By.cssSelector("input[placeholder=\"שם שולח המתנה\"]"), "אביבית");
//        sendKeysToElement(By.xpath("//*[@id=\"ember1595\"]"), "אביבית");
    }

    private void paymentBttn() {

        submitElement(By.cssSelector("button[type=submit]"));

    }
}
