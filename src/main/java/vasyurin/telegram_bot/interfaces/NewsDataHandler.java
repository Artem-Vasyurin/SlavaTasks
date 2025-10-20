package vasyurin.telegram_bot.interfaces;


import org.jsoup.nodes.Document;
import vasyurin.telegram_bot.dto.NewsData;

public interface NewsDataHandler{
    NewsData handle(Document newsRowData);
}
