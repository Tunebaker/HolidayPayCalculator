package com.example.calculator.data;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.annotation.PostConstruct;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class HolidayDatesXmlReader implements HolidayDatesReader {
    private final static String FILEPATH = "src\\main\\resources\\static\\calendar.xml";
    private static final int YEAR = 23;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM.dd.yy");

    @Override
    public Set<LocalDate> getHolidays() {

        Set<LocalDate> holidays = new LinkedHashSet<>();
        DocumentBuilder builder;
        Document doc;
        Node node;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        try {
            doc = builder.parse(new File(FILEPATH));
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }

        NodeList nodeList = doc.getElementsByTagName("day");

        for (int i = 0; i < nodeList.getLength(); i++) {
            node = nodeList.item(i);
            holidays.add(LocalDate.parse(node.getAttributes().item(0).getNodeValue() + "." + YEAR, DATE_FORMATTER));
        }

        return holidays;
    }


}
