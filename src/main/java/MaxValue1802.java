/**
 * 1802. 有界数组中指定下标处的最大值
 * medium
 *
 * @author avatarannappa
 * @date 2023/1/4
 */
public class MaxValue1802 {

    public int maxValue(int n, int index, int maxSum) {
        // 二分+贪心 O(lg(maxSum))
        // TODO 数学 O(1)
        int left = 1;
        int right = maxSum;
        while (left < right) {
            int mid =  (left + right + 1) / 2;
            if (valid(mid, n, index, maxSum)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean valid(int nowNum, int n, int index, int maxSum) {
        int leftLength = index;
        int rightLength = n - index - 1;
        return nowNum + cal(nowNum, leftLength) + cal(nowNum, rightLength) <= maxSum;
    }

    public long cal(int big, int length) {
        if (length + 1 < big) {
            // 一直递减
            int small = big - length;
            return (long) (big - 1 + small) * length / 2;
        } else {
            // 递减到1
            int oneCount = length - (big - 1);
            return (long) big * (big - 1) / 2 + oneCount;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int index = 2;
        int maxSum = 6;
        // 2
        System.out.println(new MaxValue1802().maxValue(n, index, maxSum));
    }
}
