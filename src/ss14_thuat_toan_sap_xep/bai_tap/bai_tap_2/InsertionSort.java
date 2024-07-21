package ss14_thuat_toan_sap_xep.bai_tap.bai_tap_2;

public class InsertionSort {
    public void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int element = list[i];
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (element < list[j]) {
                    list[j + 1] = list[j];
                    index = j;
                }
            }
            if (index != i) {
                list[index] = element;
            }
        }
    }
}
