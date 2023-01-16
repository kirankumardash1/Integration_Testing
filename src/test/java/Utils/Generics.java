package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Generics {
    public static WebDriver driver;

    static Properties  obj;
    public void applicationLaunch (String browserName) throws Exception {
        if(browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","/Users/k0d0866/WORK/Automation/Driver/geckodriver");
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","/Users/k0d0866/WORK/Automation/Driver/chromedriver");
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("Safari")){
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }else{
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(propread("URL"));
        driver.manage().window().maximize();
    }

    public String propread  (String key) throws IOException {
        obj = new Properties();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/application.properties");
        obj.load(objfile);
        String value = obj.getProperty(key);
        return value;
    }

    public void clickOnWebElement(By element, long waitTimeInSeconds) throws InterruptedException {
        WebElement webElement = driver.findElement(element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
        WebElement elements = null;
        elements = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        elements.click();

    }

    public void sendKeysOnWebElement(By element, String text){
        WebElement webElement = driver.findElement(element);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(text);
    }

    public  void explicitWait(WebDriver driver,By element, int waitTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public boolean checkIfElementPresent (By element){
        Boolean isElementPresent = driver.findElements(element).size()>0;
        return isElementPresent;
    }
    public boolean checkIfElementDisplayed (By element){
        WebElement webElement= driver.findElement(element);
        Boolean isElementDisplayed = webElement.isDisplayed();
        return isElementDisplayed;
    }

    public String getText(By element){
        WebElement webElement= driver.findElement(element);
        String text =webElement.getText();
        return text;
    }
}
