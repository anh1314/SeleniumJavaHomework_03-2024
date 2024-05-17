package eCommerceCMS.pages;

import drivers.DriverManager;
import helpers.ExcelHelper;
import helpers.PropertiesHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductPage {

      private By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
      private By headerProduct = By.xpath("//h1[normalize-space()='All products']");
      private By buttonAddNewProduct = By.xpath("//a[@class='btn btn-circle btn-info']");
      //Product Information
      private By inputProductName = By.xpath("//input[@placeholder='Product Name']");
      private By dropListCategory = By.xpath("//div[contains(text(),'Sport shoes')]");
      private By searchCategory = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
      private By dropListBrand = By.xpath("//div[contains(text(),'Select Brand')]");
      private By searchBrand = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
      private By inputUnit = By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']");
      private By inputWeight = By.xpath("//input[@placeholder='0.00']");
      private By inputMinimumPurchaseQty = By.xpath("//input[@name='min_qty']");
      private By textboxTags = By.xpath("//span[@role='textbox']");

      //Product Images
      private By browseGalleryImages = By.xpath("//div[@data-multiple='true']//div[@class='input-group-text bg-soft-secondary font-weight-medium'][normalize-space()='Browse']");
      private By searchImages = By.xpath(" //input[@placeholder='Search your files']");
      private By linkGalleryImages = By.xpath("//img[@class='img-fit']");
      private By buttonAddFiles = By.xpath("//button[normalize-space()='Add Files']");
      private By browseThumbnailImage = By.xpath("//body/div[@class='aiz-main-wrapper']/div[@class='aiz-content-wrapper']/div[@class='aiz-main-content']/div[@class='px-15px px-lg-25px']/div/form[@id='choice_form']/div[@class='row gutters-5']/div[@class='col-lg-8']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]");
      private By linkThumbnailImage = By.xpath("//div[@class='card-file-thumb']");
      //Product Videos
      private By droplistVideoProvider = By.xpath("//button[@title='Youtube']");
      private By inputVideoLink = By.xpath("//input[@placeholder='Video Link']");
      //Product Variation
      private By enableProductVariation = By.xpath("//div[@class='col-md-1']//span");
      private By droplistColors = By.xpath("(//button[@title='Nothing selected'])[1]");
      private By searchColor = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
      private By droplistAttributes = By.xpath("(//button[@title='Nothing selected'])[2]");
      private By optionAttributes = By.xpath("//a[@id='bs-select-5-0']");
      private By droplistSize = By.xpath("//div[contains(text(),'Nothing selected')]");

      //Product price + stock
      private By inputUnitPrice = By.xpath("//input[@placeholder='Unit price']");
      private By inputDiscountDateRange = By.xpath("//input[@placeholder='Select Date']");
      private By buttonSelectDate = By.xpath("//button[@class='applyBtn btn btn-sm btn-primary']");
      private By inputDiscount = By.xpath("//input[@placeholder='Discount']");
      private By listFlat_Percent = By.xpath("a[id='bs-select-6-1'] span[class='text']");
      private By selectFlat_Percent = By.xpath("//select[@name='discount_type']");
      private By showVariant = By.xpath("//span[@class='footable-toggle fooicon fooicon-plus']");
      private By inputSKU = By.xpath("//input[@name='sku_Black']");
      private By inputQuantity = By.xpath("//input[@name='qty_Black']");

      //Product Description
      private By textboxDescription = By.xpath("//div[@role='textbox']");
      //PDF Specification
      private By choosePDFSpecification = By.xpath("//div[@data-type='document']//div[@class='input-group-text bg-soft-secondary font-weight-medium'][normalize-space()='Browse']");
      //SEO Meta Tags
      private By inputMetaTitle = By.xpath("//input[@placeholder='Meta Title']");
      private By inputDescriptionSEO = By.xpath("//textarea[@name='meta_description']");
      private By browseMetaImage = By.xpath("//div[8]//div[2]//div[3]//div[1]//div[1]//div[1]//div[1]");
      private By linkImage = By.xpath("//div[@class='card-file-thumb']");
      private By buttonSaveUnpublish = By.xpath("//button[normalize-space()='Save & Unpublish']");
      private By buttonSavePublish = By.xpath("//button[normalize-space()='Save & Publish']");
      //verify, edit,  value
      private By alertAddProductSuccess = By.xpath("//span[@data-notify='message']");
      private By alertUnitPrice_DiscountNull = By.xpath("//li[normalize-space()='The discount must be less than 0.']");
      private By editFirstProduct = By.xpath("(//a[@title='Edit'])[1]");
      private By buttonUpdateProduct = By.xpath("//button[normalize-space()='Update Product']");
      private By searchProductName = By.xpath("//input[@id='search']");
      private By alertUpdateSuccess = By.xpath("//div[@role='alert']");

      ExcelHelper excelHelper = new ExcelHelper();

      private String ProductName = "Lenovo 03-2024 02";
      private String Unit = "Kg";
      private String UnitPrice = "30000";
      private String Discount = "10";

      private String getProductName() {
            setFileExcel();
            return ProductName;
      }

      private void setFileExcel() {
            excelHelper.setExcelFile(PropertiesHelper.getValue("Excel_path"), "ProductData");
      }

      public void verifyProductPage() {
            WebUI.waitForPageLoaded();
            setFileExcel();
            Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().equals(excelHelper.getCellData(6, 1)), "CHƯA đến trang Product");
            Assert.assertTrue(WebUI.checkElementDisplayed(headerProduct), "header Product page NOT display");
            WebUI.assertEquals(WebUI.getTextElement(headerProduct), excelHelper.getCellData(6, 2), "Sai header, KHÔNG phải trang product");
            Assert.assertTrue(WebUI.checkElementEnable(buttonAddNewProduct), "button Add New Product NOT enable");
      }

      //Product Information
      private void enterProductInformation(String productName, String unit) {
            WebUI.sendKeys(inputProductName, productName);
            WebUI.selectDynamicDropdown(dropListCategory, searchCategory, excelHelper.getCellData(2, 3));
            WebUI.selectDynamicDropdown(dropListBrand, searchBrand, excelHelper.getCellData(2, 4));
            WebUI.sendKeys(inputUnit, unit);
            WebUI.clearAndSendKeys(inputWeight, excelHelper.getCellData(2, 6));
            WebUI.sendKeys(inputMinimumPurchaseQty, excelHelper.getCellData(2, 7));
            WebUI.setTextAndKeysENTER(textboxTags, excelHelper.getCellData(2, 8));
      }

      //Product Images
      private void enterProductImages() {
            WebUI.getImage(browseGalleryImages, searchImages, excelHelper.getCellData(2, 10), linkImage, buttonAddFiles);
            WebUI.getImage(browseThumbnailImage, searchImages, excelHelper.getCellData(2, 10), linkThumbnailImage, buttonAddFiles);
      }

      //Product Videos, Product Variation
      private void enterProductVideos_Variation() {
            WebUI.sendKeys(inputVideoLink, excelHelper.getCellData(2, 11));
            WebUI.clickElement(enableProductVariation);
            WebUI.selectDynamicDropdown(droplistColors, searchColor, excelHelper.getCellData(2, 12));
            WebUI.clickElement(droplistColors);
      }

      //Product price + stock
      private void enterProductPrice_Stock(String unitPrice, String discount) {
            WebUI.sendKeys(inputUnitPrice, unitPrice);
            WebUI.sendKeys(inputDiscountDateRange, excelHelper.getCellData(2, 15));
            WebUI.clickElement(buttonSelectDate);
            WebUI.clearAndSendKeys(inputDiscount, discount);
            WebUI.selectStaticDropdown(selectFlat_Percent, excelHelper.getCellData(2, 17));
            WebUI.clickElement(showVariant);
            WebUI.sleep(2);
            WebUI.sendKeys(inputSKU, excelHelper.getCellData(2, 18));
            WebUI.clearAndSendKeys(inputQuantity, excelHelper.getCellData(2, 19));
      }

      // Product Description, SEO Meta Tags
      private void enterProductDescription_SEO() {
            WebUI.sendKeys(textboxDescription, excelHelper.getCellData(2, 20));
            WebUI.sendKeys(inputDescriptionSEO, excelHelper.getCellData(2, 23));
            WebUI.sendKeys(inputMetaTitle, excelHelper.getCellData(2, 22));
            WebUI.getImage(browseMetaImage, searchImages, excelHelper.getCellData(2, 10), linkImage, buttonAddFiles);
            WebUI.clickElement(buttonSavePublish);
      }

      private void enterProductData(String productName, String unit, String unitPrice, String discount) {
            setFileExcel();
            verifyProductPage();
            setFileExcel();
            WebUI.clickElement(buttonAddNewProduct);
            enterProductInformation(productName, unit);
            enterProductImages();
            enterProductVideos_Variation();
            enterProductPrice_Stock(unitPrice, discount);
            enterProductDescription_SEO();
      }

      public void addNewProduct() {
            setFileExcel();
            enterProductData(ProductName, Unit, UnitPrice, Discount);
            WebUI.waitForPageLoaded();
            verifyAddProductSuccess();
      }

      public void addProductNullProductName() {
            setFileExcel();
            enterProductData("", Unit, UnitPrice, Discount);
            WebUI.sleep(3);
            verifyProductNameNull();
      }

      public void addProductNullUnit() {
            setFileExcel();
            enterProductData(ProductName, "", UnitPrice, Discount);
            WebUI.sleep(3);
            verifyUnitNull();
      }

      public void addProductNullUnitPrice() {
            setFileExcel();
            enterProductData(ProductName, Unit, "", Discount);
            WebUI.sleep(3);
            verifyUnitPriceNull();
      }

      public void addProductNullUnitDiscount() {
            setFileExcel();
            enterProductData(ProductName, Unit, UnitPrice, "");
            WebUI.sleep(3);
            verifyDiscountNull();
      }

      public void editProduct() {
            setFileExcel();
            verifyProductPage();
            WebUI.setTextAndKeysENTER(searchProductName, excelHelper.getCellData(2, 2));
            WebUI.clickElement(editFirstProduct);
            WebUI.waitForPageLoaded();
            WebUI.clearAndSendKeys(inputProductName, excelHelper.getCellData(2, 24));
            WebUI.sleep(2);
            WebUI.clickElement(buttonUpdateProduct);
            verifyEditProductSuccess();
      }

      // Verify
      private void verifyAddProductSuccess() {
            Assert.assertTrue(WebUI.checkElementDisplayed(alertAddProductSuccess), "alertAddProductSuccess NOT display");
            WebUI.assertEquals(WebUI.getTextElement(alertAddProductSuccess), excelHelper.getCellData(6, 3), "content of alertAddProductSuccess NOT match");
      }

      private void verifyProductNameNull() {
            WebUI.verifyHTML5RequiredField(inputProductName);
            WebUI.assertEquals(WebUI.getHTML5MessageField(inputProductName), excelHelper.getCellData(6, 4), "Validation message not match");
      }

      private void verifyUnitNull() {
            WebUI.verifyHTML5RequiredField(inputUnit);
            WebUI.assertEquals(WebUI.getHTML5MessageField(inputUnit), excelHelper.getCellData(6, 4), "Validation message not match");
      }

      private void verifyUnitPriceNull() {
            WebUI.verifyHTML5RequiredField(inputUnitPrice);
            Assert.assertTrue(WebUI.checkElementDisplayed(alertUnitPrice_DiscountNull), "alertDiscountNull NOT display");
            WebUI.assertEquals(WebUI.getTextElement(alertUnitPrice_DiscountNull), excelHelper.getCellData(6, 5), "content of UnitPrice_DiscountNull NOT match");
      }

      private void verifyDiscountNull() {
            WebUI.verifyHTML5RequiredField(inputDiscount);
            Assert.assertTrue(WebUI.checkElementDisplayed(alertUnitPrice_DiscountNull), "alertDiscountNull NOT display");
            WebUI.assertEquals(WebUI.getTextElement(alertUnitPrice_DiscountNull), excelHelper.getCellData(6, 5), "content of UnitPrice_DiscountNull NOT match");
      }

      private void verifyEditProductSuccess() {
            WebUI.waitForPageLoaded();
            Assert.assertTrue(WebUI.getWebElement(alertUpdateSuccess).isDisplayed(), "alertUpdateSuccess NOT display");
            WebUI.sleep(2);
            WebUI.assertEquals(WebUI.getTextElement(alertUpdateSuccess), excelHelper.getCellData(6, 6), "Content of alert update success NOT match");
      }
//************Handle data Table, Pagination*********************

      public void searchProduct(String searchText) {
            WebUI.setTextAndKeysENTER(searchProductName, searchText);   // search Product
            WebUI.waitForPageLoaded();
            WebUI.sleep(2);
      }

      private By listPage = By.xpath("//a[@class='page-link']");

      // Xử lý phân trang
      public void Pagination(String value) {
            // Lấy tổng số page
            int getListPage = WebUI.getWebElements(listPage).size();
            WebUI.logConsole("Số danh sách trang kết quả hiển thị: " + getListPage);

            String pageTotal = DriverManager.getDriver().findElement(By.xpath("(//a[@class='page-link'])[" + (getListPage - 1) + "]")).getText();
            WebUI.logConsole("Tổng số trang: " + pageTotal);
            int tongPage = Integer.parseInt(pageTotal);

            for (int i = 1; i <= tongPage; i++) {
                  WebUI.logConsole("\n Page" + i + ":");
                  WebUI.checkContainsValueOnTableByColumn(2, value);

                  //Nhấn nút Next để đến trang tiếp theo
                  if (i < tongPage) {
                        WebUI.clickElement(By.xpath("//a[contains(text(),'›')]"));
                        WebUI.sleep(2);
                  }
            }
      }

}
