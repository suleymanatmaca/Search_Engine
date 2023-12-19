package steps;

import pages.*;
import utils.Initialize;

import static utils.CheckContents.*;

public class Steps extends Initialize {

    BasePage basePage = new BasePage();
    GoogleMainPage googleMainPage = new GoogleMainPage();
    GoogleResultPage googleResultPage = new GoogleResultPage();
    YandexMainPage yandexMainPage = new YandexMainPage();
    YandexResultPage yandexResultPage = new YandexResultPage();

    public void openBrowser(String URL, String title) {
        basePage.webPageOpen(getTestDataPF(URL), getTestDataPF(title));
    }

    public void navigateTo(String URL, String title) {
        basePage.navigateTo(getTestDataPF(URL), getTestDataPF(title));
    }

    public void searchOnGoogle(String searchKeyword) {
        googleMainPage.sendKeysToSearchBox(searchKeyword);
        //googleMainPage.clickSearchButton();
    }

    public void searchOnYandex(String searchKeyword) {
        yandexMainPage.sendKeysToSearchBox(searchKeyword);
        //yandexMainPage.clickSearchButton();
        methodes.sleep(1000);
    }

    public void saveGoogleResultData(String number) {
        googleResultPage.saveResultData(Integer.parseInt(getTestDataPF(number)));
    }

    public void saveYandexResultData(String number) {
        yandexResultPage.saveResultData(Integer.parseInt(getTestDataPF(number)));
    }

    public void checkEngineResultData() {
        checkAllContents(dataHelper.readJsonFile());
        checkAllContentsHeader(dataHelper.readJsonFile());
        checkAllContentsUrl(dataHelper.readJsonFile());
    }
}