/**
 * 327. 区间和的个数.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/10/28
 */
public class CountRangeSum327 {

    // 防止前缀和溢出
    long[] sum;
    int lower;
    int upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        // 前缀和数组，归并排序，顺序区间和
        long[] sum = new long[nums.length + 1];
        long s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i + 1] = s;
        }
        this.sum = sum;
        this.lower = lower;
        this.upper = upper;
        return recursion(0, sum.length - 1);
    }

    public int recursion(int left, int right) {
        if (left == right) {
            // sum[0] 已经参与计算
            return 0;
        } else {
            int mid = (left + right) / 2;
            int lCount = recursion(left, mid);
            int rCount = recursion(mid + 1, right);
            int res = lCount + rCount;

            // 计算i在左侧，j在右侧
            int s = left;
            int l = mid + 1;
            int r = mid + 1;
            while (s <= mid) {
                while (l <= right && sum[l] - sum[s] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[s] <= upper) {
                    r++;
                }
                s++;
                res += r - l;
            }

            // 归并排序
            int i = left;
            int j = mid + 1;
            long[] sortedArray = new long[right - left + 1];
            int index = 0;
            while (index < sortedArray.length) {
                if (i > mid) {
                    sortedArray[index++] = sum[j++];
                } else if (j > right) {
                    sortedArray[index++] = sum[i++];
                } else {
                    if (sum[i] <= sum[j]) {
                        sortedArray[index++] = sum[i++];
                    } else {
                        sortedArray[index++] = sum[j++];
                    }
                }
            }
            for (int k = 0; k < sortedArray.length; k++) {
                sum[left + k] = sortedArray[k];
            }

            return res;
        }
    }

    public int countRangeSumOld(int[] nums, int lower, int upper) {
        // O(n**2) 超时
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;
        System.out.println(new CountRangeSum327().countRangeSum(nums, lower, upper));
    }
}
