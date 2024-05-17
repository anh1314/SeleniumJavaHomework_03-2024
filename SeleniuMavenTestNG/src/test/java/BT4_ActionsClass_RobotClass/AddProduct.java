package BT4_ActionsClass_RobotClass;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AddProduct extends BaseTest {

      @Test(description = "Login - Product", priority = 1)
      public void Login_Navigate() {
            driver.get("https://cms.anhtester.com/login");
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
            driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();    //menu Products
            sleep(2);
      }

      @Test(priority = 2)
      public void AddNewCategory() {
            Login_Navigate();
            driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();   //menu Category
            driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();  //button Add New Category
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
            driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();   //Save
            sleep(3);
      }

      @Test(priority = 3)
      public void AddNewProduct() {
            Login_Navigate();
            driver.findElement(By.xpath(LocatorsAddProduct.menuAddNewProduct)).click();
            //Product Information
            driver.findElement(By.xpath(LocatorsAddProduct.inputProductName)).sendKeys("Lenovo01"); //Product Name *
            driver.findElement(By.xpath(LocatorsAddProduct.dropListCategory)).click();  //Category *
            driver.findElement(By.xpath(LocatorsAddProduct.searchCategory)).sendKeys("Thanh Anh");
            driver.findElement(By.xpath(LocatorsAddProduct.searchCategory)).sendKeys(Keys.ENTER);
            driver.findElement(By.xpath(LocatorsAddProduct.dropListBrand)).click(); //Brand
            driver.findElement(By.xpath(LocatorsAddProduct.searchBrand)).sendKeys("BrandTest01");
            driver.findElement(By.xpath(LocatorsAddProduct.searchBrand)).sendKeys(Keys.ENTER);
            driver.findElement(By.xpath(LocatorsAddProduct.inputUnit)).sendKeys("Kg");  //Unit
            driver.findElement(By.xpath(LocatorsAddProduct.inputWeight)).sendKeys("3"); //Weight (In Kg)
            driver.findElement(By.xpath(LocatorsAddProduct.inputMinimumPurchaseQty)).sendKeys("10");  //Minimum Purchase Qty *
            driver.findElement(By.xpath(LocatorsAddProduct.textboxTags)).sendKeys("legion lenovo laptop"); //Tags *
            driver.findElement(By.xpath(LocatorsAddProduct.textboxTags)).sendKeys(Keys.ENTER);

            //Product Images
            driver.findElement(By.xpath(LocatorsAddProduct.GalleryImages)).click(); //Gallery Images
            sleep(2);
            driver.findElement(By.xpath(LocatorsAddProduct.searchImages)).sendKeys("Lenovo");
            sleep(2);
            driver.findElement(By.xpath(LocatorsAddProduct.linkGalleryImages)).click();
            driver.findElement(By.xpath(LocatorsAddProduct.buttonAddFiles)).click();
            driver.findElement(By.xpath(LocatorsAddProduct.ThumbnailImage)).click();  //Thumbnail Image
            sleep(2);
            driver.findElement(By.xpath(LocatorsAddProduct.searchImages)).sendKeys("Lenovo");
            sleep(2);
            driver.findElement(By.xpath(LocatorsAddProduct.linkThumbnailImage)).click();
            driver.findElement(By.xpath(LocatorsAddProduct.buttonAddFiles)).click();
            sleep(2);

            //Product Videos
            driver.findElement(By.xpath(LocatorsAddProduct.VideoLink)).sendKeys("https://www.youtube.com/channel/lenovo");   //Video Link
            //Product Variation
            //driver.findElement(By.xpath(LocatorsAddProduct.enableProductVariation)).click();

            //Product price + stock
            driver.findElement(By.xpath(LocatorsAddProduct.UnitPrice)).sendKeys("30000000");   //Unit price *
            driver.findElement(By.xpath(LocatorsAddProduct.DiscountDateRange)).sendKeys("24-04-2024 00:00:00 to 20-05-2024 12:00:00");  //Discount Date Range
            sleep(2);
            driver.findElement(By.xpath(LocatorsAddProduct.Discount)).sendKeys("10");   //Discount
            driver.findElement(By.xpath(LocatorsAddProduct.Quantity)).sendKeys("5");    //Quantity *
            driver.findElement(By.xpath(LocatorsAddProduct.SKU)).sendKeys("MGG");

            //Product Description
            driver.findElement(By.xpath(LocatorsAddProduct.Description)).sendKeys("Test product");    //Description
            //SEO Meta Tags
            driver.findElement(By.xpath(LocatorsAddProduct.MetaTitle)).sendKeys("Tính năng của Lenovo Legion");  //Meta Title
            driver.findElement(By.xpath(LocatorsAddProduct.DescriptionSEO)).sendKeys("test SEO 01"); //Description
            driver.findElement(By.xpath(LocatorsAddProduct.MetaImage)).click(); //Meta Image
            sleep(2);
            driver.findElement(By.xpath(LocatorsAddProduct.searchImages)).sendKeys("lenovo");
            sleep(2);
            driver.findElement(By.xpath(LocatorsAddProduct.linkImage)).click();
            driver.findElement(By.xpath(LocatorsAddProduct.buttonAddFiles)).click();
            sleep(2);
            driver.findElement(By.xpath(LocatorsAddProduct.buttonSavePublish)).click();
            sleep(2);

      }
}
//driver.findElement(By.xpath(LocatorsAddProduct.)).sendKeys();
//driver.findElement(By.xpath(LocatorsAddProduct.)).click();