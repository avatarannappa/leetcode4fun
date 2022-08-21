/**
 * 420. 强密码校验器 Strong Password Checker.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/21
 */
public class StrongPasswordChecker420 {

    public int strongPasswordChecker(String password) {
        int min = 6;
        int max = 20;

        int lowercaseCount = 0;
        int uppercaseCount = 0;
        int digit = 0;
        int len = password.length();

        int ans = 0;
        char[] arr = password.toCharArray();
        int repeat = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c >= 'a' && c <= 'z') {
                lowercaseCount = 1;
            } else if (c >= 'A' && c <= 'Z') {
                uppercaseCount = 1;
            } else if (c >= '0' && c <= '9') {
                digit = 1;
            }
            if (i >= 2 && c == arr[i - 1] && c == arr[i - 2]) {
                repeat++;
                arr[i] = '@';
            }
        }
        int need = 3 - (lowercaseCount + uppercaseCount + digit);

        if (len < min) {
            // 增加 + 替换
            ans = Math.max(need, min - len);
        } else if (len <= max) {
            // 替换
            ans = Math.max(repeat, need);
        } else {
            // 删除 + 替换。这部分是抄的
            // 替换次数和删除次数
            int replace = 0, remove = len - 20;
            // k mod 3 = 1 的组数，即删除 2 个字符可以减少 1 次替换操作
            int rm2 = 0;
            int cnt = 0;
            char cur = '#';

            for (int i = 0; i < len; ++i) {
                char ch = password.charAt(i);
                if (ch == cur) {
                    ++cnt;
                } else {
                    if (remove > 0 && cnt >= 3) {
                        if (cnt % 3 == 0) {
                            // 如果是 k % 3 = 0 的组，那么优先删除 1 个字符，减少 1 次替换操作
                            --remove;
                            --replace;
                        } else if (cnt % 3 == 1) {
                            // 如果是 k % 3 = 1 的组，那么存下来备用
                            ++rm2;
                        }
                        // k % 3 = 2 的组无需显式考虑
                    }
                    replace += cnt / 3;
                    cnt = 1;
                    cur = ch;
                }
            }
            if (remove > 0 && cnt >= 3) {
                if (cnt % 3 == 0) {
                    --remove;
                    --replace;
                } else if (cnt % 3 == 1) {
                    ++rm2;
                }
            }
            replace += cnt / 3;

            // 使用 k % 3 = 1 的组的数量，由剩余的替换次数、组数和剩余的删除次数共同决定
            int use2 = Math.min(Math.min(replace, rm2), remove / 2);
            replace -= use2;
            remove -= use2 * 2;
            // 由于每有一次替换次数就一定有 3 个连续相同的字符（k / 3 决定），因此这里可以直接计算出使用 k % 3 = 2 的组的数量
            int use3 = Math.min(replace, remove / 3);
            replace -= use3;
            remove -= use3 * 3;
            return (len - 20) + Math.max(replace, need);
        }
        return ans;
    }

    public static void main(String[] args) {
        String password = "......A................................b1.........";
        // 34
        System.out.println(new StrongPasswordChecker420().strongPasswordChecker(password));
    }
}
