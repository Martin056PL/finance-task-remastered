package wawer.kamil.financetaskremastered.validator;

import wawer.kamil.financetaskremastered.model.Account;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Validator {

    protected static boolean isPolishCurrency(Account account) {
        return account.getCurrency().equals("PLN");
    }

    protected static boolean isBalanceValid(Account account) {
        return account.getBalance().compareTo(BigDecimal.ZERO) >= 0;
    }

    protected static boolean isIbanValid(Account account) {
        return account.getIban().matches("PL\\d{2}[ ]\\d{4}[ ]\\d{4}[ ]\\d{4}[ ]\\d{4}[ ]\\d{4}[ ]\\d{4}|PL\\d{26}");
    }

    protected static boolean isDateValid(Account account) {
        LocalDate currentDate = LocalDate.now();
        return account.getDate().isAfter(currentDate) || account.getDate().equals(currentDate);
    }

    protected static boolean notEmptyFields(Account account) {
        boolean notEmptyName = isFieldNotEmpty(account.getName());
        boolean notEmptyCurrency = isFieldNotEmpty(account.getCurrency());
        boolean notEmptyIban = isFieldNotEmpty(account.getIban());

        return notEmptyName && notEmptyCurrency && notEmptyIban;
    }

    protected static boolean notNullFields(Account account) {
        boolean notNullDate = isFieldNotNull(account.getDate());
        boolean notNullName = isFieldNotNull(account.getName());
        boolean notNullCurrency = isFieldNotNull(account.getCurrency());
        boolean notNullBalance = isFieldNotNull(account.getBalance());
        boolean notNullIban = isFieldNotNull(account.getIban());
        return notNullDate && notNullName && notNullCurrency && notNullBalance && notNullIban;
    }

    private static boolean isFieldNotEmpty(String accountField) {
        return !accountField.isBlank();
    }


    private static boolean isFieldNotNull(Object object) {
        return object != null;
    }

}
