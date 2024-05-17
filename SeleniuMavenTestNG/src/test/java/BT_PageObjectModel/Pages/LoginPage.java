package BT_PageObjectModel.Pages;

import Constants.ConfigData;
import Keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

    private By headerPage = By.xpath("//p[normalize-space()='Login to your account.']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By alertMessage = By.xpath("//div[@role='alert']");

    private void getBrownser() {
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
    }

    public DashboardPage loginCMS(String email, String password) {
        getBrownser();
        WebUI.sendKeys(inputEmail, email);
        WebUI.sendKeys(inputPassword, password);
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        return new DashboardPage(driver);
    }

    public DashboardPage loginCMS() {
        getBrownser();
        WebUI.sendKeys(inputEmail, ConfigData.Email);
        WebUI.sendKeys(inputPassword, ConfigData.Password);
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        verifyLoginSucess();
        return new DashboardPage(driver);
    }

    public void verifyNullEmail() {
        Assert.assertTrue(WebUI.verifyHTML5RequiredField(inputEmail), "Email is NOT a required field");
        WebUI.assertEquals(WebUI.getHTML5MessageField(inputEmail), "Please fill out this field.", "Validation message of Email not match");
    }

    public void verifyNullPassword() {
        Assert.assertTrue(WebUI.verifyHTML5RequiredField(inputPassword), "Password  is NOT a required field");
        WebUI.assertEquals(WebUI.getHTML5MessageField(inputPassword), "Please fill out this field.", "Validation message of Password not match");
    }

    public void incorrectFormatEmail() {
        Assert.assertTrue(WebUI.verifyHTML5RequiredField(inputEmail), "Validation message of incorrect format Email NOT exists");
        WebUI.assertEquals(WebUI.getHTML5MessageField(inputEmail), "Please include an '@' in the email address. 'abc' is missing an '@'.", "Validation message of incorrect format Email not match");
    }

    private void verifyLoginSucess() {
        Assert.assertFalse(driver.getCurrentUrl().contains("login"), "Login không thành công");
    }

    public void verifyLoginFail() {
        WebUI.checkElementDisplayed(alertMessage);
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Fail, không ở trang Login");
        WebUI.assertEquals(WebUI.getTextElement(alertMessage), "Invalid login credentials", "Content of alert message not match");
    }
}
