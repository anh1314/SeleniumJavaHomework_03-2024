package eCommerceCMS.testcases;

import Common.BaseTest;
import eCommerceCMS.pages.CategoryPage;
import eCommerceCMS.pages.DashboardPage;
import eCommerceCMS.pages.LoginPage;
import helpers.ExcelHelper;
import helpers.PropertiesHelper;
import org.testng.annotations.Test;



public class CategoryTest extends BaseTest {
      LoginPage loginPage;
      DashboardPage dashboardPage;
      CategoryPage categoryPage;

      private void navigate() {
            loginPage = new LoginPage();
            loginPage.loginCMS();
            dashboardPage = new DashboardPage();
            dashboardPage.navigateToCategoryPage();
      }


      @Test(priority = 1)
      public void testAddNewCategory() {
            navigate();
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.setExcelFile(PropertiesHelper.getValue("Excel_path"), "CategoryData");

            categoryPage = new CategoryPage();
            categoryPage.addNewCategory(excelHelper.getCellData(2,1));
            categoryPage.verifyAddCategorySuccess();
            categoryPage.getFirstCategoryName();
      }

      @Test(description = "Add category failed, Required field: Name is NULL")
      public void testAddNewCategoryNull() {
            navigate();
            categoryPage = new CategoryPage();
            categoryPage.addNewCategory("");
            categoryPage.verifyNameRequiredField();
      }

      @Test(description = "update Ordering Number")
      public void testEditCategory() {
            navigate();
            categoryPage = new CategoryPage();
            categoryPage.verifyEditCategory();
      }

      @Test
      public void testDeleteCategory() {
            navigate();
            categoryPage = new CategoryPage();
            categoryPage.verifyDeleteCategory();
      }

      @Test
      public void testDataTable() {
            navigate();
            categoryPage = new CategoryPage();
            categoryPage.searchCategoryName("test");
            categoryPage.Pagination("test");
      }
}
