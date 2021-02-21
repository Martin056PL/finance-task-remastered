package wawer.kamil.financetaskremastered.mapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import wawer.kamil.financetaskremastered.model.Account;
import wawer.kamil.financetaskremastered.model.xml.AccountXml;
import wawer.kamil.financetaskremastered.model.xml.AccountsXml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RequiredArgsConstructor
@Component
public class JacksonMapper {

    @Value("${outputFilePath}")
    private String outputPath;
    private final XmlMapper xmlMapper;

    public AccountsXml convertXmlToAccountsJackson(InputStream inputStream) throws XMLStreamException, IOException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
        return xmlMapper.readValue(xmlStreamReader, AccountsXml.class);
    }

    public void writeToXml(List<Account> accountList) throws IOException {
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        File validatedXmlFile = new File(outputPath).getAbsoluteFile();
        List<AccountXml> accountsXmlList = AccountMapper.mapPojoToXmlList(accountList);
        xmlMapper.writeValue(validatedXmlFile, new AccountsXml(accountsXmlList));
    }
}
