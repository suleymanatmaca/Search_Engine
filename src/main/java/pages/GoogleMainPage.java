package pages;

import org.openqa.selenium.By;
import utils.Initialize;

public class GoogleMainPage extends Initialize {
    private static final By GOOGLE_TB = By.id("APjFqb");
    //private static final By GOOGLE_SEARCH_BTN = By.xpath("(//input[@value=\"Google'da Ara\"])[2]");
    public void sendKeysToSearchBox(String searchKeyword) {
        methodes.sendKeys(GOOGLE_TB, searchKeyword);
    }
/*
    public void clickSearchButton() {
        methodes.click(GOOGLE_SEARCH_BTN);
    }
*/
}
