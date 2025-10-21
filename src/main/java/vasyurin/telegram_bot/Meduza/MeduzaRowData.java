package vasyurin.telegram_bot.Meduza;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import vasyurin.telegram_bot.interfaces.NewsRowData;

import java.util.List;

@Data
public class MeduzaRowData implements NewsRowData {
    private String title;
    private String link;
    private String description;
    private String guid;
    private String pubDate;

    @JacksonXmlProperty(localName = "content:encoded")
    private String content;

}

@Data
class Channel {
    private String title;
    private String link;
    private String language;
    private String description;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    private List<MeduzaRowData> items;
}

@Data
@JacksonXmlRootElement(localName = "rss")
class RssFeed{

    @JacksonXmlProperty(localName = "channel")
    private Channel channel;
}

