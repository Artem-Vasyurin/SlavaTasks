package vasyurin.telegram_bot;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.net.*;


@Service
public class RssClient {
    private static final URI uri = URI.create("https://hxhrkwtayhhvzavy.30dvtsgew7hf.xyz/rss/all");
    private final XMLReader xmlReader;

    public RssClient(XMLReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    //@Scheduled(fixedDelayString = "PT20S")
    public void makeRequest() throws IOException, SAXException {
        xmlReader.parse(uri.toString());
        System.out.println("типо парсинг");
    }
}
