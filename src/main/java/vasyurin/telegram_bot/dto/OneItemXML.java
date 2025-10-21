package vasyurin.telegram_bot.dto;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

public final class OneItemXML {
    private String title;
    private String description;
    private String content;
    private String date;

    public OneItemXML(){

    }

    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "encoded", namespace = "http://purl.org/rss/1.0/modules/content/")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlElement(name = "pubDate")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (OneItemXML) obj;
        return Objects.equals(this.title, that.title) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.content, that.content) &&
                Objects.equals(this.date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, content, date);
    }

    @Override
    public String toString() {
        return "OneItemXML[" +
                "title=" + title + ", " +
                "description=" + description + ", " +
                "content=" + content + ", " +
                "date=" + date + ']';
    }


}
