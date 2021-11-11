/**
 * 388. 文件的最长绝对路径.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/11
 */
public class LengthLongestPath388 {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int ans = 0;
        // 不会越界
        int[] sum = new int[input.length() + 1];
        String[] array = input.split("\n");
        for (String a : array) {
            // sum[0] = 0 作为开始，计算根节点使用
            int level = a.lastIndexOf('\t') + 2;
            // 长度去掉'\t'个数
            int len = a.length() - level + 1;
            if (a.contains(".")) {
                ans = Math.max(ans, sum[level - 1] + len);
            } else {
                sum[level] = sum[level - 1] + len + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String input = "dir\nsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        // 32
        System.out.println(new LengthLongestPath388().lengthLongestPath(input));
    }

}
