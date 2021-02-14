package wawer.kamil.financetaskremastered.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Account {

    private String iban;
    private String name;
    private String currency;
    private BigDecimal balance;
    private LocalDate date;

    public Account(String iban, String name, String currency, String balance, String date) {
        this.iban = iban;
        this.name = name;
        this.currency = currency;
        this.balance = new BigDecimal(balance);
        this.date = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
