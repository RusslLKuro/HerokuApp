import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class InputsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
//        options.addArguments("headless");
//        options.addArguments("incognito");
//        options.addArguments("disable-notification");
        driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkInputs() {

        driver.get("http://the-internet.herokuapp.com/inputs");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).sendKeys("23456");
        String inputField = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).getAttribute("value");
        Assert.assertEquals(inputField, "23456");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).getAttribute("value"),"23457");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).getAttribute("value"),"23456");
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
