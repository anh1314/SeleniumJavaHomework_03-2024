package BT3_Assert;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Assert_AddCategory extends BaseTest {

      @Test(description = "Login - Product - Category - Add new category", priority = 1)
      public void Login_Navigate() {
            driver.get("https://cms.anhtester.com/login");
            // Login
            String header = driver.findElement(By.xpath("//h1[normalize-space()='Welcome to Active eCommerce CMS']")).getText();
            Assert.assertTrue(header.contains("eCommerce CMS"), "fail header");
            String header2 = driver.findElement(By.xpath("//p[normalize-space()='Login to your account.']")).getText();
            Assert.assertEquals(header2, "Login to your account.", "fail header2");
            boolean buttonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']")).isEnabled();  //Login
            Assert.assertTrue(buttonLogin, "login khong thanh cong");

            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

            //Dashboard
            WebElement Dashboard = driver.findElement(By.xpath("//div[@class='d-flex']"));
            Assert.assertTrue(Dashboard.isEnabled(), "không vào được dashboard");
            boolean menuProducts = driver.findElement(By.xpath("//span[normalize-space()='Products']")).isDisplayed();    //Products
            Assert.assertTrue(menuProducts, "menuProducts not display");
            driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();    //Products
            sleep(2);
            boolean menuCategory = driver.findElement(By.xpath("//span[normalize-space()='Category']")).isDisplayed();    //Category
            Assert.assertTrue(menuCategory, "menuCategory not display ");
            driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();    //Category
      }

      @Test(description = "Category Information", priority = 2)
      public void AddNewCategory() {
            Login_Navigate();
            boolean buttonAddNewCategory = driver.findElement(By.xpath("//a[@class='btn btn-primary']")).isEnabled();     //button Add New Category
            Assert.assertTrue(buttonAddNewCategory, "buttonAddNewCategory chưa được bật");
            driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click(); //button Add New Category

            //Category Information
            driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Thanh Anh 2");  //Name
            driver.findElement(By.xpath("//button[@title='No Parent']")).click();   //Parent Category
            driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("lap");
            driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys(Keys.ENTER);
            driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("200");  //Ordering Number
            driver.findElement(By.xpath("//button[@title='Physical']")).click(); //Type
            driver.findElement(By.xpath("//span[normalize-space()='Digital']")).click();

            driver.findElement(By.xpath("(//div[@class='input-group-prepend'])[1]/div")).click();   //Banner
            sleep(2);
            driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("lenovo");
            sleep(2);
            driver.findElement(By.xpath("//div[@class='card-file-thumb']//img[@class='img-fit']")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
            driver.findElement(By.xpath("(//div[@class='input-group-prepend'])[2]")).click();   //Icon
            sleep(2);
            driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("lenovo");
            sleep(2);

            driver.findElement(By.xpath("//div[@class='card-file-thumb']//img[@class='img-fit']")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
            driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("Lenovo Legion");  //Meta Title
            driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("RAM: 16GB DDR5 5200MHz");  //Meta description
            driver.findElement(By.xpath("//div[contains(text(),'Nothing selected')]")).click();
            driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("ca");
            driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys(Keys.ENTER);

            boolean buttonSave = driver.findElement(By.xpath("//button[normalize-space()='Save']")).isEnabled(); // button Save
            Assert.assertTrue(buttonSave, "chưa  bật buttonSave, không thể lưu dữ liệu ");
            driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();   //Save
            boolean messageSaveSuccess = driver.findElement(By.xpath("//span[@data-notify='message']")).isDisplayed(); // message Save Sucess
            Assert.assertTrue(messageSaveSuccess, "không có thông báo lưu thành công");
            sleep(2);
      }

      @Test(description = "Search Category - getText Name", priority = 3)
      public void getName() {
            Login_Navigate();
            driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Thanh Anh");
            driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
            sleep(2);

            // lấy Category Name đầu tiên, so sánh với giá trị text
            List<WebElement> listName = driver.findElements(By.xpath("//tbody/tr/td[@class='footable-first-visible']"));
            Assert.assertEquals(listName.get(0).getText(), "Thanh Anh", "Fail CategoryName");

            //Delete Category
            driver.findElement(By.xpath("(//a[@title='Delete'])[2]")).click();
            sleep(2);   //Delete Confirmation
            String dialogDeleteCofirm = driver.findElement(By.xpath("// h4[normalize-space()='Delete Confirmation']")).getText();   // dialogDeleteCofirm
            Assert.assertEquals(dialogDeleteCofirm, "Delete Confirmation", "Fail dialog Delete");
            boolean buttonDelete = driver.findElement(By.xpath("//a[@id='delete-link']")).isEnabled();  //buttonDelete
            Assert.assertTrue(buttonDelete, "button chưa được bật, không thể xóa category");
            driver.findElement(By.xpath("//a[@id='delete-link']")).click(); //click buttonDelete
            boolean messageDeleteSucess = driver.findElement(By.xpath("//span[@data-notify='message']")).isEnabled();   //messageDeleteSucess
            Assert.assertTrue(messageDeleteSucess, "không hiển thị thông báo xóa dữ liệu thành công");
      }
}
