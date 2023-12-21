package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Initialize;
import utils.pojo.AllContents;
import utils.pojo.Contents;

import java.util.ArrayList;
import java.util.List;

public class YandexResultPage extends Initialize {
    private static final By RESULT_CONTENTS = By.xpath("//ul[@id='search-result']//li/div[contains(@class, 'Typo_line_s') and not(contains(@class, 'Organic_withThumb'))]");
    private List<WebElement> contentElements;

    public void saveResultData(int number) {
        dataHelper.writeJsonFile(getContentArrayList(number));
    }

    public AllContents getContentArrayList(int number) {
        List<Contents> contentsArrayList = new ArrayList<>();
        int i = 0;

        contentElements = methodes.findElements(RESULT_CONTENTS);

        if (contentElements.isEmpty()) {
            System.out.println("Yandex content list bulunamadı! ");
        } else {
            for (WebElement element : contentElements) {
                String[] parts = element.getText().split("\n");

                String header = (parts.length > 0) ? parts[0].trim() : "";
                String url = (parts.length > 0) ? parts[1].trim() : "";
                String title = "";

                contentsArrayList.add(new Contents(header, title, url));
                i++;
                if (i >= contentElements.size() || i >= number) {
                    break;
                }
            }
            System.out.println("Yandex content list görüldü :");

            contentsArrayList.forEach(content -> {
                System.out.println("Header : " + content.getHeader() + ", Title : " + content.getTitle() + ", URL : " + content.getUrl());
            });
        }

        allContents.setYandexContents(contentsArrayList);
        return allContents;
    }
}
