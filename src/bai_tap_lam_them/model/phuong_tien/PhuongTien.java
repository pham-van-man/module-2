package bai_tap_lam_them.model.phuong_tien;

import bai_tap_lam_them.model.hang_san_xuat.HangSanXuat;

import java.util.Objects;

public abstract class PhuongTien {
    private String bienSo;
    private HangSanXuat hangSanXuat;
    private String namSanXuat;
    private String chuSoHuu;

    public PhuongTien() {
    }

    public PhuongTien(String bienSo, HangSanXuat hangSanXuat, String namSanXuat, String chuSoHuu) {
        this.bienSo = bienSo;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.chuSoHuu = chuSoHuu;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public HangSanXuat getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(HangSanXuat hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public String getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(String namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return "vehicle{" +
                "numberPlate='" + bienSo + '\'' +
                ", manufacturer='" + hangSanXuat + '\'' +
                ", manufactureYear='" + namSanXuat + '\'' +
                ", owner='" + chuSoHuu + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhuongTien vehicle = (PhuongTien) o;
        return Objects.equals(bienSo, vehicle.bienSo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bienSo);
    }
}
