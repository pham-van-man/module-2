package ss4_lop_va_doi_tuong_trong_java.thuc_hanh.thuc_hanh_1_hinh_chu_nhat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nhap chieu dai hinh chu nhat");
        Scanner sc = new Scanner(System.in);
        float chieuDai = sc.nextFloat();
        System.out.println("Nhap chieu rong hinh chu nhat");
        float chieuRong = sc.nextFloat();
        HinhChuNhat hinhChuNhat = new HinhChuNhat(chieuDai, chieuRong);
        System.out.println(hinhChuNhat.hienThongTin());
        System.out.println("Chu vi hinh chu nhat la: " + hinhChuNhat.tinhChuVi());
        System.out.println("Dien tich hinh chu nhat la: " + hinhChuNhat.tinhDienTich());
    }
}

class HinhChuNhat {
    float chieuDai, chieuRong;

    public HinhChuNhat() {
    }

    public HinhChuNhat(float chieuDai, float chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public float getChieuDai() {
        return this.chieuDai;
    }

    public float getChieuRong() {
        return this.chieuRong;
    }

    public void setChieuDai(float chieuDai) {
        this.chieuDai = chieuDai;
    }

    public void setChieuRong(float chieuRong) {
        this.chieuRong = chieuRong;
    }

    public String hienThongTin() {
        return "Hinh chu nhat co chieu dai la: " + this.chieuDai + "\n" + "chieu rong la: " + this.chieuRong;
    }

    public float tinhChuVi() {
        return (this.chieuDai + this.chieuRong) * 2;
    }

    public float tinhDienTich() {
        return this.chieuDai * this.chieuRong;
    }
}

