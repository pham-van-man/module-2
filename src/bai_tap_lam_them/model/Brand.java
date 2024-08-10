package bai_tap_lam_them.model;

public class Brand {
    private String code;
    private String name;
    private String country;

    public Brand(String code, String name, String country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public static Brand getBrand(String[] content) {
        return new Brand(content[0], content[1], content[2]);
    }

    public String getContent() {
        return code + ',' + name + ',' + country;
    }
}
