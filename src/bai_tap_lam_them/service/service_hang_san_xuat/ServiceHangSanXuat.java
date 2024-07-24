package bai_tap_lam_them.service.service_hang_san_xuat;

import bai_tap_lam_them.model.hang_san_xuat.HangSanXuat;
import bai_tap_lam_them.repository.repo_hang_san_xuat.IRepoHangSanXuat;
import bai_tap_lam_them.repository.repo_hang_san_xuat.RepoHangSanXuat;

import java.util.ArrayList;

public class ServiceHangSanXuat implements IServiceHangSanXuat {
    IRepoHangSanXuat repoHangSanXuat = new RepoHangSanXuat();

    @Override
    public ArrayList<HangSanXuat> findALL() {
        return repoHangSanXuat.findALL();
    }
}
