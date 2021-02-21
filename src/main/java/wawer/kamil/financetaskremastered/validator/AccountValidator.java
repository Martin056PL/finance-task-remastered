package wawer.kamil.financetaskremastered.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import wawer.kamil.financetaskremastered.model.Account;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountValidator {

    private final Sorter sorter;

    public List<Account> processAccounts(List<Account> accounts) {
        List<Account> validateAccounts = validateAccounts(accounts);
        List<Account> sortedValidatedAccounts = sorter.sortAccounts(validateAccounts);
        return sortedValidatedAccounts;
    }

    private List<Account> validateAccounts(List<Account> accounts) {
        return accounts.stream()
                .filter(isFieldsNotNull())
                .filter(isFieldsNotEmpty())
                .filter(isCurrencyValid())
                .filter(isBalanceValid())
                .filter(isClosingDateValid())
                .filter(isIbanValid())
                .collect(Collectors.toList());
    }

    private Predicate<Account> isFieldsNotNull() {
        return Validator::notNullFields;
    }

    private Predicate<Account> isFieldsNotEmpty() {
        return Validator::notEmptyFields;
    }

    private Predicate<Account> isCurrencyValid() {
        return Validator::isPolishCurrency;
    }

    private Predicate<Account> isBalanceValid() {
        return Validator::isBalanceValid;
    }

    private Predicate<Account> isClosingDateValid() {
        return Validator::isDateValid;
    }

    private Predicate<Account> isIbanValid(){
        return Validator::isIbanValid;
    }

    private boolean isFieldNotEqualsNullAsContent(String accountField) {
        return !accountField.equals("null");
    }
}
