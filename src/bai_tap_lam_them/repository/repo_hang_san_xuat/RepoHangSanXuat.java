package bai_tap_lam_them.repository.repo_hang_san_xuat;

import bai_tap_lam_them.model.hang_san_xuat.HangSanXuat;

import java.io.*;
import java.util.ArrayList;

public class RepoHangSanXuat implements IRepoHangSanXuat {
    private static ArrayList<HangSanXuat> danhSachHangSanXuatXe = new ArrayList<>();

    static {
        try (BufferedReader docTep = new BufferedReader(new FileReader("danhSachHangSanXuat.txt"))) {
            String line;
            while ((line = docTep.readLine()) != null) {
                danhSachHangSanXuatXe.add(HangSanXuat.taoHangSanXuat(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save() {
        try (BufferedWriter ghiTep = new BufferedWriter(new FileWriter("danhSachHangSanXuat.txt"))) {
            for (HangSanXuat hangSanXuats : danhSachHangSanXuatXe) {
                ghiTep.write(hangSanXuats.ghiHangSanXuat());
                ghiTep.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<HangSanXuat> findALL() {
        return danhSachHangSanXuatXe;
    }
}
