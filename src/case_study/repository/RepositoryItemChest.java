package case_study.repository;

import case_study.model.Account;
import case_study.model.Item;

import java.util.List;
import java.util.Map;

public interface RepositoryItemChest {
    Map<Account, List<Item>> findAll();

    void register(Account newAccount);

    List<Item> getChest(Account account);

    void addItem(Account account, Item item);

    void removeItem(Account account, String identifier);

    boolean isItem(Account account, String identifier);

    Item getItem(Account account, String identifier);

    void removeItem(String accountNumber, Item item);

    void updateStatusItem(Account account, Item item, boolean status);
}
