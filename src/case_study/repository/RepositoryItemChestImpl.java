package case_study.repository;

import case_study.model.Account;
import case_study.model.Item;
import case_study.ulti.DataHandler;
import case_study.ulti.DataHandlerImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RepositoryItemChestImpl implements RepositoryItemChest {
    protected String path;
    private final DataHandler DATA_HANDLER;

    public RepositoryItemChestImpl() {
        path = "src/case_study/data/item_chest.ser";
        DATA_HANDLER = new DataHandlerImpl();
    }

    @Override
    public Map<Account, List<Item>> findAll() {
        return DATA_HANDLER.readerObject(path);
    }

    @Override
    public void register(Account newAccount) {
        Map<Account, List<Item>> listItemChest = findAll();
        listItemChest.put(newAccount, new LinkedList<>());
        DATA_HANDLER.writerObject(listItemChest, path);
    }

    @Override
    public List<Item> getChest(Account account) {
        return findAll().get(account);
    }

    @Override
    public void addItem(Account account, Item item) {
        Map<Account, List<Item>> listItemChest = findAll();
        listItemChest.get(account).add(item);
        DATA_HANDLER.writerObject(listItemChest, path);
    }

    @Override
    public void removeItem(Account account, String identifier) {
        Map<Account, List<Item>> listItemChest = findAll();
        List<Item> listItem = listItemChest.get(account);
        for (Item item : listItem) {
            if (item.getIdentifier().equals(identifier)) {
                listItemChest.get(account).remove(item);
                break;
            }
        }
        DATA_HANDLER.writerObject(listItemChest, path);
    }

    @Override
    public boolean isItem(Account account, String identifier) {
        Map<Account, List<Item>> listItemChest = findAll();
        List<Item> listItem = listItemChest.get(account);
        for (Item item : listItem) {
            if (item.getIdentifier().equals(identifier)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Item getItem(Account account, String identifier) {
        Map<Account, List<Item>> listItemChest = findAll();
        List<Item> listItem = listItemChest.get(account);
        for (Item item : listItem) {
            if (item.getIdentifier().equals(identifier)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void removeItem(String accountNumber, Item item) {
        Map<Account, List<Item>> listItemChest = findAll();
        for (Account account : listItemChest.keySet()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                listItemChest.get(account).remove(item);
                break;
            }
        }
        DATA_HANDLER.writerObject(listItemChest, path);
    }

    @Override
    public void updateStatusItem(Account account, Item item, boolean status) {
        Map<Account, List<Item>> listItemChest = findAll();
        List<Item> listItem = listItemChest.get(account);
        for (Item itemTemp : listItem) {
            if (item.getIdentifier().equals(itemTemp.getIdentifier())) {
                itemTemp.setRelease(status);
                break;
            }
        }
        DATA_HANDLER.writerObject(listItemChest, path);
    }
}
