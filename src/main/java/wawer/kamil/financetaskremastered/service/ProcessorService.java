package wawer.kamil.financetaskremastered.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;
import wawer.kamil.financetaskremastered.model.xml.AccountsXml;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public interface ProcessorService {

    InputStreamResource welcomeEndpoint(MultipartFile multipartFile) throws IOException, XMLStreamException;
}
