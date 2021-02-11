import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class FileDownloadTest extends BaseTest {

    @Test
    public void fileShouldBeDownloaded() {
        //установить каталог автоматической загрузки в ChromeOptions, а затем создать драйвер с этой опцией
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        browser = new ChromeDriver(options);

        browser.get("http://the-internet.herokuapp.com/download");
        List<WebElement> list = browser.findElements(By.xpath("//*[@class='example']/a"));
        list.get(7).click();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File folder = new File(System.getProperty("user.dir"));
        //список файлов в этой папке
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File file = null;

        for (File fileItem : listOfFiles) {
            if (fileItem.isFile()) {
                String fileName = fileItem.getName();
                System.out.println("File " + fileItem.getName());
                if (fileName.matches(fileName)) {
                    file = new File(fileName);
                    found = true;
                }
            }
        }

        assertTrue(found, "Загруженный документ не найден");
        file.deleteOnExit();
    }
}



