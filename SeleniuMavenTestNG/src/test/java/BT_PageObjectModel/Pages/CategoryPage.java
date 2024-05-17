package BT_PageObjectModel.Pages;

import Keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CategoryPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

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
    private By deleteName = By.xpath("(//a[@title='Delete'])[2]");
    private By dialogDeleteCofirmation = By.xpath("// h4[normalize-space()='Delete Confirmation']");
    private By buttonDelete = By.xpath("//a[@id='delete-link']");
    private By messageDeleteSucess = By.xpath("//span[@data-notify='message']");

    private void verifyCategoryPage(){
        Assert.assertTrue(WebUI.checkElementDisplayed(buttonAddNewCategory), "button Add New Category KHÔNG hiển thị");
        Assert.assertTrue(driver.getCurrentUrl().contains("categories"), "CHƯA đến trang Category");
    }

    public void addNewCategory(String categoryName){
        verifyCategoryPage();
        WebUI.clickElement(buttonAddNewCategory);
        WebUI.waitForPageLoaded();
        WebUI.sendKeys(inputName, categoryName);
        WebUI.selectDynamicDropdown(listParentCategory, searchParentCategory, "Thanh Anh"); //Parent Category
        WebUI.sendKeys(inputOrderingNumber, "300"); //Ordering Number
        WebUI.selectStaticDropdown(droplistType, "Digital");
//        WebUI.clickElement(inputBaner); //Baner
//        WebUI.setTextAndKeys(searchImage,"lenovo", Keys.ENTER);
//        WebUI.clickElement(image);
//        WebUI.clickElement(buttonAddFiles);
        WebUI.getImage(browseBaner, searchImage, "lenovo", image, buttonAddFiles);
        WebUI.getImage(browseIcon, searchImage, "lenovo", image, buttonAddFiles);
        WebUI.sendKeys(inputMetaTitle, "Lenovo Legion");    //Meta Title
        WebUI.sendKeys(inputMetaDescription, "RAM: 16GB DDR5 5200MHz");
        WebUI.clickElement(droplistFilteringAttributes);
        WebUI.setTextAndKeys(searchFilteringAttributes, "size", Keys.ENTER);
        WebUI.clickElement(buttonSave);
    }

    public void verifyNameRequiredField(){
        WebUI.verifyHTML5RequiredField(inputName);
        WebUI.assertEquals(WebUI.getHTML5MessageField(inputName), "Please fill out this field.", "Validation message not match");
    }

    public void verifyAddCategorySuccess(){
        Assert.assertTrue(WebUI.getWebElement(alertMessage).isDisplayed(), "KHÔNG hiển thị alert message");
        WebUI.assertEquals(WebUI.getTextElement(alertMessage), "Category has been inserted successfully", "Content of alert message not match");
    }

    private void searchCategoryName(){
        WebUI.setTextAndKeys(searchCategoryName, "Thanh Anh", Keys.ENTER);
        WebUI.waitForPageLoaded();
//        WebUI.sleep(2);
    }
    public void searchCategoryName(String searchText){
        WebUI.setTextAndKeysENTER(searchCategoryName, searchText);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
    }
    private void verifyCategoryDetail(){
        WebUI.assertEquals(WebUI.getAttributeElement(inputName, "value"), "Thanh Anh", "Fail, giá trị Name KHÔNG đúng");
        WebUI.assertEquals(WebUI.getAttributeElement(inputOrderingNumber, "value"), "503", "Fail, giá trị Ordering Number KHÔNG đúng");
        WebUI.assertEquals(WebUI.getAttributeElement(inputMetaTitle, "value"), "Lenovo Legion", "Fail, giá trị MetaTitle KHÔNG đúng");
        WebUI.assertEquals(WebUI.getAttributeElement(inputMetaDescription, "value"), "RAM: 16GB DDR5 5200MHz", "Fail, giá trị MetaDescription KHÔNG đúng");
    }

    public void getFirstCategoryName(){
        searchCategoryName();
        WebUI.sleep(2);
        List<WebElement> listName =  WebUI.getWebElements(listCategoryName);
        for (WebElement element : listName.subList(0, 1)) {
            System.out.println("Name: " +element.getText());
        }
    }

    public void verifyEditCategory(){
        searchCategoryName();
        WebUI.clickElement(editCategory);
        WebUI.clearAndSendKeys(inputOrderingNumber, "503");
        WebUI.clickElement(buttonSave);
        Assert.assertTrue(WebUI.checkElementDisplayed(alertUpdateSuccess), "Alert Update Success NOT display");
        WebUI.assertEquals(WebUI.getTextElement(alertUpdateSuccess), "Category has been updated successfully", "content of alert Update success not match ");
        verifyCategoryDetail();
    }

    public void verifyDeleteCategory(){
        searchCategoryName();
        WebUI.clickElement(deleteName);
        Assert.assertTrue(WebUI.checkElementDisplayed(dialogDeleteCofirmation), "dialog Delete Confirmation KHÔNG hiển thị");
        Assert.assertTrue(WebUI.checkElementEnable(buttonDelete), "button Delete NOT enabled, Can't delete item");
        WebUI.clickElement(buttonDelete);
        Assert.assertTrue(WebUI.checkElementDisplayed(messageDeleteSucess), "Không hiển thị alert messageDeleteSucess ");
        WebUI.assertEquals(WebUI.getWebElement(messageDeleteSucess).getText(),"Category has been deleted successfully", "Content of messageDeleteSucess not match ");
    }

    private By listPage = By.xpath("//a[@class='page-link']");

    public void Pagination(String value) {
        // Lấy tổng số page
        int getListPage = WebUI.getWebElements(listPage).size();
        WebUI.logConsole("Số danh sách trang kết quả hiển thị: " + getListPage);

        String pageTotal = driver.findElement(By.xpath("(//a[@class='page-link'])[" + (getListPage - 1) + "]")).getText();
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
