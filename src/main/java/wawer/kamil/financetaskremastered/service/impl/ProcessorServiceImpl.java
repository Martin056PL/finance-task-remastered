package wawer.kamil.financetaskremastered.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import wawer.kamil.financetaskremastered.mapper.AccountMapper;
import wawer.kamil.financetaskremastered.mapper.XmlToPojoMapper;
import wawer.kamil.financetaskremastered.model.Account;
import wawer.kamil.financetaskremastered.model.xml.AccountsXml;
import wawer.kamil.financetaskremastered.service.ProcessorService;
import wawer.kamil.financetaskremastered.utils.UploadFile;
import wawer.kamil.financetaskremastered.validator.AccountValidator;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessorServiceImpl implements ProcessorService {

    private final AccountValidator validator;

    @Override
    public AccountsXml welcomeEndpoint(MultipartFile multipartFile) throws IOException, XMLStreamException {
        InputStream inputStream = UploadFile.uploadFile(multipartFile);
        AccountsXml accountsXml = XmlToPojoMapper.convertXmlToAccountsJackson(inputStream);
        List<Account> accounts = AccountMapper.mapXmlToPojoList(accountsXml);
        List<Account> validatedAccounts = validator.processAccounts(accounts);
        XmlToPojoMapper.writeToXml(validatedAccounts);
        return accountsXml;
    }
}