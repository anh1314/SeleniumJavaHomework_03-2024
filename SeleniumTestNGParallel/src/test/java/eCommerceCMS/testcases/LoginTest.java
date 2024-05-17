package eCommerceCMS.testcases;

import eCommerceCMS.pages.DashboardPage;
import eCommerceCMS.pages.LoginPage;
import Common.BaseTest;
import constants.ConfigData;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
      LoginPage loginPage;
      DashboardPage dashboardPage;

      @Test
      public void testLoginSucess() {
            loginPage = new LoginPage();
            dashboardPage = loginPage.loginCMS();
      }

      @Test
      public void testLoginWithEmailInvalid() {
            loginPage = new LoginPage();
            loginPage.loginCMS("admin@example111.com", ConfigData.Password);
            loginPage.verifyLoginFail();
      }

      @Test
      public void testLoginWithPasswordInvalid() {
            loginPage = new LoginPage();
            loginPage.loginCMS(ConfigData.Email, "568690");
            loginPage.verifyLoginFail();
      }

      @Test
      public void testEmailNull() {
            loginPage = new LoginPage();
            loginPage.loginCMS("", ConfigData.Password);
            loginPage.verifyNullEmail();
      }

      @Test
      public void testIncorrectFormatEmail() {
            loginPage = new LoginPage();
            loginPage.loginCMS("abc", ConfigData.Password);
            loginPage.incorrectFormatEmail();
      }

      @Test
      public void testPasswordNull() {
            loginPage = new LoginPage();
            loginPage.loginCMS(ConfigData.Email, "");
            loginPage.verifyNullPassword();
      }

}
