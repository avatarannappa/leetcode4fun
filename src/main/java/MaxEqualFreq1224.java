import java.util.HashMap;
import java.util.Map;

/**
 * 1224. 最大相等频率
 * hard
 *
 * @author avatarannappa
 * @date 2022/8/18
 */
public class MaxEqualFreq1224 {

    public int maxEqualFreq(int[] nums) {
        // O(n)  corner case真多。。
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int ans = 1;
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = countMap.getOrDefault(num, 0) + 1;
            maxFreq = Math.max(maxFreq, count);
            countMap.put(num, count);
            freqMap.put(count, freqMap.getOrDefault(count, 0) + 1);
            freqMap.put(count - 1, freqMap.getOrDefault(count - 1, 0) - 1);
            if (freqMap.get(count - 1) <= 0) {
                freqMap.remove(count - 1);
            }
            if (freqMap.size() == 1 && (countMap.size() == 1 || maxFreq == 1)) {
                ans = Math.max(ans, i + 1);
            } else if (freqMap.size() == 2 &&
                ((freqMap.get(maxFreq - 1) != null && freqMap.get(maxFreq) == 1)
                    || maxFreq * freqMap.get(maxFreq) == i)) {
                ans = Math.max(ans, i + 1);
            }
        }

        return ans;
    }

    public int maxEqualFreqOld(int[] nums) {
        // 超时
        int ans = 1;

        int[] arr = new int[100001];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            arr[num]++;
            int a = 0;
            int b = 0;
            int aCount = 0;
            int bCount = 0;
            boolean sign = true;
            for (int j : arr) {
                if (j == 0) {
                    continue;
                }
                if (a == 0) {
                    a = j;
                    aCount++;
                } else if (j == a) {
                    aCount++;
                } else {
                    if (b == 0) {
                        b = j;
                        bCount++;
                    } else if (j == b) {
                        bCount++;
                    } else {
                        sign = false;
                        break;
                    }
                }
            }
            if (sign == false) {
                continue;
            } else if (b == 0 && (aCount == 1 || a == 1)) {
                ans = Math.max(ans, i + 1);
            } else if (aCount == 1 && (a == 1 || a - b == 1)) {
                ans = Math.max(ans, i + 1);
            } else if (bCount == 1 && (b == 1 || b - a == 1)) {
                ans = Math.max(ans, i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10, 2, 8, 9, 3, 8, 1, 5, 2, 3, 7, 6};
        // 8
        System.out.println(new MaxEqualFreq1224().maxEqualFreq(nums));
    }
}
