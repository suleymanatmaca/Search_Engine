package utils.pojo;

import java.util.ArrayList;
import java.util.List;

public class AllContents {
    private List<Contents> googleContents = new ArrayList<>();
    private List<Contents> yandexContents = new ArrayList<>();

    public AllContents() {
    }

    public AllContents(List<Contents> googleContents, List<Contents> yandexContents) {
        this.googleContents = googleContents;
        this.yandexContents = yandexContents;
    }

    public List<Contents> getGoogleContents() {
        return googleContents;
    }

    public void setGoogleContents(List<Contents> googleContents) {
        this.googleContents = googleContents;
    }

    public List<Contents> getYandexContents() {
        return yandexContents;
    }

    public void setYandexContents(List<Contents> yandexContents) {
        this.yandexContents = yandexContents;
    }

    @Override
    public String toString() {
        return "ALLContents{" +
                "title='" + googleContents + '\'' +
                ", url='" + yandexContents + '\'' +
                '}';
    }
}
