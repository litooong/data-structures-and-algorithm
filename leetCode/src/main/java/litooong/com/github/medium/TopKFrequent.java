package litooong.com.github.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * No. 692 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class TopKFrequent {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map.entrySet().stream().sorted((x, y) -> {
            if (x.getValue().equals(y.getValue())) {
                return x.getKey().compareTo(y.getKey());
            } else {
                return y.getValue().compareTo(x.getValue());
            }
        }).map(Map.Entry::getKey).limit(k).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2));
    }
}
