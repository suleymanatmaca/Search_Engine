package pages;

import org.openqa.selenium.By;
import utils.Initialize;

public class GoogleMainPage extends Initialize {
    private static final By GOOGLE_TB = By.id("APjFqb");
    public void sendKeysToSearchBox(String searchKeyword) {
        methodes.sendKeys(GOOGLE_TB, searchKeyword);
    }
}
