package eCommerceCMS.pages;

import drivers.DriverManager;
import helpers.ExcelHelper;
import helpers.PropertiesHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import static keywords.WebUI.*;

public class CategoryPage {

      private By buttonAddNewCategory = By.xpath("//a[@class='btn btn-primary']");
      private By inputName = By.xpath("//input[@id='name']");
      private By listParentCategory = By.xpath("//button[@title='No Parent']");
      private By searchParentCategory = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
      private By inputOrderingNumber = By.xpath("//input[@id='order_level']");
      private By droplistType = By.xpath("//select[@name='digital']");
      private By typeDigital = By.xpath("//span[normalize-space()='Digital']");
      private By browseBaner = By.xpath("(//div[@class='input-group-prepend'])[1]/div");
      private By searchImage = By.xpath("//input[@placeholder='Search your files']");
      private By image = By.xpath("//div[@class='card-file-thumb']//img[@class='img-fit']");
      private By buttonAddFiles = By.xpath("//button[normalize-space()='Add Files']");
      private By browseIcon = By.xpath("(//div[@class='input-group-prepend'])[2]");
      private By inputMetaTitle = By.xpath("//input[@placeholder='Meta Title']");
      private By inputMetaDescription = By.xpath("//textarea[@name='meta_description']");
      private By droplistFilteringAttributes = By.xpath("//div[contains(text(),'Nothing selected')]");
      private By searchFilteringAttributes = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
      private By buttonSave = By.xpath("//button[normalize-space()='Save']");
      private By alertMessage = By.xpath("//div[@role='alert']");

      private By searchCategoryName = By.xpath("//input[@id='search']");
      private By listCategoryName = By.xpath("//tbody/tr/td[@class='footable-first-visible']");
      private By editCategory = By.xpath("(//a[@title='Edit'])[1]");
      private By alertUpdateSuccess = By.xpath("//div[@role='alert']");
      private By deleteName = By.xpath("(//a[@title='Delete'])[1]");
      private By dialogDeleteCofirmation = By.xpath("// h4[normalize-space()='Delete Confirmation']");
      private By buttonDelete = By.xpath("//a[@id='delete-link']");
      private By messageDeleteSucess = By.xpath("//span[@data-notify='message']");

      ExcelHelper excelHelper = new ExcelHelper();
      private void setFileExcel(){
            excelHelper.setExcelFile(PropertiesHelper.getValue("Excel_path"), "CategoryData");
      }

