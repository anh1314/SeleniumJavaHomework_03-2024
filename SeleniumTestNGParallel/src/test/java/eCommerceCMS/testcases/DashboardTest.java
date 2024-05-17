package eCommerceCMS.testcases;

import eCommerceCMS.pages.*;
import Common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
      LoginPage loginPage;
      DashboardPage dashboardPage;
      CategoryPage categoryPage;
      ProductPage productPage;
      BrandPage brandPage;

      @Test
      public void navigateProductPage() {
            loginPage = new LoginPage();
            loginPage.loginCMS();

            dashboardPage = new DashboardPage();
            productPage = dashboardPage.navigateToProductPage();
      }

      @Test
      public void testNavigateCategoryPage() {
            loginPage = new LoginPage();
            loginPage.loginCMS();

            dashboardPage = new DashboardPage();
            categoryPage = dashboardPage.navigateToCategoryPage();
      }

      @Test
      public void testNavigateProductPage() {
            loginPage = new LoginPage();
            loginPage.loginCMS();

            dashboardPage = new DashboardPage();
            productPage = dashboardPage.navigateToProductPage();
      }

      @Test
      public void testLogout() {
            loginPage = new LoginPage();
            loginPage.loginCMS();

            dashboardPage = new DashboardPage();
            dashboardPage.Logout();
      }

      @Test
      public void testNavigateBrandPage(){
            loginPage = new LoginPage();
            loginPage.loginCMS();

            dashboardPage = new DashboardPage();
            brandPage = dashboardPage.navigateToBrandPage();

      }
}
