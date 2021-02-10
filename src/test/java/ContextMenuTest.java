import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @Test
    public void contexMenu() {
        browser.get("http://the-internet.herokuapp.com/context_menu");
        Actions action = new Actions(browser);
        action.contextClick(browser.findElement(By.id("hot-spot"))).perform();
        Alert alert = browser.switchTo().alert();
        String expectedResult = "You selected a context menu";
        Assert.assertEquals(alert.getText(), expectedResult, "Invalid alert message");
        alert.accept();
    }
}
