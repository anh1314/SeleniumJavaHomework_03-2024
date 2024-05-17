package BT_PageObjectModel.Testcases;

import BT_PageObjectModel.Pages.DashboardPage;
import BT_PageObjectModel.Pages.LoginPage;
import BT_PageObjectModel.Pages.ProductPage;
import Common.BaseTest;
import Constants.ConfigData;
import Keywords.WebUI;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;

    private void navigate(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS();
        dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToProductPage();
    }

    @Test
    public void testAddNewProductSuccess(){
        navigate();
        productPage = new ProductPage(driver);
        productPage.addNewProduct();
    }

    @Test (description = "Add product failed, Required field: Product Name is NULL ")
    public void testAddProduct_withProductNameNull(){
        navigate();
        productPage = new ProductPage(driver);
        productPage.addProductNullProductName();
    }

    @Test (description = "Add product failed, Required field: Unit is are NULL ")
    public void testAddProduct_withUnitNull(){
        navigate();
        productPage = new ProductPage(driver);
        productPage.addProductNullProductName();
    }

    @Test (description = "Add product failed, Required field: Unit price is NULL ")
    public void testAddProduct_withUnitPriceNull(){
        navigate();
        productPage = new ProductPage(driver);
        productPage.addProductNullProductName();
    }

    @Test (description = "Add product failed, Required field: Discount is NULL ")
    public void testAddProduct_withDiscountNull(){
        navigate();
        productPage = new ProductPage(driver);
        productPage.addProductNullProductName();
    }

    @Test
    public void testEditProduct(){
        navigate();
        productPage = new ProductPage(driver);
        productPage.editProduct();
    }

    @Test
    public void searchDataTable() {
      navigate();
        productPage = new ProductPage(driver);
        productPage.verifyProductPage();
        productPage.searchProduct("test");
        productPage.Pagination("test");

    }
}
