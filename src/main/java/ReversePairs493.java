/**
 * 493. 翻转对.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/13
 */
public class ReversePairs493 {

    int[] nums;

    public int reversePairs(int[] nums) {
        // O(n^2) 超时，模拟两重循环
        // O(nlogn)
        this.nums = nums;
        return recursion(0, nums.length - 1);
    }

    private int recursion(int l, int r) {
        if (l == r) {
            return 0;
        } else {
            int mid = (l + r) >>> 1;
            int lCount = recursion(l, mid);
            int rCount = recursion(mid + 1, r);
            int ans = lCount + rCount;
            // 计算[l, mid], [mid + 1, r]间翻转对
            // 这步时间复杂度怎么算？O((n/2)^2)
            int i = l;
            int j = mid + 1;
            while (i <= mid) {
                while (j <= r && (long) nums[i] > 2 * (long) nums[j]) {
                    j++;
                }
                ans += j - (mid + 1);
                i++;
            }

            // 排序, O(n)
            int[] sorted = new int[r - l + 1];
            i = l;
            j = mid + 1;
            for (int k = 0; k < sorted.length; k++) {
                if (i > mid) {
                    while (j <= r) {
                        sorted[k++] = nums[j++];
                    }
                } else if (j > r) {
                    while (i <= mid) {
                        sorted[k++] = nums[i++];
                    }
                } else if (nums[i] < nums[j]) {
                    sorted[k] = nums[i++];
                } else {
                    sorted[k] = nums[j++];
                }
            }
            for (int k = 0; k < sorted.length; k++) {
                nums[l + k] = sorted[k];
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 5, 1};
        // 3
        System.out.println(new ReversePairs493().reversePairs(nums));
    }
}
