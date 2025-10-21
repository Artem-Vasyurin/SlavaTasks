package vasyurin.telegram_bot.interfaces;


import org.jsoup.nodes.Document;
import vasyurin.telegram_bot.dto.AllXml;
import vasyurin.telegram_bot.dto.NewsRowData;
import vasyurin.telegram_bot.dto.OneItemXML;

public interface NewsDataHandler{
    OneItemXML handle(Document newsRowData);
    OneItemXML toObject(String newsRowData);
}
