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
import java.util.List;
import java.util.Objects;

public class AddRemoveElementsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
//        options.addArguments("headless");
//        options.addArguments("incognito");
//        options.addArguments("disable-notification");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkAddRemoveElements() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        WebElement[] buttonsDeleteBefore = driver.findElements(By.xpath("//button[text()='Delete']")).toArray(new WebElement[0]);
        softAssert.assertEquals(buttonsDeleteBefore.length, 2);
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        WebElement[] buttonsDeleteAfter = driver.findElements(By.xpath("//button[text()='Delete']")).toArray(new WebElement[0]);
        softAssert.assertEquals(buttonsDeleteAfter.length, 1);
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
