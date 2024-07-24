package bai_tap_lam_them.phuong_tien;

import bai_tap_lam_them.hang_san_xuat.HangSanXuat;

public class Oto extends PhuongTien {
    private int soChoNgoi;
    private String kieuXe;

    public Oto() {
    }

    public Oto(String bienSoXe, HangSanXuat hangSanXuat, String namSanXuat, String chuSoHuu, int soChoNgoi, String kieuXe) {
        super(bienSoXe, hangSanXuat, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seatingCapacity='" + soChoNgoi + '\'' +
                ", carModel='" + kieuXe + '\'' +
                "} " + super.toString();
    }
}
