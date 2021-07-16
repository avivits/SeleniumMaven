package project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage2 extends BasePage2 {

        public void login(){
            mainLogin();
            newRegister();
            enterUserDetails();
            pressLogin();
        }

        private void mainLogin() {
            clickElement(By.className("seperator-link"));  //link "כניסה|הרשמה"
        }

        private void newRegister(){
            clickElement(By.xpath("//*[@id=\"ember882\"]/div/div[1]/div/div/div[3]/div[1]/span")); // link "להרשמה"
        }

        private void enterUserDetails(){

     sendKeysToElement(By.className("ember-text-field"),"avivit");
//     sendKeysToElement(By.cssSelector("input[placeholder=שם פרטי"),"avivit");
     sendKeysToElement(By.cssSelector("input[placeholder=מייל]"),"avivitush17@gmal.com"); //email
     sendKeysToElement(By.cssSelector("input[placeholder=סיסמה]"),"An123456"); //password
     sendKeysToElement(By.cssSelector("input[placeholder=\"אימות סיסמה\"]"),"An123456"); //password

        }

        private void pressLogin(){

           submitElement(By.cssSelector("button[type=submit]"));  //"הרשמה ל-BUYME"

        }


}
