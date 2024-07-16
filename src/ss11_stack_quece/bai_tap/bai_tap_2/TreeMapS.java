package ss11_stack_quece.bai_tap.bai_tap_2;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapS {
    public static void main(String[] args) {
        String text = "This is a simple text. Text contains words, and words should be counted.";
        Map<String, Integer> wordCountMap = new TreeMap<>();
        text = text.toLowerCase();
        String[] words = text.split("[\\s.,;:!?]+");
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
