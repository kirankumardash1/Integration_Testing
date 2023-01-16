package pages;

import Utils.Generics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Generics {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userIdField = By.xpath("//*[@id= 'username1']");

    By passwordField = By.xpath("//*[@id ='password']");

    By signInBtn = By.xpath("//*[@title ='SIGN IN']");


    public void enterUserIdAndPwd(String userId, String password) {

        try {

            if (checkIfElementPresent(userIdField)) {
                sendKeysOnWebElement(userIdField, userId);

                //Check only if username field is present
                if (checkIfElementDisplayed(passwordField)) {
                    sendKeysOnWebElement(passwordField, password);
                }
            }


        } catch (Exception e) {
            System.out.println("Exception Caught in entering user id and password" + e.getMessage());
        }
    }

    public void clickSignInBtn() {
        try {
            if (checkIfElementPresent(signInBtn)) {
                clickOnWebElement(signInBtn, 20);
                System.out.println("Sign in button clicked");
            }
        } catch (Exception e) {
            System.out.println("Exception caught in Signin Button " + e.getMessage());
        }

    }
}
