package vasyurin.telegram_bot.interfaces;

import vasyurin.telegram_bot.dto.NewsRowData;
import vasyurin.telegram_bot.dto.OneItemXML;

public interface NewsStorage {
    void save(OneItemXML news);
}
