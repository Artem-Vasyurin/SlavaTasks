package vasyurin.telegram_bot.Meduza;

import vasyurin.telegram_bot.interfaces.NewsRowData;

public class MeduzaRowData implements NewsRowData {
    private final String title;
    private final String description;
    private final String text;


    public MeduzaRowData(String title, String description, String text) {
        this.title = title;
        this.description = description;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getText() {
        return text;
    }
}

