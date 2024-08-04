package ss23_behavioral_design_pattern.thuc_hanh.thuc_hanh_1;

import java.util.List;

public interface SortStrategy {
    <T> void sort(List<T> items);
}   
