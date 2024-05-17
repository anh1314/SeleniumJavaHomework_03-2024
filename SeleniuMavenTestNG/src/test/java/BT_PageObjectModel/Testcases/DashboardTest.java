package BT_PageObjectModel.Testcases;

import BT_PageObjectModel.Pages.CategoryPage;
import BT_PageObjectModel.Pages.DashboardPage;
import BT_PageObjectModel.Pages.LoginPage;
import BT_PageObjectModel.Pages.ProductPage;
import Common.BaseTest;
import Constants.ConfigData;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CategoryPage categoryPage;
    ProductPage productPage;

    @Test
    public void navigateProductPage(){
       loginPage = new LoginPage(driver);
       loginPage.loginCMS();

       dashboardPage = new DashboardPage(driver);
       productPage = dashboardPage.navigateToProductPage();
    }
    @Test
    public void testNavigateCategoryPage(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS();

        dashboardPage = new DashboardPage(driver);
        categoryPage = dashboardPage.navigateToCategoryPage();
    }
    @Test
    public void testNavigateProductPage(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS();

        dashboardPage = new DashboardPage(driver);
        productPage = dashboardPage.navigateToProductPage();
    }
    @Test
    public void testLogout(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS();

        dashboardPage = new DashboardPage(driver);
        dashboardPage.Logout();
    }
}
