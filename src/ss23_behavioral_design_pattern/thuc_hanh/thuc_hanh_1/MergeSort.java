package ss23_behavioral_design_pattern.thuc_hanh.thuc_hanh_1;

import java.util.List;

public class MergeSort implements SortStrategy {
    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Merge sort");
    }
}
