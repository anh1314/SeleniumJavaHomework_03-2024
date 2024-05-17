package BT_PageObjectModel.Testcases;

import BT_PageObjectModel.Pages.DashboardPage;
import BT_PageObjectModel.Pages.LoginPage;
import Common.BaseTest;
import Constants.ConfigData;
import Keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testLoginSucess() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCMS();
    }

    @Test
    public void testLoginWithEmailInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.loginCMS("admin@example111.com", ConfigData.Password);
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginWithPasswordInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.loginCMS(ConfigData.Email, "568690");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testEmailNull(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS("", ConfigData.Password);
        loginPage.verifyNullEmail();
    }
    @Test
    public void testIncorrectFormatEmail(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS("abc", ConfigData.Password);
        loginPage.incorrectFormatEmail();
    }
    @Test
    public void testPasswordNull(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS(ConfigData.Email, "");
        loginPage.verifyNullPassword();
    }

}
