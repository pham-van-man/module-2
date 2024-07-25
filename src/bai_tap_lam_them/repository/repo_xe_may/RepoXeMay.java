package bai_tap_lam_them.repository.repo_xe_may;

import bai_tap_lam_them.model.hang_san_xuat.HangSanXuat;
import bai_tap_lam_them.model.phuong_tien.XeMay;
import bai_tap_lam_them.repository.repo_hang_san_xuat.IRepoHangSanXuat;
import bai_tap_lam_them.repository.repo_hang_san_xuat.RepoHangSanXuat;

import java.util.ArrayList;
import java.util.LinkedList;

public class RepoXeMay implements IRepoXeMay {
    private static LinkedList<XeMay> danhSachXeMay = new LinkedList<>();
    private static IRepoHangSanXuat repoHangSanXuat = new RepoHangSanXuat();
    private static ArrayList<HangSanXuat> danhSachHangSanXuat = repoHangSanXuat.findALL();

    static {
        danhSachXeMay.add(new XeMay("123123", danhSachHangSanXuat.get(0), "2020", "Pham Van Man", "150cc"));
        danhSachXeMay.add(new XeMay("456456", danhSachHangSanXuat.get(1), "2020", "Pham Van Man", "150cc"));
        danhSachXeMay.add(new XeMay("789789", danhSachHangSanXuat.get(2), "2020", "Pham Van Man", "150cc"));
    }

    public LinkedList<XeMay> findALL() {
        return danhSachXeMay;
    }
}
