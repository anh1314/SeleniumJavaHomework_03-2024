package eCommerceCMS.testcases;

import Common.BaseTest;
import eCommerceCMS.pages.BrandPage;
import eCommerceCMS.pages.DashboardPage;
import eCommerceCMS.pages.LoginPage;
import helpers.ExcelHelper;
import helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class BrandTest extends BaseTest {
      LoginPage loginPage = new LoginPage();
      DashboardPage dashboardPage = new DashboardPage();
      BrandPage brandPage = new BrandPage();
      ExcelHelper excelHelper = new ExcelHelper();

      @Test
      public void testAddNewBrand() {
            loginPage.loginCMS();
            dashboardPage.navigateToBrandPage();

            excelHelper.setExcelFile(PropertiesHelper.getValue("Excel_path"), "BrandData");
            brandPage.addBrand(excelHelper.getCellData(2, 1));
            brandPage.verifyAddBrandSuccess();
      }

      @Test
      public void testAddBrandNullName() {
            loginPage.loginCMS();
            dashboardPage.navigateToBrandPage();

            brandPage.addBrand("");
            brandPage.verifyNameRequiredField();
      }
}
