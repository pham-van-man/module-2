package bai_tap_lam_them.phuong_tien;

import bai_tap_lam_them.hang_san_xuat.HangSanXuat;

public class XeMay extends PhuongTien {
    private String congXuat;

    public XeMay() {
    }

    public XeMay(String bienSoXe, HangSanXuat hangSanXuat, String namSanXuat, String chuSoHuu, String congXuat) {
        super(bienSoXe, hangSanXuat, namSanXuat, chuSoHuu);
        this.congXuat = congXuat;
    }

    public String getCongXuat() {
        return congXuat;
    }

    public void setCongXuat(String congXuat) {
        this.congXuat = congXuat;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "horsepower='" + congXuat + '\'' +
                "} " + super.toString();
    }
}
