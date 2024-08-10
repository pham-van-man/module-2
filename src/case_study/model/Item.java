package case_study.model;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


public class Item implements Serializable, Comparable<Item> {
    private static final long serialVersionUID = 2L;
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);
    private String name;
    private String material;
    private LocalDate releaseDate;
    private String country;
    private String identifier;
    private LocalDate creationDate;
    private String description;
    private String own;
    private boolean isRelease;

    public Item(String name, String material, LocalDate releaseDate, String country, String description, String own) {
        this.name = name;
        this.material = material;
        this.releaseDate = releaseDate;
        this.country = country;
        this.identifier = String.format("%04d", ID_COUNTER.incrementAndGet());
        this.creationDate = LocalDate.now();
        this.description = description;
        this.own = own;
        this.isRelease = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwn() {
        return own;
    }

    public void setOwn(String own) {
        this.own = own;
    }

    public boolean isRelease() {
        return isRelease;
    }

    public void setRelease(boolean release) {
        this.isRelease = release;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item product = (Item) o;
        return Objects.equals(identifier, product.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identifier);
    }

    @Override
    public int compareTo(@NotNull Item o) {
        return this.identifier.compareTo(o.identifier);
    }
}
