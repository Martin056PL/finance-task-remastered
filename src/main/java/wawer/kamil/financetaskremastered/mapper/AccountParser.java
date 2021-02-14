package wawer.kamil.financetaskremastered.mapper;

import wawer.kamil.financetaskremastered.model.Account;
import wawer.kamil.financetaskremastered.model.xml.AccountXml;
import wawer.kamil.financetaskremastered.model.xml.AccountsXml;

import java.util.List;
import java.util.stream.Collectors;

public class AccountParser {

    public static List<Account> mapList(AccountsXml accountsXml) {
        return accountsXml.getAccountXml()
                .stream()
                .map(AccountParser::map)
                .collect(Collectors.toList());
    }

    private static Account map(AccountXml accountXml) {
        return new Account(
                accountXml.getIban(),
                accountXml.getName(),
                accountXml.getCurrency(),
                accountXml.getBalance(),
                accountXml.getDate()
        );
    }
}
