package vasyurin.telegram_bot.parsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RSSHandler extends DefaultHandler {

    private Boolean isItem = false;
    private Boolean isTitle = false;
    private Boolean isDescription = false;
    private Boolean isContent = false;
    private StringBuilder contentBuilder = new StringBuilder();


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      if (qName.equals("item")) {
          isItem = true;
      }
      if (qName.equals("title")) {
          isTitle = true;
      }
      if (qName.equals("description")) {
          isDescription = true;
      }

      if (qName.equals("content:encoded")) {
          isContent = true;
      }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isItem) {
            if (isTitle) {
                contentBuilder.append(" isTitle ");
                contentBuilder.append(ch, start, length);
                contentBuilder.append(System.lineSeparator());
            }
            if (isDescription) {
                contentBuilder.append(" isDescription ");
                contentBuilder.append(ch, start, length);
                contentBuilder.append(System.lineSeparator());
            }
            if (isContent) {
                contentBuilder.append(" isContent ");
                contentBuilder.append(ch, start, length);
                contentBuilder.append(System.lineSeparator());
            }

        }

        System.out.println(contentBuilder.toString());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("item")) {
            isItem = false;
        }
        if (qName.equals("title")) {
            isTitle = false;
        }
        if (qName.equals("description")) {
            isDescription = false;
        }
        if (qName.equals("content:encoded")) {
            isContent = false;
        }

    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument");
    }

    @Override
    public void endDocument() throws SAXException {
        StringBuilder replaceString = new StringBuilder(contentBuilder.toString()
                .replaceAll("<a.*?>", "")
                .replaceAll("</a>", "")
                .replaceAll("<h4>.*?</h4>", "")
                .replaceAll("<ul>.*?</ul>", "")
                .replaceAll("<span.*?>", "")
                .replaceAll("</span>", "")
                .replaceAll("<figure>.*?</figure>", "")
                .replaceAll("(?s)<script.*?</script>", ""));

        try (FileWriter fileWriter = new FileWriter(new File("srsMeduza.txt"))) {

            fileWriter.write(replaceString.toString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("endDocument");
    }
}
