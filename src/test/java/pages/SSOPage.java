package pages;

import Utils.Generics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SSOPage extends Generics {
    WebDriver driver;

    Generics generic = new Generics();

    public SSOPage(WebDriver driver) {
        this.driver = driver;
    }

    By SSOBtn = By.xpath("//*[text()='Walmart SSO']");

    By userIdField = By.xpath("//*[@id= 'username1']");

    By passwordField = By.xpath("//*[@id ='password']");

    By signInBtn = By.xpath("//*[@title ='SIGN IN']");


    public void clickSSOBtn() {
        try {
            explicitWait(driver, SSOBtn, 20);
            clickOnWebElement(SSOBtn, 20);

        } catch (Exception e) {
            System.out.println("Exception Caught" + e.getMessage());
        }
    }
}
