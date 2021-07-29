package project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class LoginPage2 extends BasePage2 {


        public void login() throws MalformedURLException {
            mainLogin();
            newRegister();
            enterUserDetails();
            pressLogin();
        }

        private void mainLogin() throws MalformedURLException {
            clickElement(By.className("seperator-link"));  //link "כניסה|הרשמה"
        }

        private void newRegister() throws MalformedURLException {
            clickElement(By.xpath("//*[@id=\"ember882\"]/div/div[1]/div/div/div[3]/div[1]/span")); // link "להרשמה"
        }

        private void enterUserDetails() throws MalformedURLException {
        //enter user details for registration
        sendKeysToElement(By.className("ember-text-field"),"avivit1");
        sendKeysToElement(By.cssSelector("input[placeholder=מייל]"),"avivits9@gmal.com"); //email
        sendKeysToElement(By.cssSelector("input[placeholder=סיסמה]"),"An123456"); //password
        sendKeysToElement(By.cssSelector("input[placeholder=\"אימות סיסמה\"]"),"An123456"); //password

        }

        private void pressLogin() throws MalformedURLException {

           submitElement(By.cssSelector("button[type=submit]"));  //button "הרשמה ל-BUYME"

        }


}
