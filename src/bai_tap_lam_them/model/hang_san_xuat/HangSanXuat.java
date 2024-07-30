package bai_tap_lam_them.model.hang_san_xuat;

public class HangSanXuat {
    private String ma;
    private String ten;
    private String quocGia;

    public HangSanXuat() {
    }

    public HangSanXuat(String ma, String ten, String quocGia) {
        this.ma = ma;
        this.ten = ten;
        this.quocGia = quocGia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    @Override
    public String toString() {
        return "HangSanXuat{" +
                "maSanXuat='" + ma + '\'' +
                ", tenHangSanXuat='" + ten + '\'' +
                ", quocGia='" + quocGia + '\'' +
                '}';
    }

    public static HangSanXuat taoHangSanXuat(String string) {
        String[] split = string.split(",");
        return new HangSanXuat(split[0], split[1], split[2]);
    }

    public String ghiHangSanXuat() {
        return ma + ',' + ten + ',' + quocGia;
    }
}
