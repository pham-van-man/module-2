package case_study.repository;

import case_study.model.Item;
import case_study.ulti.DataHandler;
import case_study.ulti.DataHandlerImpl;

import java.util.Map;

public class RepositoryItemReleaseImpl implements RepositoryItemRelease {
    protected String PATH;
    private final DataHandler dataHandler;

    public RepositoryItemReleaseImpl() {
        PATH = "src/case_study/data/item_release.ser";
        dataHandler = new DataHandlerImpl();
    }

    @Override
    public Map<Item, Double> finAll() {
        return dataHandler.readerObject(PATH);
    }

    @Override
    public void addItem(Item item, double price) {
        Map<Item, Double> listItemRelease = finAll();
        listItemRelease.put(item, price);
        dataHandler.writerObject(listItemRelease, PATH);
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
        dataHandler.writerObject(listItemRelease, PATH);
    }
}
