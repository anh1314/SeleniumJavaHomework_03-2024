package BT2_Annotation;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Annotation_AddCategory extends BaseTest {

    @Test(description = "Login - Product - Category - Add new category", priority = 1)
    public  void Login_Navigate() {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        sleep(2);
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
    }

    @Test(description = "Category Information", priority = 2)
    public void AddNewCategory() {
        Login_Navigate();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
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
        sleep(3);
        driver.findElement(By.xpath("//div[@class='card-file-thumb']//img[@class='img-fit']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();

        driver.findElement(By.xpath("(//div[@class='input-group-prepend'])[2]")).click();   //Icon
        sleep(2);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("lenovo");
        sleep(3);
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

    @Test(description = "Search Category - getText Name", priority = 3)
    public void getName() {
        Login_Navigate();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Thanh Anh");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        //System.out.println("Name: " + driver.findElement(By.xpath("(//td[@class='footable-first-visible'])[1]")).getText());
        sleep(2);

        List<WebElement> listName =  driver.findElements(By.xpath("//tbody/tr/td[@class='footable-first-visible']"));
        for (WebElement element : listName.subList(0, 1)) {
            System.out.println("Name: " +element.getText());
        }
        //subList: giới hạn phần tử trong list với index chỉ định
        //listName.subList(0, 1): run từ index=0 đến index=1
    }
}
