package wawer.kamil.financetaskremastered.mapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import wawer.kamil.financetaskremastered.model.Account;
import wawer.kamil.financetaskremastered.model.xml.AccountsXml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class XmlToPojoMapper {

    public static AccountsXml convertXmlToAccountsJackson(InputStream inputStream) throws XMLStreamException, IOException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);

        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xmlStreamReader, AccountsXml.class);
    }

    public static void writeToXml(List<Account> accountList) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        xmlMapper.writeValue(new File("src/main/resources/output.xml").getAbsoluteFile(), new AccountsXml(AccountMapper.mapPojoToXmlList(accountList)));
    }
}
