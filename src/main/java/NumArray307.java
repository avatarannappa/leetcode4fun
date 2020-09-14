/**
 * 307. 区域和检索 - 数组可修改.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/14
 */
public class NumArray307 {

    FenwickTree tree;
    int[] nums;

    public NumArray307(int[] nums) {
        this.nums = nums;
        tree = new FenwickTree(nums.length + 2);
        for (int i = 0; i < nums.length; i++) {
            tree.update(i + 1, nums[i]);
        }
    }

    public void update(int i, int val) {
        int old = nums[i];
        tree.update(i + 1, val - old);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int iPre = tree.queryPrefixSum(i);
        int jPre = tree.queryPrefixSum(j + 1);
        return jPre - iPre;
    }

    public static class FenwickTree {
        // 树状数组数据结构
        /**
         * 预处理数组
         */
        private int[] tree;
        private int len;

        public FenwickTree(int n) {
            this.len = n;
            tree = new int[n + 1];
        }

        /**
         * 单点更新
         *
         * @param i     原始数组索引 i
         * @param delta 变化值 = 更新以后的值 - 原始值
         */
        public void update(int i, int delta) {
            // 从下到上更新，注意，预处理数组，比原始数组的 len 大 1，故 预处理索引的最大值为 len
            while (i <= len) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }

        /**
         * 查询前缀和
         *
         * @param i 前缀的最大索引，即查询区间 [0, i] 的所有元素之和
         */
        public int queryPrefixSum(int i) {
            // 从右到左查询
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowbit(i);
            }
            return sum;
        }

        public static int lowbit(int x) {
            // 等价：x & (~x +1)
            return x & (-x);
        }
    }
}
