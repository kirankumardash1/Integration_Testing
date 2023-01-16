package pages;

import Utils.Generics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Generics {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By userName = By.xpath("//*[text()='Hello, Kiran Kumar Dash']");

    public String getTitle() {
        try {
            explicitWait(driver, userName, 30);
            return getText(userName);
        } catch (Exception e) {
            System.out.println("Exception Caught" + e.getMessage());
            return null;
        }
    }

}




