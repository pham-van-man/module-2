package case_study.repository;

import case_study.model.Item;

import java.util.Map;

public interface RepositoryItemRelease {
    Map<Item, Double> finAll();

    void addItem(Item item, double price);

    boolean isItemReleased(String identifier);

    Item getItem(String identifier);

    Double getPrice(Item item);

    void removeItem(Item item);
}
