package Keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class WebUI {
    private static int Timeout = 10;
    private static double ThreadSleep = 0.5;
    private static int PageLoadTimeout = 30;

    private static WebDriver driver;

    // Constructor
    public WebUI(WebDriver driver) {
        this.driver = driver;
    }

    // Log console
    public static void logConsole(Object message) {
        System.out.println(message);
    }

    // Open URL
    public static void openURL(String URL) {
        driver.get(URL);
        logConsole("Navigate to: " + URL);
    }


    // Get WebElement
    public static WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    // Get list WebElement
    public static List<WebElement> getWebElements(By by) {
        return driver.findElements(by);
    }

    // Get text
    public static String getTextElement(By by) {
        waitForElementVisible(by);
        String text = getWebElement(by).getText();
        logConsole("Get text of element " + by + " is " + text);
        return text;
    }

    // Get Attribute element
    public static String getAttributeElement(By by, String attribute){
        waitForElementVisible(by);
        String value = getWebElement(by).getAttribute(attribute);
        logConsole("Get attribute of element " +by+ " is " +value);
        return value;
    }

    // Check element exist
    public static boolean checkElementExist(By by){
        List<WebElement> listElement = getWebElements(by);
        if(listElement.size() > 0){
            System.out.println("Element " +by+ "exist");
            return true;
        }else {
            System.out.println("Element " +by+ "NOT exist");
            return false;
        }
    }

    // Check element Displayed
    public static boolean checkElementDisplayed(By by){
        waitForElementVisible(by);
        boolean check = getWebElement(by).isDisplayed();
        return check;
    }
    // Check element Enable
    public static boolean checkElementEnable(By by){
        waitForElementVisible(by);
        boolean check = getWebElement(by).isEnabled();
        return check;
    }

    // Check search table by column (xử lý cột trên 1 trang)
    public static void checkContainsValueOnTableByColumn(int column, String value) {
        List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr"));
        logConsole("Number of results for keywords (" + value + "): " + totalRows.size());

        if (totalRows.size() < 1) {
            logConsole("Not found value: " + value);
        } else {
            for (int i = 1; i <= totalRows.size(); i++) {
                boolean res = false;
                WebElement title = getWebElement(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(false);", title); // lăn chuột xuống

                res = title.getText().toUpperCase().contains(value.toUpperCase());
                logConsole("Row " + i + ": " + title.getText());
                Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + "NOT contains the search value: " + value);
            }
        }
    }

    // Click element
    public static void clickElement(By by){
        waitForElementClickable(by);
        getWebElement(by).click();
        logConsole("Click on element " +by);
    }
    // Click element  với seconds là giá trị thay đổi
    public static void clickElement(By by, int seconds){
        waitForElementClickable(by, seconds);
        getWebElement(by).click();
        logConsole("Click on element  " +by+ " with timeout is " + seconds + " seconds ");
    }

    // Clear and sendKeys
    public static void clearAndSendKeys(By by, String text){
        waitForElementVisible(by);
        getWebElement(by).clear();
        getWebElement(by).sendKeys(text);
        logConsole("Clear and Set text " +text+ " on input " +by);
    }
    // sendKeys
    public static void sendKeys(By by, String text){
        waitForElementVisible(by);
        getWebElement(by).sendKeys(text);
        logConsole("Set text " +text+ " on input " +by);
    }
    // sendKeys với seconds là giá trị thay đổi
    public static void sendKeys(By by, String text, int seconds){
        waitForElementVisible(by, seconds);
        getWebElement(by).sendKeys(text);
        logConsole("Set text " + text + " on input " + by + " with timeout is " + seconds + " seconds ");
    }

    //Keys.ENTER
    public static void setTextAndKeysENTER(By by, String value){
        waitForElementVisible(by);
        getWebElement(by).sendKeys(value, Keys.ENTER);
        sleep(2);
        System.out.println("Set text: " + value + " on element " + by);
    }

    // Set text and Keys
    public static void setTextAndKeys(By by, String value, Keys key){
        waitForPageLoaded();
        getWebElement(by).sendKeys(value, key);
        System.out.println("Set text: " + value + " on element " + by);
    }

    // Verify Equals
    public static boolean verifyEquals(Object actual, Object expected){
        waitForPageLoaded();
        logConsole("Verify equals: " +actual+ " and " +expected);
        boolean check = actual.equals(expected);
        return check;
    }
    // Assert Equals
    public static void assertEquals(Object actual, Object expected, String message){
        waitForPageLoaded();
        logConsole("Assert equals " +actual+ " and " +expected);
        Assert.assertEquals(actual, expected, message);
    }

    // Verify Contains
    public static boolean verifyContains(String actual, String expected){
        waitForPageLoaded();
        logConsole("Verify contains " +actual+ " and " +expected);
        boolean check = actual.contains(expected);
        return check;
    }
    //Assert Contains
    public static void assertContains(String actual, String expected, String message){
        waitForPageLoaded();
        logConsole("Assert contains " +actual+ " and " +expected);
        boolean check = actual.contains(expected);
        Assert.assertTrue(check, message);
    }

    public static void getImage(By browse, By search, String textSearch, By image, By buttonAdd ){
        clickElement(browse);
        setTextAndKeysENTER(search, textSearch);
        sleep(2);
        clickElement(image);
        clickElement(buttonAdd);
    }

    //Static droplist
    public static void selectStaticDropdown(By dropdownBy, String optionText) {
        Select dropdown = new Select(getWebElement(dropdownBy));
        dropdown.selectByVisibleText(optionText);
    }
    //Dynamic dropdown (Show only 1 search result)
    public static void selectDynamicDropdown(By dropdownBy, By searchBy, String searchText) {
        clickElement(dropdownBy);
        waitForPageLoaded();
       setTextAndKeysENTER(searchBy, searchText );
    }

    //*********HTML5******

    public static Boolean verifyHTML5RequiredField(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean verifyRequired = (Boolean) js.executeScript("return arguments[0].required;", getWebElement(by));
        logConsole("check HTML5 Required Field exists " +by);
        return verifyRequired;
    }
    public static String getHTML5MessageField(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String message = (String) js.executeScript("return arguments[0].validationMessage;", getWebElement(by));
        return message;
    }
    public static Boolean verifyHTML5ValidValueField(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean verifyValid = (Boolean) js.executeScript("return arguments[0].validity.valid;", getWebElement(by));
        return verifyValid;
    }

    // ************* Javascript Executor, Actions class, Robot class ************

    //cuộn chuột đến vị trí element (đối tượng By)
    public static void scrollToElement(By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", by);
    }
    // cuộn chuột đến vị trí element (đối tượng WebElement)
    public static void scrollToElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    // di chuyển chuột đến vị trí element
    public static boolean moveToElement(By toElement) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            logConsole(e.getMessage());
            return false;
        }
    }

    //di chuyển chuột đến vị trí element
    public static boolean mouseHover(By by) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // kéo thả chuột
    public static boolean dragAndDrop(By fromElement, By toElement) {
        try {
            Actions action = new Actions(driver);
            action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
            //action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            logConsole(e.getMessage());
            return false;
        }
    }

    // nhấn và giữ chuột
    public static boolean clickAndHoldElement(By fromElement, By toElement) {
        try {
            Actions action = new Actions(driver);
            action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            logConsole(e.getMessage());
            return false;
        }
    }

    // nhấn phím ENTER
    public static boolean pressENTER() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Nhấn phím ESC
    public static boolean pressESC() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Nhấn phím F11
    public static boolean pressF11() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F11);
            robot.keyRelease(KeyEvent.VK_F11);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Tô màu viền đỏ cho element
    public static WebElement highLightElement(By by) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", getWebElement(by));
            sleep(1);
        }
        return getWebElement(by);
    }

