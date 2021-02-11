import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControlsTest() {
        browser.get("http://the-internet.herokuapp.com/dynamic_controls");
        browser.findElement(By.id("checkbox"));
        browser.findElement(By.cssSelector("[onclick='swapCheckbox()']")).click();
        new WebDriverWait(browser, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assertTrue(browser.findElements(By.id("checkbox")).isEmpty(), "Checkbox should not be displayed");

        browser.findElement(By.xpath("//*[@id='input-example']//input[@type='text']"));
        assertFalse(browser.findElement(By.xpath("//*[@id='input-example']//input[@type='text']")).isEnabled(), "Input should be disabled)");
        browser.findElement(By.cssSelector("[onclick='swapInput()']")).click();
        new WebDriverWait(browser, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-example']//*[@id='message']")));
        assertTrue(browser.findElement(By.xpath("//*[@id='input-example']//input[@type='text']")).isEnabled(), "Input should be enabled");

    }
}
