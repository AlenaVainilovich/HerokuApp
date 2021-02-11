import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest {

    @Test
    public void checkTextInsideFrame() {
        browser.get("http://the-internet.herokuapp.com/frames");
        browser.findElement(By.xpath("//a[@href='/iframe']")).click();
        browser.switchTo().frame("mce_0_ifr");
        String expectedResult = "Your content goes here.";
        assertEquals(browser.findElement(By.tagName("p")).getText(), expectedResult, "Text should be " + expectedResult);
        browser.switchTo().defaultContent();
    }
}

