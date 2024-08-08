package bai_tap_lam_them.repository;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.ulti.DataHandler;

import java.util.ArrayList;
import java.util.List;

public class RepositoryBrandImpl implements RepositoryBrand {
    private final DataHandler DATA_HANDLER;
    private final String PATH;

    public RepositoryBrandImpl() {
        DATA_HANDLER = new DataHandler();
        PATH = "src/bai_tap_lam_them/data/brand.csv";
    }

    @Override
    public List<Brand> findAll() {
        List<String[]> listContent = DATA_HANDLER.readerString(PATH);
        List<Brand> brandList = new ArrayList<>();
        for (String[] content : listContent) {
            brandList.add(Brand.createBrand(content));
        }
        return brandList;
    }
}
