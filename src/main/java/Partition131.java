import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分隔回文串.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/7
 */
public class Partition131 {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {

        if (s == null || s.length() == 0) {
            return result;
        }
        for (int i = 1; i < s.length(); i++) {
            String l = s.substring(0, i);
            if (isPalindrome(l)) {
                List<String> newList = new ArrayList<>();
                newList.add(l);
                String r = s.substring(i, s.length());
                backTrack(newList, r);
            }
        }
        if (isPalindrome(s)) {
            List<String> newList = new ArrayList<>();
            newList.add(s);
            result.add(newList);
        }
        return result;
    }

    public void backTrack(List<String> list, String s) {
        if (isPalindrome(s)) {
            List<String> newList = new ArrayList<>(list);
            newList.add(s);
            result.add(newList);
            if (s.length() == 1) {
                return;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            String l = s.substring(0, i);
            if (isPalindrome(l)) {
                List<String> newList = new ArrayList<>(list);
                newList.add(l);
                String r = s.substring(i, s.length());
                backTrack(newList, r);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (i < j) {
            if ((int) Character.toLowerCase(charArray[i]) != (int) Character.toLowerCase(charArray[j])) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new Partition131().partition(s));
    }
}
