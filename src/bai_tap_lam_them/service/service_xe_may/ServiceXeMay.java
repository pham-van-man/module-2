package bai_tap_lam_them.service.service_xe_may;

import bai_tap_lam_them.model.phuong_tien.XeMay;
import bai_tap_lam_them.repository.repo_xe_may.IRepoXeMay;
import bai_tap_lam_them.repository.repo_xe_may.RepoXeMay;

import java.util.LinkedList;

public class ServiceXeMay implements IServiceXeMay {
   private IRepoXeMay repoXeMay = new RepoXeMay();

    @Override
    public LinkedList<XeMay> findALL() {
        return repoXeMay.findALL();
    }
}
