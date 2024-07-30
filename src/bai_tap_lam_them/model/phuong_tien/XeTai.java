package bai_tap_lam_them.model.phuong_tien;

import bai_tap_lam_them.model.hang_san_xuat.HangSanXuat;

public class XeTai extends PhuongTien {
    private String trongTai;

    public XeTai() {
    }

    public XeTai(String bienSo, HangSanXuat hangSanXuat, String namSanXuat, String chuSoHuu, String trongTai) {
        super(bienSo, hangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public String getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(String trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "payload='" + trongTai + '\'' +
                "} " + super.toString();
    }
}
