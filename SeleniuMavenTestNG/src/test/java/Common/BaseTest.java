package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public  WebDriver driver ;

//    @BeforeMethod
    public void createBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser( @Optional("chrome")  String browserName){
        if (browserName.equals("chrome")){
            driver = new ChromeDriver();
        }
        if (browserName.equals("edge")){
            driver = new EdgeDriver();
        }
        if (browserName.equals("firefox")){
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser(){
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public void sleep(double second){
        try{
            Thread.sleep((long) (1000*second));
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}
