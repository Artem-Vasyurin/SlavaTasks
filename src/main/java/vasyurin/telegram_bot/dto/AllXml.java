package vasyurin.telegram_bot.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rss")
@XmlAccessorType(XmlAccessType.FIELD)
public class AllXml {

    @XmlElement(name = "channel")
    private NewsRowData channel;

    public AllXml() {
    }

    public NewsRowData getChannel() {
        return channel;
    }

    public void setChannel(NewsRowData channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "AllXml{" +
                "newsRowData=" + channel +
                '}';
    }
}
