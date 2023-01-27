/**
 * 2309. 兼具大小写的最好英文字母
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2023/1/27
 */
public class GreatestLetter2309 {

    public String greatestLetter(String s) {
        char[] arr = new char[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                int j = c - 'a';
                if (arr[j] == 0) {
                    arr[j] = c;
                } else if (arr[j] != c) {
                    arr[j] = '@';
                }
            } else {
                int j = c - 'A';
                if (arr[j] == 0) {
                    arr[j] = c;
                } else if (arr[j] != c) {
                    arr[j] = '@';
                }
            }
        }

        String ans = "";

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '@') {
                ans = String.valueOf((char) ('A' + i));
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "arRAzFif";
        // R
        System.out.println(new GreatestLetter2309().greatestLetter(s));
    }

}
