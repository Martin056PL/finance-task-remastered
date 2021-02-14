package wawer.kamil.financetaskremastered.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import wawer.kamil.financetaskremastered.mapper.AccountParser;
import wawer.kamil.financetaskremastered.mapper.XmlToPojoParser;
import wawer.kamil.financetaskremastered.model.Account;
import wawer.kamil.financetaskremastered.model.xml.AccountsXml;
import wawer.kamil.financetaskremastered.service.ProcessorService;
import wawer.kamil.financetaskremastered.utils.UploadFile;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

@Service
public class ProcessorServiceImpl implements ProcessorService {

    @Override
    public AccountsXml welcomeEndpoint(MultipartFile multipartFile) throws IOException, XMLStreamException {
        UploadFile.uploadFile(multipartFile);
        AccountsXml accountsXml = XmlToPojoParser.convertXmlToAccountsJackson("input.xml");
        List<Account> accounts = AccountParser.mapList(accountsXml);
        UploadFile.removeFile(multipartFile);
        return accountsXml;
    }

    @Override
    public AccountsXml welcomeEndpoint() throws IOException, XMLStreamException {
        AccountsXml accountsXml = XmlToPojoParser.convertXmlToAccountsJackson("static/input.xml");
        List<Account> accounts = AccountParser.mapList(accountsXml);
        return accountsXml;
    }
}