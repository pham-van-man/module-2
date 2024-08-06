package case_study.service;

import case_study.model.Item;

import java.util.Map;

public interface ServiceItemRelease {
    Map<Item, Double> findAll();

    void addItem(Item item, double price);

    boolean isItemReleased(String identifier);

    Item getItem(String identifier);

    Double getPrice(Item item);

    void removeItem(Item item);
}
