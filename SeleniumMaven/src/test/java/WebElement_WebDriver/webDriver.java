package WebElement_WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
// add new project
public class webDriver {
    public static void main(String[] args) throws InterruptedException {
   WebDriver driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   driver.get("https://crm.anhtester.com/admin/authentication");
   driver.manage().addCookie(new Cookie("sp_session", "3d0119d47174cd0fa5078185d33b2456cb0e3608"));
   driver.navigate().refresh();

   //button Project, New Project; input Project Name
    driver.findElement(By.xpath("//a[@href='https://crm.anhtester.com/admin/projects']//span")).click();
    driver.findElement(By.xpath("//div[@class='_buttons tw-mb-2 sm:tw-mb-4']/a[1]")).click();
    driver.findElement(By.xpath("//div[@class='form-group']/input[@id='name']")).sendKeys("Testing001");

     //droplist Customer
//    driver.findElement(By.xpath("(//div[@class='filter-option']/parent::button)[1] ")).click();
//    driver.findElement(By.xpath(" (//div[@class='bs-searchbox']//input)[1]")).sendKeys("VNG");
//    Thread.sleep(4000);
//    driver.findElement(By.xpath("(//span[@class='text'][normalize-space()='VNG Game'])[1]")).click();
//    Thread.sleep(2000);

            // checkbox Calculate progress through tasks
    driver.findElement(By.xpath("//div[@class='checkbox checkbox-success']/input")).click();

        // droplist Billing Type, Status, Members
    driver.findElement(By.xpath("(//div[@class='filter-option-inner']/div)[2]")).click();
    driver.findElement(By.xpath("//span[normalize-space()='Project Hours']/parent::a")).click();
    driver.findElement(By.xpath("  (//div[@class='filter-option-inner']/div[normalize-space()='In Progress'])")).click();
    driver.findElement(By.xpath("//a[@id='bs-select-2-2']/span[@class='text']")).click();
    driver.findElement(By.xpath("//button[@title='Admin Example']//span[@class='caret']")).click();
    driver.findElement(By.xpath("//a[@id='bs-select-3-1']/span[@class='text']")).click();
    driver.findElement(By.xpath(" //h4[normalize-space()='Add new project']")).click();

        //Estimated Hours; input calendar form * Start Date, Deadline
    driver.findElement(By.xpath("//div[normalize-space()='Estimated Hours']/input")).sendKeys("100");
    driver.findElement(By.xpath("//div[@class='input-group date']/input[@id='start_date']")).clear();
    driver.findElement(By.xpath("//div[@class='input-group date']/input[@id='start_date']")).sendKeys("30-03-2024");
    driver.findElement(By.xpath("//div[@class='input-group date']/input[@id='deadline']")).sendKeys("30-05-2024");
    Thread.sleep(2000);

        //  input Tags, Description
    driver.findElement(By.xpath("//li[@class='tagit-new']/input")).sendKeys("project001");
    driver.findElement(By.xpath("//div[@id='mceu_34']/iframe")).sendKeys("Testing 04/2024, Project001");

        // checkbox Send project created email; button Save
    driver.findElement(By.xpath("//input[contains(@name,'send_created_email')]")).click();
    driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

    Thread.sleep(2000);
    driver.quit();
    }
}
