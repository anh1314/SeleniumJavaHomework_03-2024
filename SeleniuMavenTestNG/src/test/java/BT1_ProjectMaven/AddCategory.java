package BT1_ProjectMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class AddCategory {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://cms.anhtester.com/login");

        //Login > Product > Category
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();

        //Add new category - Category Information
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Thanh Anh");  //Name
        driver.findElement(By.xpath("//button[@title='No Parent']")).click();   //Parent Category
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("lap");
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("200");  //Ordering Number

       driver.findElement(By.xpath("//button[@title='Physical']")).click(); //Type
        driver.findElement(By.xpath("//span[normalize-space()='Digital']")).click();
        driver.findElement(By.xpath("(//div[@class='input-group-prepend'])[1]/div")).click();   //Banner
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("lenovo");
        driver.findElement(By.xpath("//div[@class='card-file-thumb']//img[@class='img-fit']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();

        driver.findElement(By.xpath("(//div[@class='input-group-prepend'])[2]")).click();   //Icon
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("lenovo");
        driver.findElement(By.xpath("//div[@class='card-file-thumb']//img[@class='img-fit']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("Lenovo Legion");  //Meta Title

        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("RAM: 16GB DDR5 5200MHz");  //Meta description
        driver.findElement(By.xpath("//div[contains(text(),'Nothing selected')]")).click(); //Filtering Attributes
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("size");
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();   //Save
        Thread.sleep(2000);

        //Search Category - getText Name
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Thanh Anh");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
       // System.out.println("Name: " + driver.findElement(By.xpath("(//td[@class='footable-first-visible'])[1]")).getText());
        Thread.sleep(2000);

        List<WebElement> listName =  driver.findElements(By.xpath("//tbody/tr/td[@class='footable-first-visible']"));
        for (WebElement element : listName.subList(0, 1)) {
            System.out.println("Name: " +element.getText());
        }
        driver.quit();
    }
}
