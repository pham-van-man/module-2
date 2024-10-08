package ss23_behavioral_design_pattern.thuc_hanh.thuc_hanh_1;

public class Main {
    public static void main(String[] args) {
        SortedList sortedList = new SortedList();
        sortedList.add("Java");
        sortedList.add("PHP");
        sortedList.add("C#");
        sortedList.add("Python");
        sortedList.setSortStrategy(new QuickSort());
        sortedList.sort();
        sortedList.setSortStrategy(new MergeSort());
        sortedList.sort();
    }
}