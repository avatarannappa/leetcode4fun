/**
 * 3340. 检查平衡字符串
 * easy
 *
 * @author avatarannappa
 * @version 2025/3/14
 */
public class IsBalanced3340 {

    public boolean isBalanced(String num) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < num.length(); i++) {
            if (i % 2 == 0) {
                even += num.charAt(i) - '0';
            } else {
                odd += num.charAt(i) - '0';
            }
        }
        return odd == even;
    }
}
