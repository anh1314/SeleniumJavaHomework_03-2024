package BT_PageObjectModel.Testcases;

import BT_PageObjectModel.Pages.CategoryPage;
import BT_PageObjectModel.Pages.DashboardPage;
import BT_PageObjectModel.Pages.LoginPage;
import Common.BaseTest;
import Constants.ConfigData;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CategoryPage categoryPage;

    private void navigate() {
        loginPage = new LoginPage(driver);
        loginPage.loginCMS();
        dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToCategoryPage();
    }

    @Test
    public void testAddNewCategory() {
        navigate();
        categoryPage = new CategoryPage(driver);
        categoryPage.addNewCategory("Thanh Anh");
        categoryPage.verifyAddCategorySuccess();
        categoryPage.getFirstCategoryName();
    }

    @Test(description = "Add category failed, Required field: Name is NULL")
    public void testAddNewCategoryNull() {
        navigate();
        categoryPage = new CategoryPage(driver);
        categoryPage.addNewCategory("");
        categoryPage.verifyNameRequiredField();
    }

    @Test(description = "update Ordering Number")
    public void testEditCategory() {
        navigate();
        categoryPage = new CategoryPage(driver);
        categoryPage.verifyEditCategory();
    }

    @Test
    public void testDeleteCategory() {
        navigate();
        categoryPage = new CategoryPage(driver);
        categoryPage.verifyDeleteCategory();
    }

    @Test
    public void testDataTable(){
        navigate();
        categoryPage = new CategoryPage(driver);
        categoryPage.searchCategoryName("test");
        categoryPage.Pagination("test");
    }
}
