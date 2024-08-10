package case_study.repository;

import case_study.model.Item;
import case_study.ulti.DataHandler;
import case_study.ulti.DataHandlerImpl;

import java.util.Map;

public class RepositoryItemReleaseImpl implements RepositoryItemRelease {
    protected String path;
    private final DataHandler DATA_HANDLER;

    public RepositoryItemReleaseImpl() {
        path = "src/case_study/data/item_release.ser";
        DATA_HANDLER = new DataHandlerImpl();
    }

    @Override
    public Map<Item, Double> finAll() {
        return DATA_HANDLER.readerObject(path);
    }

    @Override
    public void addItem(Item item, double price) {
        Map<Item, Double> listItemRelease = finAll();
        listItemRelease.put(item, price);
        DATA_HANDLER.writerObject(listItemRelease, path);
    }

    @Override
    public boolean isItemReleased(String identifier) {
        Map<Item, Double> listItemRelease = finAll();
        for (Item item : listItemRelease.keySet()) {
            if (identifier.equals(item.getIdentifier())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Item getItem(String identifier) {
        Map<Item, Double> listItemRelease = finAll();
        for (Item item : listItemRelease.keySet()) {
            if (identifier.equals(item.getIdentifier())) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Double getPrice(Item item) {
        Map<Item, Double> listItemRelease = finAll();
        return listItemRelease.get(item);
    }

    @Override
    public void removeItem(Item item) {
        Map<Item, Double> listItemRelease = finAll();
        listItemRelease.remove(item);
        DATA_HANDLER.writerObject(listItemRelease, path);
    }
}
