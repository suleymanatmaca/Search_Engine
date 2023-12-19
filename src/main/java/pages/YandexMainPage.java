package pages;

import org.openqa.selenium.By;
import utils.Initialize;

public class YandexMainPage extends Initialize {
    private static final By YANDEX_TB = By.className("search3__input");
 //  private static final By YANDEX_SEARCH_BTN = By.className("search3__button");

    public void sendKeysToSearchBox(String keyword) {
        methodes.sendKeys(YANDEX_TB, keyword);
    }

 /*   public void clickSearchButton() {
        methodes.click(YANDEX_SEARCH_BTN);
    }
*/
}
