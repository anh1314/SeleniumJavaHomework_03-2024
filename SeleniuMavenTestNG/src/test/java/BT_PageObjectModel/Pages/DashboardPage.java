package BT_PageObjectModel.Pages;

import Keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

    private By menuProducts = By.xpath("//span[normalize-space()='Products']");
    private By menuAllProducts = By.xpath("//span[normalize-space()='All products']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By menuAccount = By.xpath("//span[@class='d-flex align-items-center']");
    private By optionLogout = By.xpath("//span[normalize-space()='Logout']");

    private void verifyDashboardPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"), "CHƯA đến trang Dashboard");
        Assert.assertTrue(WebUI.checkElementDisplayed(menuAccount), "menu Account KHÔNG hiển thị");
    }

    public ProductPage navigateToProductPage() {
        WebUI.clickElement(menuProducts);
        WebUI.clickElement(menuAllProducts);
        verifyDashboardPage();
        return new ProductPage(driver);
    }

    public CategoryPage navigateToCategoryPage() {
        verifyDashboardPage();
        WebUI.clickElement(menuProducts);
        WebUI.clickElement(menuCategory);
        return new CategoryPage(driver);
    }

    public LoginPage Logout(){
        verifyDashboardPage();
        WebUI.clickElement(menuAccount);
        WebUI.clickElement(optionLogout);
        return new LoginPage(driver);
    }


}
