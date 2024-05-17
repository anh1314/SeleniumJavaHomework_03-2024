package eCommerceCMS.testcases;

import Common.BaseTest;
import eCommerceCMS.pages.DashboardPage;
import eCommerceCMS.pages.LoginPage;
import eCommerceCMS.pages.ProductPage;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;

    private void navigate(){
        loginPage = new LoginPage();
        loginPage.loginCMS();
        dashboardPage = new DashboardPage();
        dashboardPage.navigateToProductPage();
    }

    @Test(priority = 1)
    public void testAddNewProductSuccess(){
        navigate();
        productPage = new ProductPage();
        productPage.addNewProduct();
    }

    @Test (description = "Add product failed, Required field: locatorsProduct Name is NULL ")
    public void testAddProduct_withProductNameNull(){
        navigate();
        productPage = new ProductPage();
        productPage.addProductNullProductName();
    }

    @Test (description = "Add product failed, Required field: Unit is are NULL ")
    public void testAddProduct_withUnitNull(){
        navigate();
        productPage = new ProductPage();
        productPage.addProductNullProductName();
    }

    @Test (description = "Add product failed, Required field: Unit price is NULL ")
    public void testAddProduct_withUnitPriceNull(){
        navigate();
        productPage = new ProductPage();
        productPage.addProductNullProductName();
    }

    @Test (description = "Add product failed, Required field: Discount is NULL ")
    public void testAddProduct_withDiscountNull(){
        navigate();
        productPage = new ProductPage();
        productPage.addProductNullProductName();
    }

    @Test
    public void testEditProduct(){
        navigate();
        productPage = new ProductPage();
        productPage.editProduct();
    }

    @Test
    public void searchDataTable() {
      navigate();
        productPage = new ProductPage();
        productPage.verifyProductPage();
        productPage.searchProduct("test");
        productPage.Pagination("test");

    }
}
