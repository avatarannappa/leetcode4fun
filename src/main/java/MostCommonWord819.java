import java.util.*;

/**
 * 819. 最常见的单词.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/4/17
 */
public class MostCommonWord819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String[] words = paragraph.toLowerCase().split("\\W+");
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    public static void main(String[] args) {
        MostCommonWord819 mostCommonWord819 = new MostCommonWord819();
        // ball
        System.out.println(mostCommonWord819.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}
