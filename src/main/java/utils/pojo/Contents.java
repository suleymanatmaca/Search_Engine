package utils.pojo;

import java.util.Objects;

public class Contents {
    private String title;
    private String url;
    private String header;

    public Contents() {
    }

    public Contents(String header, String title, String url) {
        this.setHeader(header);
        this.setTitle(title);
        this.setUrl(url);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "Contents{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", header='" + header + '\'' +
                '}';
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contents contents = (Contents) o;
        return title.equals(contents.title) &&
                url.equals(contents.url) &&
                header.equals(contents.header);
    }
*/
    // Implement equals() and hashCode() to properly compare Contents objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contents contents = (Contents) o;
        return Objects.equals(title, contents.title) &&
                Objects.equals(url, contents.url) &&
                Objects.equals(header, contents.header);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, url, header);
    }

}
