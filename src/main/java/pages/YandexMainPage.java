package pages;

import org.openqa.selenium.By;
import utils.Initialize;

public class YandexMainPage extends Initialize {
    private static final By YANDEX_TB = By.className("search3__input");

    public void sendKeysToSearchBox(String searchKeyword) {
        methodes.sendKeys(YANDEX_TB, searchKeyword);
    }
}
