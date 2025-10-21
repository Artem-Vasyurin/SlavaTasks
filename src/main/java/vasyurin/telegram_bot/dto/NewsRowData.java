package vasyurin.telegram_bot.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.List;


public final class NewsRowData {

    private List<OneItemXML> newsItems;

    public NewsRowData(){

    }

    @XmlElement(name = "item")
    public List<OneItemXML> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(List<OneItemXML> newsItems) {
        this.newsItems = newsItems;
    }

    @Override
    public String toString() {
        return "NewsRowData{" +
                "newsItems=" + newsItems +
                '}';
    }
}
