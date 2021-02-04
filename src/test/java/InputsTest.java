import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class InputsTest {

    @Test
    public void inputUpDown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = browser.findElement(By.tagName("input"));
        input.sendKeys("42");
        input.sendKeys(Keys.ARROW_UP);
        String inputup = input.getAttribute("value");
        assertEquals(inputup, "43");
        input.sendKeys(Keys.ARROW_DOWN);
        String inputdown = input.getAttribute("value");
        assertEquals(inputdown, "42");
        input.sendKeys("Qwertys");
        input.sendKeys(Keys.ARROW_UP);
        String inputupletters = input.getAttribute("value");
        assertEquals(inputupletters, "1");
        input.sendKeys(Keys.ARROW_DOWN);
        String inputdownletters = input.getAttribute("value");
        assertEquals(inputdownletters, "0");
        browser.quit();
    }
}
