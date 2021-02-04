import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TyposTest {

    @Test
    public void spellcheck() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/typos");
        WebElement text = browser.findElement(By.id("content"));
        assertEquals(text.getText(), "Typos" + "\n" +
                "This example demonstrates a typo being introduced. It does it randomly on each page load." + "\n" +
                "Sometimes you'll see a typo, other times you won't.");
        browser.quit();

    }
}


