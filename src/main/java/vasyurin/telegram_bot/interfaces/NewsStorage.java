package vasyurin.telegram_bot.interfaces;

import vasyurin.telegram_bot.dto.NewsData;

public interface NewsStorage {
    void save(NewsData news);
}
