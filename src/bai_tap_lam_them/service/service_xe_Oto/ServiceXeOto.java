package bai_tap_lam_them.service.service_xe_Oto;

import bai_tap_lam_them.model.phuong_tien.XeOto;
import bai_tap_lam_them.repository.repo_xe_oto.IRepoXeOto;
import bai_tap_lam_them.repository.repo_xe_oto.RepoXeOto;

import java.util.LinkedList;

public class ServiceXeOto implements IServiceXeOto {
    private IRepoXeOto repoXeOto = new RepoXeOto();

    @Override
    public LinkedList<XeOto> findALL() {
        return repoXeOto.findALL();
    }
}
