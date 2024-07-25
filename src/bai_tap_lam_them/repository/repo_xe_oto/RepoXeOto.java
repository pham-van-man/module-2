package bai_tap_lam_them.repository.repo_xe_oto;

import bai_tap_lam_them.model.hang_san_xuat.HangSanXuat;
import bai_tap_lam_them.model.phuong_tien.XeOto;
import bai_tap_lam_them.repository.repo_hang_san_xuat.IRepoHangSanXuat;
import bai_tap_lam_them.repository.repo_hang_san_xuat.RepoHangSanXuat;

import java.util.ArrayList;
import java.util.LinkedList;

public class RepoXeOto implements IRepoXeOto {
    private static LinkedList<XeOto> danhSachOto = new LinkedList<>();
    private static IRepoHangSanXuat repoHangSanXuat = new RepoHangSanXuat();
    private static ArrayList<HangSanXuat> danhSachHangSanXuat = repoHangSanXuat.findALL();
    static String[] kieuXe = {"Du lich", "Xe khach"};

    static {
        danhSachOto.add(new XeOto("123123", danhSachHangSanXuat.get(0), "2020", "Pham Van Man", 5, kieuXe[0]));
        danhSachOto.add(new XeOto("456456", danhSachHangSanXuat.get(1), "2020", "Pham Van Man", 5, kieuXe[0]));
        danhSachOto.add(new XeOto("789789", danhSachHangSanXuat.get(2), "2020", "Pham Van Man", 5, kieuXe[0]));
    }

    @Override
    public LinkedList<XeOto> findALL() {
        return danhSachOto;
    }
}
