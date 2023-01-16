package TestSuite;

import Utils.Generics;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SSOPage;

import java.io.IOException;

public class Login extends Generics {

    LoginPage login;
    HomePage home;
    public Generics generic;
    public SSOPage SSO;

    @Test(priority = 1)
    public void appLaunch() throws Exception {
        generic = new Generics();
        generic.applicationLaunch(propread("browserName"));
        SSO = new SSOPage(driver);
        SSO.clickSSOBtn();
        login = new LoginPage(driver);
        login.enterUserIdAndPwd(propread("userName"), propread("passWord"));
        login.clickSignInBtn();

    }

    @Test(priority = 2)
    public void loginValidation() throws InterruptedException {
        home = new HomePage(driver);
        Assert.assertEquals(home.getTitle(), "Hello, Kiran Kumar Dash");
        System.out.println("success");
    }

    @AfterTest
    public void aftertest() {
        driver.quit();
    }


}
