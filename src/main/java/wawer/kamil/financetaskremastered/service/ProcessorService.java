package wawer.kamil.financetaskremastered.service;

import org.springframework.web.multipart.MultipartFile;
import wawer.kamil.financetaskremastered.model.xml.AccountsXml;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public interface ProcessorService {

    AccountsXml welcomeEndpoint(MultipartFile multipartFile) throws IOException, XMLStreamException;

    AccountsXml welcomeEndpoint() throws IOException, XMLStreamException;
}
