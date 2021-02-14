package wawer.kamil.financetaskremastered.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;


@Data
@JacksonXmlRootElement(localName = "account")
public class AccountXml {


    @JacksonXmlProperty(isAttribute = true, localName = "iban")
    private String iban;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "currency")
    private String currency;
    @JacksonXmlProperty(localName = "balance")
    private String balance;
    @JacksonXmlProperty(localName = "closingDate")
    private String date;

}
