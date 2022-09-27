package interview;

import java.util.HashMap;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * easy
 *
 * @author avatarannappa
 * @date 2022/9/27
 */
public class CheckPermutation {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        for(Character key : map1.keySet()) {
            if (map1.get(key) != map2.get(key)) {
                return false;
            }
        }
        return true;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        for (Character key : map1.keySet()) {
            if (map1.get(key) != map2.get(key)) {
                return false;
            }
        }
        return true;
    }
}
