import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class CheckboxesTest {

    @Test
    public void checkedUncheked() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkbox = browser.findElements(By.cssSelector("[type=checkbox]"));
        assertFalse(checkbox.get(0).isSelected());//проверить, что первый чекбокс unchecked
        checkbox.get(0).click();//отметить первый чекбокс
        assertTrue(checkbox.get(0).isSelected());//проверить что он checked
        assertTrue(checkbox.get(1).isSelected());//Проверить, что второй чекбокс checked
        checkbox.get(1).click();//сделать unheck
        assertFalse(checkbox.get(1).isSelected());//проверить, что он unchecked
        browser.quit();//закрыть браузер
    }
}
