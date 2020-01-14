/**
 * 6. Z字形变换
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/24
 */
public class Convert6 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() < 2) {
            return s;
        }
        if (numRows == 1) {
            return s;
        }
        char[] array = s.toCharArray();
        char[] result = new char[s.length()];
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                int j = i;
                while (true) {
                    if (j >= s.length()) {
                        break;
                    }
                    result[index++] = array[j];
                    j = j + 2 * numRows - 2;
                    if (j >= s.length()) {
                        break;
                    }
                }
            } else if (i == numRows - 1) {
                int j = i;
                while (true) {
                    if (j >= s.length()) {
                        break;
                    }
                    result[index++] = array[j];
                    j = j + 2 * numRows - 2;
                    if (j >= s.length()) {
                        break;
                    }
                }
            } else {
                int j = i;
                int step = 0;
                while (true) {
                    if (j >= s.length()) {
                        break;
                    }
                    result[index++] = array[j];
                    step = step + 2 * numRows - 2;
                    int t = step - i;
                    if (t >= s.length()) {
                        break;
                    }
                    result[index++] = array[t];
                    j = j + 2 * numRows - 2;
                    if (j >= s.length()) {
                        break;
                    }
                }
            }
        }
        String r = "";
        for (char c : result) {
            r += c;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Convert6().convert("AB", 3));
    }
}
