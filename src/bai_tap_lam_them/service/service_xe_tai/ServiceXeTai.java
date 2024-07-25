package bai_tap_lam_them.service.service_xe_tai;

import bai_tap_lam_them.model.phuong_tien.XeTai;
import bai_tap_lam_them.repository.repo_xe_tai.IRepoXeTai;
import bai_tap_lam_them.repository.repo_xe_tai.RepoXeTai;

import java.util.LinkedList;

public class ServiceXeTai implements IServiceXeTai {
    private static IRepoXeTai repoXeTai = new RepoXeTai();

    @Override
   public LinkedList<XeTai> findALL() {
        return repoXeTai.findALL();
    }
}
