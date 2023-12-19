package pages;

import org.testng.Assert;
import utils.CommonMethodes;
import utils.Initialize;

public class BasePage extends Initialize {
    public void webPageOpen(String URL, String title) {
        CommonMethodes.openBrowser(URL);
        Assert.assertEquals(driver.getTitle(), title);
        System.out.println(title + " Sayfası açıldığı doğrulandı");
    }

    public void navigateTo(String URL, String title) {
        CommonMethodes.navigateTo(URL);
        Assert.assertEquals(driver.getTitle(), title);
        System.out.println(title + " Sayfası açıldığı doğrulandı");
    }
}
