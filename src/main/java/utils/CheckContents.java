package utils;

import utils.pojo.AllContents;
import utils.pojo.Contents;

import java.util.List;

public class CheckContents {
    public static void checkAllContents(AllContents allContents) {

        List<Contents> googleContents = allContents.getGoogleContents();
        List<Contents> yandexContents = allContents.getYandexContents();
        boolean var = true;

        // Check for matches between googleContents and yandexContents
        for (Contents googleContent : googleContents) {
            for (Contents yandexContent : yandexContents) {
                if (googleContent.equals(yandexContent)) {
                    System.out.println("Matche olan Contentler (Birebir eşleşme) : " + googleContent);
                    var = false;
                }
            }
        }
        if (var)
            System.out.println("Matche olan herhangi bir Content yoktur : ");
    }

    public static void checkAllContentsHeader(AllContents allContents) {
        List<Contents> googleContents = allContents.getGoogleContents();
        List<Contents> yandexContents = allContents.getYandexContents();
        boolean var = true;
        int index = 0;

        List<String> allGoogleHeaders = DataHelper.getAllContentsHeader(googleContents);
        List<String> allYandexHeaders = DataHelper.getAllContentsHeader(yandexContents);

        // Check for matches between googleHeaders and yandexHeaders
        for (String googleHeader : allGoogleHeaders) {
            for (String yandexHeader : allYandexHeaders) {
                if (googleHeader.equals(yandexHeader)) {
                    System.out.println(
                            "Matche olan Header : " + googleHeader + " " +
                                    "URL : " + googleContents.get(index).getUrl() + " " +
                                    "Title : " + googleContents.get(index).getTitle());
                    var = false;
                }
            }
            index++;
        }
        if (var)
            System.out.println("Matche olan herhangi bir Header yoktur : ");
    }

    public static void checkAllContentsUrl(AllContents allContents) {
        List<Contents> googleContents = allContents.getGoogleContents();
        List<Contents> yandexContents = allContents.getYandexContents();
        boolean var = true;
        int index = 0;

        List<String> allGoogleUrl = DataHelper.getAllContentsUrl(googleContents);
        List<String> allYandexUrl = DataHelper.getAllContentsUrl(yandexContents);

        // Check for matches between googleHeaders and yandexHeaders
        for (String googleUrl : allGoogleUrl) {
            for (String yandexUrl : allYandexUrl) {
                // Extract the substring until the first occurrence of '/'
                int i = yandexUrl.indexOf('/');
                String parseYandexUrl = (i != -1) ? yandexUrl.substring(0, i) : yandexUrl;
                if (googleUrl.contains(parseYandexUrl)) {
                    System.out.println(
                            "Matche olan URL : " + googleUrl + " " +
                                    "Header : " + googleContents.get(index).getHeader() + " " +
                                    "Title : " + googleContents.get(index).getTitle());
                    var = false;
                }
            }
            index++;
        }
        if (var)
            System.out.println("Matche olan herhangi bir URL yoktur : ");
    }
}