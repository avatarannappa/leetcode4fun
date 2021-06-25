import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/25
 */
public class MinNumberOffer45 {

    public String minNumber(int[] nums) {
        // 本质是排序问题 O(nlogn)
        String[] numArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numArray[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numArray, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (String s : numArray) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        // 3033459
        System.out.println(new MinNumberOffer45().minNumber(nums));
    }

}
