package bai_tap_lam_them.repository.repo_xe_tai;

import bai_tap_lam_them.model.phuong_tien.XeTai;

import java.util.LinkedList;

public interface IRepoXeTai {
    LinkedList<XeTai> findALL();
}
