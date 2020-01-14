import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 *
 * @author avatarannappa
 * @version 1.0, 2019/10/29
 */
public class LetterCasePermutation784 {
    public List<String> letterCasePermutation(String S) {
        List<String> resultList = new ArrayList<>();
        resultList = recursion(resultList, S);
        return resultList;
    }

    public List<String> recursion(List<String> sList, String s) {
        if (s == null || s.length() <= 0) {
            return sList;
        }
        List<String> now = new ArrayList<>();
        if (s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
            char reverse = (char)(s.charAt(0) - 32);
            if (sList.isEmpty()) {
                now.add(String.valueOf(s.charAt(0)));
                now.add(String.valueOf(reverse));
            } else {
                for (String s1 : sList) {
                    String t1 = s1 + s.charAt(0);
                    now.add(t1);
                    String t2 = s1 + reverse;
                    now.add(t2);
                }
            }
        } else if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
            char reverse = (char)(s.charAt(0) + 32);
            if (sList.isEmpty()) {
                now.add(String.valueOf(s.charAt(0)));
                now.add(String.valueOf(reverse));
            } else {
                for (String s1 : sList) {
                    String t1 = s1 + s.charAt(0);
                    now.add(t1);
                    String t2 = s1 + reverse;
                    now.add(t2);
                }
            }
        } else {
            if (sList.isEmpty()) {
                now.add(String.valueOf(s.charAt(0)));
            } else {
                for (String s1 : sList) {
                    s1 += s.charAt(0);
                    now.add(s1);
                }
            }
        }

        return recursion(now, s.substring(1));
    }

    public List<String> letterCasePermutation1(String S) {
        List<String> resultList = new ArrayList<>();
        if (S == null || S.length() < 1) {
            return resultList;
        }
        byte lenght = 'a' - 'A';
        char[] array = S.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'a' && array[i] <= 'z') {
                array[i] = (char) (array[i] - lenght);
                String temp = String.valueOf(array);
                resultList.add(temp);
            } else if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] = (char) (array[i] - lenght);
                String temp = String.valueOf(array);
                resultList.add(temp);
            }
        } return resultList;
    }

    public static void main(String[] args) {
        LetterCasePermutation784 letterCasePermutation784 = new LetterCasePermutation784();
        String param = "a1b2";
        List<String> result = letterCasePermutation784.letterCasePermutation(param);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
