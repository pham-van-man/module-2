package case_study.service;

import case_study.model.Account;
import case_study.model.Item;
import case_study.repository.RepositoryItemChest;
import case_study.repository.RepositoryItemChestImpl;

import java.util.List;
import java.util.Map;

public class ServiceItemChestImpl implements ServiceItemChest {
    protected RepositoryItemChest repositoryItemChest;

    public ServiceItemChestImpl() {
        repositoryItemChest = new RepositoryItemChestImpl();
    }

    @Override
    public Map<Account, List<Item>> findAll() {
        return repositoryItemChest.findAll();
    }

    @Override
    public void register(Account newAccount) {
        repositoryItemChest.register(newAccount);
    }

    @Override
    public List<Item> getChest(Account account) {
        return repositoryItemChest.getChest(account);
    }

    @Override
    public void addItem(Account account, Item item) {
        repositoryItemChest.addItem(account, item);
    }

    @Override
    public void removeItem(Account account, String identifier) {
        repositoryItemChest.removeItem(account, identifier);
    }

    @Override
    public boolean isItem(Account account, String identifier) {
        return repositoryItemChest.isItem(account, identifier);
    }

    @Override
    public Item getItem(Account account, String identifier) {
        return repositoryItemChest.getItem(account, identifier);
    }

    @Override
    public void removeItem(String accountNumber, Item item) {
        repositoryItemChest.removeItem(accountNumber, item);
    }

    @Override
    public void updateStatusItem(Account account, Item item, boolean status) {
        repositoryItemChest.updateStatusItem(account, item, status);
    }
}
