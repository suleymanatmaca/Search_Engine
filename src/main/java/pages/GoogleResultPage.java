package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.pojo.AllContents;
import utils.pojo.Contents;
import utils.Initialize;

import java.util.ArrayList;
import java.util.List;

public class GoogleResultPage extends Initialize {
    private static final By RESULT_CONTENTS = By.xpath("//div[@jscontroller='SC7lYd' or @class='eKjLze']//span[@jscontroller='msmzHf']/a");
    private static final By MORE_CONTENTS = By.className("oIk2Cb");

    private List<WebElement> contentElements;

    public void saveResultData(int number) {
        methodes.scrollDownUntilElementVisiable(MORE_CONTENTS);
        methodes.sleep(1000);
        dataHelper.writeJsonFile(getContentArrayList(number));
    }

    public AllContents getContentArrayList(int number) {
        List<Contents> contentsArrayList = new ArrayList<>();
        int i = 0;

        contentElements = methodes.findElements(RESULT_CONTENTS);

        if (contentElements.isEmpty()) {
            System.out.println("Google content list bulunamadı!");
        } else {
            for (WebElement element : contentElements) {
                String[] parts = element.getText().split("\n");

                String header = (parts.length > 0) ? parts[0].trim() : "";
                String title = (parts.length > 0) ? parts[1].trim() : "";
                String url = (parts.length > 0) ? parts[2].trim() : "";

                contentsArrayList.add(new Contents(header, title, url));
                i++;
                if (i >= contentElements.size() || i >= number) {
                    break;
                }
            }
            System.out.println("Google content list göründü :");

            contentsArrayList.forEach(content -> {
                System.out.println("Header : " + content.getHeader() + ", Title : " + content.getTitle() + ", URL : " + content.getUrl());
            });
        }

        allContents.setGoogleContents(contentsArrayList);
        return allContents;
    }
}
