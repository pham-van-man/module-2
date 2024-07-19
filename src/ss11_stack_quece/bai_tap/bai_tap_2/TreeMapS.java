package ss11_stack_quece.bai_tap.bai_tap_2;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapS {
    public static void main(String[] args) {
        String text = "Pham Van Man, Van Man, Man";
        Map<String, Integer> wordCount = new TreeMap<>();
        text = text.toLowerCase();
        String[] words = text.split("[\\s.,;:!?]+");
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        Set<Map.Entry<String, Integer>> setWordCount = wordCount.entrySet();
        for (Map.Entry<String, Integer> entry : setWordCount) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
