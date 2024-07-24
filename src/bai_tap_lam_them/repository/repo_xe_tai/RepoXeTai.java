package bai_tap_lam_them.repository.repo_xe_tai;

import bai_tap_lam_them.model.hang_san_xuat.HangSanXuat;
import bai_tap_lam_them.model.phuong_tien.XeTai;
import bai_tap_lam_them.repository.repo_hang_san_xuat.IRepoHangSanXuat;
import bai_tap_lam_them.repository.repo_hang_san_xuat.RepoHangSanXuat;

import java.util.ArrayList;
import java.util.LinkedList;

public class RepoXeTai implements IRepoXeTai {
    private static LinkedList<XeTai> danhSachXeTai = new LinkedList<>();
    private static IRepoHangSanXuat repoHangSanXuat = new RepoHangSanXuat();
    private static ArrayList<HangSanXuat> danhSachHangSanXuat = repoHangSanXuat.findALL();

    static {
        danhSachXeTai.add(new XeTai("123123", danhSachHangSanXuat.get(1), "2020", "Pham Van Man", "5 tấn"));
        danhSachXeTai.add(new XeTai("456456", danhSachHangSanXuat.get(2), "2020", "Pham Van Man", "5 tấn"));
        danhSachXeTai.add(new XeTai("789789", danhSachHangSanXuat.get(3), "2020", "Pham Van Man", "5 tấn"));
    }

    @Override
    public LinkedList<XeTai> findALL() {
        return danhSachXeTai;
    }
}
