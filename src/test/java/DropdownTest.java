import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownTest {

    @Test
    public void dropdownIsSelected() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = browser.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.getOptions();
        select.selectByVisibleText("Option 1");
        select.getFirstSelectedOption();
        select.selectByVisibleText("Option 2");
        select.getFirstSelectedOption();
        browser.quit();
    }
}
