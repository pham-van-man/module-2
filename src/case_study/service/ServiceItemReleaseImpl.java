package case_study.service;

import case_study.model.Item;
import case_study.repository.RepositoryItemRelease;
import case_study.repository.RepositoryItemReleaseImpl;

import java.util.Map;

public class ServiceItemReleaseImpl implements ServiceItemRelease {
    protected RepositoryItemRelease repositoryItemRelease;

    public ServiceItemReleaseImpl() {
        this.repositoryItemRelease = new RepositoryItemReleaseImpl();
    }

    @Override
    public Map<Item, Double> findAll() {
        return repositoryItemRelease.finAll();
    }

    @Override
    public void addItem(Item item, double price) {
        repositoryItemRelease.addItem(item, price);
    }

    @Override
    public boolean isItemReleased(String identifier) {
        return repositoryItemRelease.isItemReleased(identifier);
    }

    @Override
    public Item getItem(String identifier) {
        return repositoryItemRelease.getItem(identifier);
    }

    @Override
    public Double getPrice(Item item) {
        return repositoryItemRelease.getPrice(item);
    }

    @Override
    public void removeItem(Item item) {
        repositoryItemRelease.removeItem(item);
    }
}
