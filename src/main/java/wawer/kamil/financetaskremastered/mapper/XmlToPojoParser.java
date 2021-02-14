package wawer.kamil.financetaskremastered.mapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import wawer.kamil.financetaskremastered.controller.ProcessorController;
import wawer.kamil.financetaskremastered.model.xml.AccountsXml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;

public class XmlToPojoParser {

    public static AccountsXml convertXmlToAccountsJackson(String path) throws XMLStreamException, IOException {
        InputStream xmlResource = ProcessorController.class.getClassLoader().getResourceAsStream(path);
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(xmlResource);

        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xmlStreamReader, AccountsXml.class);
    }
}