// ************* Wait ************

    //visibilityOfElementLocated
    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible " + by.toString());
            logConsole("Timeout waiting for the element Visible " + by.toString());
        }
    }
    //visibilityOfElementLocated với seconds là giá trị thay đổi
    public static void waitForElementVisible(By by, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible " + by.toString());
            logConsole("Timeout waiting for the element Visible " + by.toString());
        }
    }

    // Wait for elementToBeClickable
    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Clickable" + by.toString());
            logConsole("Timeout waiting for the element Clickable" + by.toString());
        }
    }
    // Wait for elementToBeClickable  với seconds là giá trị thay đổi
    public static void waitForElementClickable(By by, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Clickable" + by.toString());
            logConsole("Timeout waiting for the element Clickable" + by.toString());
        }
    }

    //presenceOfElementLocated
    public static void waitForElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Element not exits " + by.toString());
            logConsole("Element not exits " + by.toString());
        }
    }
    //presenceOfElementLocated với seconds là giá trị thay đổi
    public static void waitForElementPresent(By by, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Element not exits " + by.toString());
            logConsole("Element not exits " + by.toString());
        }
    }

    // Wait For Page Loaded:  chờ trang load xong mới thao tác
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };
//        Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");
//        Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
//            Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }

    // Thread.sleep
    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (1000 * seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // chụp màn hình
    public static void captureScreenImage(String imageName) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
//        Get size screen browser
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
//        Khởi tạo kích thước khung hình với kích cỡ trên
        Rectangle screenRectangle = new Rectangle(screenSize);
//        Tạo hình chụp với độ lớn khung đã tạo trên
        BufferedImage image = robot.createScreenCapture(screenRectangle);
//        Lưu hình vào dạng file với dạng png
        File file = new File("src/test/resources/screenshots/" + imageName + ".png");
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
