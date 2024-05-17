package WebElement_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://crm.anhtester.com/admin/authentication");

        // button Login
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("(//span[@class='menu-text'])[2]")).click();
        driver.findElement(By.xpath(" (//a[@href = 'https://crm.anhtester.com/admin/clients/client'])[2]")).click();
        //add new customer
        // input Company, VAT Number, Phone, Website
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Công ty TNHH ABC");
        driver.findElement(By.xpath("//input[@id='vat']")).sendKeys("2939917");
        driver.findElement(By.xpath("//input[@name='phonenumber']")).sendKeys("0327308443");
        driver.findElement(By.xpath("//input[@id='website']")).sendKeys("www.abc.com.vn");

        // dropdown Groups
        driver.findElement(By.xpath("(//span[@class='caret'])[1]")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Gold']")).click();
        driver.findElement(By.xpath("//label[@for='company']")).click();

        // dropdown Currency
        driver.findElement(By.xpath("(//button[@title='System Default'])[1]")).click();
        driver.findElement(By.xpath("//small[normalize-space()='$']")).click();

        // dropdown Default Language
        driver.findElement(By.xpath("(//div[@class='filter-option-inner'])[3]")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Vietnamese']")).click();

        // input Address, City, State, Zip Code
        driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("Quan 7");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Ho Chi Minh City");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Đang hoạt động");
        driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("70000");

        // dropdown Country; button Save
        driver.findElement(By.xpath("//div[@app-field-wrapper='country']//div[@class='filter-option-inner-inner'][normalize-space()='Nothing selected']")).click();
        driver.findElement(By.xpath("//a[@id='bs-select-4-243']")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Save'])[2]")).click();

        Thread.sleep(2000);
       driver.quit();
    }
}
