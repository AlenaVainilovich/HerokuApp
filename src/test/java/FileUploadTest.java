import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest {

    @Test
    public void filenameIsEqualUploadedFile() {
        browser.get("http://the-internet.herokuapp.com/upload");
        browser.findElement(By.id("file-upload")).sendKeys("/Users/tamika/IdeaProjects/HerokuApp/src/test/resources/prod.jpg");
        browser.findElement(By.id("file-submit")).click();
        WebDriverWait wait = new WebDriverWait(browser, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
        assertEquals(browser.findElement(By.id("uploaded-files")).getText(), "prod.jpg", "Invalid uploaded file name");
    }
}
