/**
 * 151. 翻转字符串里的单词.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/12
 */
public class ReverseWords151 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        if (s.length() == 0) {
            return s;
        }
        String result = "";
        String[] array = s.split(" ");
        String pre = null;
        for (int i = 0; i < array.length; i++) {
            String now = array[i];
            if (!"".equals(now)) {
                if (pre != null && !pre.equals("")) {
                    now += " ";
                }
                result = now + result;
                pre = now;
            } else {
                if (!pre.equals(now)) {
                    result = " " + result;
                }
                pre = now;
            }
        }
        return result;
    }

    public String reverseWordsNew(String s) {
        s = s.trim();
        String ss = "";
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == ' ' && s.charAt(i - 1) == ' ') {
                continue;
            }
            ss += now;
        }
        char[] arr = ss.toCharArray();
        reverseWords(arr, 0, arr.length - 1);
        for (int i = 0, j = 0; (i < arr.length); ) {
            while (j < arr.length && arr[j] != ' ') {
                j++;
            }
            reverseWords(arr, i, j - 1);
            i = j + 1;
            j = i;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    public void reverseWords(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        String s = " a good   example ";
        System.out.println(new ReverseWords151().reverseWordsNew(s));
    }
}
