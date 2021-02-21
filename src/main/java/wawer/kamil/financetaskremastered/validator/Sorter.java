package wawer.kamil.financetaskremastered.validator;

import org.springframework.stereotype.Component;
import wawer.kamil.financetaskremastered.model.Account;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Sorter {

    public List<Account> sortAccounts(List<Account> validateAccounts) {
        return validateAccounts.stream()
                .sorted(ascendingComparatorByNameAccount())
                .collect(Collectors.toList());
    }

    private static Comparator<Account> ascendingComparatorByNameAccount() {
        return Comparator.comparing(Account::getName);
    }
}
