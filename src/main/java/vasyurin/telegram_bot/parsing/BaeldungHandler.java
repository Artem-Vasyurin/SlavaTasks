package vasyurin.telegram_bot.parsing;

import org.xml.sax.helpers.DefaultHandler;

public class BaeldungHandler extends DefaultHandler {
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String CONTENT = "content";
    private static final String ARTICLES = "articles";
    private static final String ARTICLE = "article";
    private StringBuilder result;


}
