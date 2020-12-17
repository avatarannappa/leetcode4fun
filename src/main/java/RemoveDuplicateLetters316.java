import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * 316. 去除重复字母
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/17
 */
public class RemoveDuplicateLetters316 {

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        Deque<Character> deque = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        deque.add(s.charAt(0));
        set.add(s.charAt(0));
        for (int i = 1; i < array.length; i++) {
            char c = array[i];
            if (set.contains(c)) {
                continue;
            }
            while (!deque.isEmpty()) {
                char l = deque.getLast();
                if (l > c && map.get(l) > i) {
                    deque.removeLast();
                    set.remove(l);
                } else {
                    break;
                }
            }
            deque.addLast(c);
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : deque) {
            sb.append(c);
        }
        return sb.toString();
    }

    String s;
    String result;

    public String removeDuplicateLettersOld(String s) {
        StringBuilder sb1 = new StringBuilder();
        Set<Character> set1 = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set1.contains(s.charAt(i))) {
                set1.add(s.charAt(i));
                sb1.append(s.charAt(i));
            }
        }
        this.result = sb1.toString();
        this.s = s;

        Deque<Character> deque = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        backTracking(0, deque, set);
        return result;
    }

    public void backTracking(int start, Deque<Character> deque, Set<Character> set) {
        // 回溯 超时 mitnlruhznjfyzmtmfnstsxwktxlboxutbic
        if (deque.size() == result.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character c : deque) {
                sb.append(c);
            }
            String str = sb.toString();
            result = result.compareTo(str) > 0 ? str : result;
            return;
        }
        if (start == s.length()) {
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                deque.addLast(s.charAt(i));
                set.add(s.charAt(i));
                backTracking(i + 1, deque, set);
                deque.removeLast();
                set.remove(s.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        // String s = "ecbacba";
        // String s = "bcabc";
        // 超时
        String s = "mitnlruhznjfyzmtmfnstsxwktxlboxutbic";
        System.out.println(new RemoveDuplicateLetters316().removeDuplicateLetters(s));
    }
}
