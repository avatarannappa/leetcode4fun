import java.util.Arrays;

/**
 * 556. 下一个更大元素 III
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/7/3
 */
public class NextGreaterElement556 {

    public int nextGreaterElement(int n) {
        // 模拟
        if (n < 10) {
            return -1;
        }
        String str = String.valueOf(n);
        System.out.println(str);
        String res = str.charAt(str.length() - 1) + "";
        for (int i = str.length() - 2; i >= 0; i--) {
            if (str.charAt(i) < res.charAt(0)) {
                char s = str.charAt(i);
                int index = 0;
                char min = res.charAt(0);
                for (int j = 1; j < res.length(); j++) {
                    if (res.charAt(j) > s && res.charAt(j) < min) {
                        min = res.charAt(j);
                        index = j;
                    }
                }
                res = res.substring(0, index) + res.substring(index + 1) + s;
                char[] array = res.toCharArray();
                Arrays.sort(array);
                res = "";
                for (char c : array) {
                    res += c;
                }
                res = "" + min + res;

                break;
            } else {
                res = str.charAt(i) + res;
            }
        }
        if (res.length() < str.length()) {
            res = str.substring(0, str.length() - res.length()) + res;
        }
        System.out.println(res);
        return str.equals(res) ? -1 : Long.parseLong(res) > 0x7fffffff ? -1 : Integer.parseInt(res);
    }

    public static void main(String[] args) {
        int n = 12443322;
        // 13222344
        System.out.println(new NextGreaterElement556().nextGreaterElement(n));
    }
}
