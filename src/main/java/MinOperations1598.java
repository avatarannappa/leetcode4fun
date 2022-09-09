/**
 * 1598. 文件夹操作日志搜集器
 * easy
 *
 * @author avatarannappa
 * @date 2022/9/9
 */
public class MinOperations1598 {

    public int minOperations(String[] logs) {
        int ans = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (ans > 0) {
                    ans--;
                }
            } else if (log.equals("./")) {
                continue;
            } else {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] logs = {"./", "../", "./"};
        // 3
        System.out.println(new MinOperations1598().minOperations(logs));
    }
}
