package wawer.kamil.financetaskremastered.mapper;

import wawer.kamil.financetaskremastered.model.Account;
import wawer.kamil.financetaskremastered.model.xml.AccountXml;
import wawer.kamil.financetaskremastered.model.xml.AccountsXml;

import java.util.List;
import java.util.stream.Collectors;

public class AccountMapper {

    public static List<Account> mapXmlToPojoList(AccountsXml accountsXml) {
        return accountsXml.getAccountXml()
                .stream()
                .map(AccountMapper::mapXmlToPojo)
                .collect(Collectors.toList());
    }

    private static Account mapXmlToPojo(AccountXml accountXml) {
        return new Account(
                accountXml.getIban(),
                accountXml.getName(),
                accountXml.getCurrency(),
                accountXml.getBalance(),
                accountXml.getDate()
        );
    }

    public static List<AccountXml> mapPojoToXmlList(List<Account> accounts) {
        return accounts.stream()
                .map(AccountMapper::mapPojoToXml)
                .collect(Collectors.toList());
    }

    private static AccountXml mapPojoToXml(Account account) {
        return new AccountXml(
                account.getIban(),
                account.getName(),
                account.getCurrency(),
                account.getBalance().toString(),
                account.getDate().toString()
        );
    }


}
