import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CheckboxesTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
//        options.addArguments("headless");
//        options.addArguments("incognito");
//        options.addArguments("disable-notification");
        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkCheckboxes() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        boolean checkboxOne = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)")).isSelected();
        softAssert.assertFalse(checkboxOne);
        driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)")).click();
        boolean checkboxOneAfterClick = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)")).isSelected();
        softAssert.assertTrue(checkboxOneAfterClick);

        boolean checkboxTwo = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)")).isSelected();
        softAssert.assertTrue(checkboxTwo);
        driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)")).click();
        boolean checkboxTwoAfterClick = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)")).isSelected();
        softAssert.assertFalse(checkboxTwoAfterClick);
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
