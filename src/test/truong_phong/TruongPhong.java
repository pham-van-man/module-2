package test.truong_phong;

import test.nhan_vien.NhanVien;

public class TruongPhong extends NhanVien {
    public double trachNhiem;

    public TruongPhong(String hoTen, double luong, double trachNhiem) {
    }

    public void xuat() {
        super.hoTen = "Tuấn";
        super.luong = 500;
    }

    public static void main(String[] args) {
    }
}
