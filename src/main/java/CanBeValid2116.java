/**
 * 2116. 判断一个括号字符串是否有效.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2025/3/23
 */
public class CanBeValid2116 {

    public boolean canBeValid(String s, String locked) {
        // 括号匹配规律 + 贪心
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        char[] arr = s.toCharArray();
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < n; i++) {
            // 不可变的左、右括号数量
            char c = s.charAt(i);
            if ('1' == locked.charAt(i)) {
                if (c == '(') {
                    leftCount++;
                } else {
                    rightCount++;
                }
            }
        }
        int diff = Math.abs(leftCount - rightCount);
        int change = n - leftCount - rightCount;
        if (diff > change) {
            return false;
        }
        if (n / 2 - leftCount > 0) {
            int cnt = n / 2 - leftCount;
            for (int i = 0; i < n; i++) {
                if (locked.charAt(i) == '1') {
                    continue;
                } else {
                    if (cnt-- > 0) {
                        arr[i] = '(';
                    } else {
                        arr[i] = ')';
                    }
                }
            }
        } else {
            int cnt = n / 2 - rightCount;
            for (int j = n - 1; j >= 0; j--) {
                if (locked.charAt(j) == '1') {
                    continue;
                } else {
                    if (cnt-- > 0) {
                        arr[j] = ')';
                    } else {
                        arr[j] = '(';
                    }
                }
            }
        }

        // 规律判断
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '(') {
                preSum++;
            } else {
                preSum--;
            }
            if (preSum < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "((()(()()))()((()()))))()((()(()";
        String locked = "10111100100101001110100010001001";
        System.out.println(new CanBeValid2116().canBeValid(s, locked));
    }
}
