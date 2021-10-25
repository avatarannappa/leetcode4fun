/**
 * 553. 最优除法. meidum
 *
 * @author avatarannappa
 * @version 1.0, 2021/10/25
 */
public class OptimalDivision553 {

    public String optimalDivision(int[] nums) {
        StringBuilder res = new StringBuilder();
        if (nums.length < 3) {
            for (int i = 0; i < nums.length; i++) {
                res.append(nums[i]);
                res.append("/");
            }
            return res.substring(0, res.length() - 1);
        }
        res.append(nums[0] + "/");
        res.append("(");
        for (int i = 1; i < nums.length; i++) {
            res.append(nums[i]);
            res.append("/");
        }
        res.deleteCharAt(res.length() - 1);
        res.append(")");
        return res.toString();
    }

    public static void main(String[] args) {
        // 输入数组的长度在 [1, 10] 之间。
        // 数组中每个元素的大小都在 [2, 1000] 之间。
        // 每个测试用例只有一个最优除法解。
        int[] nums = { 1000, 100, 10, 2 };
        System.out.println(new OptimalDivision553().optimalDivision(nums));
    }
}