      private void verifyCategoryPage() {
            Assert.assertTrue(WebUI.checkElementDisplayed(buttonAddNewCategory), "button Add New Category KHÔNG hiển thị");
            Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("categories"), "CHƯA đến trang Category");
      }

      public void addNewCategory(String categoryName) {
            setFileExcel();
            verifyCategoryPage();
            clickElement(buttonAddNewCategory);
            waitForPageLoaded();
            sendKeys(inputName, categoryName);
            selectDynamicDropdown(listParentCategory, searchParentCategory, excelHelper.getCellData(2,2)); //Parent Category
            sendKeys(inputOrderingNumber, excelHelper.getCellData(2,3)); //Ordering Number
            selectStaticDropdown(droplistType, excelHelper.getCellData(2,4));
            getImage(browseBaner, searchImage, excelHelper.getCellData(2,5), image, buttonAddFiles);
            getImage(browseIcon, searchImage, excelHelper.getCellData(2,5), image, buttonAddFiles);
            sendKeys(inputMetaTitle, excelHelper.getCellData(2,6));    //Meta Title
            sendKeys(inputMetaDescription, excelHelper.getCellData(2,7));
            clickElement(droplistFilteringAttributes);
            setTextAndKeys(searchFilteringAttributes, excelHelper.getCellData(2,8), Keys.ENTER);
            clickElement(buttonSave);
      }

      public void verifyNameRequiredField() {
            setFileExcel();
            WebUI.verifyHTML5RequiredField(inputName);
            WebUI.assertEquals(WebUI.getHTML5MessageField(inputName), excelHelper.getCellData(6,1), "Validation message not match");
      }

      public void verifyAddCategorySuccess() {
            setFileExcel();
            Assert.assertTrue(WebUI.getWebElement(alertMessage).isDisplayed(), "KHÔNG hiển thị alert message");
            WebUI.assertEquals(WebUI.getTextElement(alertMessage), excelHelper.getCellData(6,2), "Content of alert message not match");
      }

      private void searchCategoryName() {
            setFileExcel();
            WebUI.setTextAndKeys(searchCategoryName, excelHelper.getCellData(2, 1), Keys.ENTER);
            WebUI.waitForPageLoaded();
//        WebUI.sleep(2);
      }

      public void searchCategoryName(String searchText) {
            WebUI.setTextAndKeysENTER(searchCategoryName, searchText);
            WebUI.waitForPageLoaded();
            WebUI.sleep(2);
      }

      private void verifyCategoryDetail() {
            setFileExcel();
            WebUI.sleep(2);
            WebUI.assertEquals(WebUI.getAttributeElement(inputName, "value"), excelHelper.getCellData(2, 1), "Fail, giá trị Name KHÔNG đúng");
            WebUI.assertEquals(WebUI.getAttributeElement(inputOrderingNumber, "value"), excelHelper.getCellData(2, 9), "Fail, giá trị Ordering Number KHÔNG đúng");
            WebUI.sleep(2);
            WebUI.assertEquals(WebUI.getAttributeElement(inputMetaTitle, "value"), excelHelper.getCellData(2, 6), "Fail, giá trị MetaTitle KHÔNG đúng");
            WebUI.assertEquals(WebUI.getAttributeElement(inputMetaDescription, "value"), excelHelper.getCellData(2, 7), "Fail, giá trị MetaDescription KHÔNG đúng");
      }

      public void getFirstCategoryName() {
            searchCategoryName();
            WebUI.sleep(2);
            List<WebElement> listName = WebUI.getWebElements(listCategoryName);
            for (WebElement element : listName.subList(0, 1)) {
                  System.out.println("Name: " + element.getText());
            }
      }

      public void verifyEditCategory() {
            waitForPageLoaded();
            setFileExcel();
            searchCategoryName();
            WebUI.clickElement(editCategory);
            WebUI.clearAndSendKeys(inputOrderingNumber,  excelHelper.getCellData(2,9));
            WebUI.clickElement(buttonSave);
            WebUI.waitForPageLoaded();
            Assert.assertTrue(WebUI.checkElementDisplayed(alertUpdateSuccess), "Alert Update Success NOT display");
            WebUI.sleep(2);
            WebUI.assertEquals(WebUI.getTextElement(alertUpdateSuccess), excelHelper.getCellData(6,3), "content of alert Update success not match ");
            verifyCategoryDetail();
      }

      public void verifyDeleteCategory() {
            waitForPageLoaded();
            setFileExcel();
            searchCategoryName();
            WebUI.clickElement(deleteName);
            Assert.assertTrue(WebUI.checkElementDisplayed(dialogDeleteCofirmation), "dialog Delete Confirmation KHÔNG hiển thị");
            Assert.assertTrue(WebUI.checkElementEnable(buttonDelete), "button Delete NOT enabled, Can't delete item");
            WebUI.clickElement(buttonDelete);
            waitForPageLoaded();
            Assert.assertTrue(WebUI.checkElementDisplayed(messageDeleteSucess), "Không hiển thị alert messageDeleteSucess ");
            sleep(2);
            WebUI.assertEquals(WebUI.getWebElement(messageDeleteSucess).getText(), excelHelper.getCellData(6,4), "Content of messageDeleteSucess not match ");
      }

      private By listPage = By.xpath("//a[@class='page-link']");

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
