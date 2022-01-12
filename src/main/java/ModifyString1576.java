/**
 * 1576. 替换所有的问号.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/12
 */
public class ModifyString1576 {

    public String modifyString(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ch += 1) {
                    if ((i > 0 && array[i - 1] == ch) || (i < n - 1 && array[i + 1] == ch)) {
                        continue;
                    }
                    array[i] = ch;
                }
            }
        }

        return String.valueOf(array);
    }

    public String modifyStringOld(String s) {
        String result = "";
        int first = -1;
        char firstChar = ' ';
        char preChar = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '?') {
                if (first == -1) {
                    first = i;
                    firstChar = c;
                    preChar = c;
                } else {
                    preChar = c;
                }
                result += c;
            } else {
                if (first == -1) {
                    continue;
                } else {
                    if (preChar != 'a' && (i == s.length() - 1 || (i < s.length() - 1 && s.charAt(i + 1) != 'a'))) {
                        result += 'a';
                        preChar = 'a';
                    } else if (preChar != 'c' && (i == s.length() - 1 || (i < s.length() - 1
                        && s.charAt(i + 1) != 'c'))) {
                        result += 'c';
                        preChar = 'c';
                    } else {
                        result += 'b';
                        preChar = 'b';
                    }
                }
            }
        }
        if (first == -1) {
            first = s.length();
        }
        while (first > 0) {
            if (firstChar != 'a') {
                result = 'a' + result;
                firstChar = 'a';
            } else {
                result = 'c' + result;
                firstChar = 'c';
            }
            first--;
        }
        return result;
    }
}
