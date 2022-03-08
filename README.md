# leecode4fun
A java maven project for leetcode, have some utils like java array to TreeNode.

## Naming Conventions
Class name is the combination of subject function name and subject serial number.

PlatesBetweenCandles2055.java = PlatesBetweenCandles (function name) + 2055 (serial number)

## Class Structure
The function for subject and main function used as test.
```java
/**
 * 2055. 蜡烛之间的盘子.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/3/8
 */
public class PlatesBetweenCandles2055 {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        // 前缀和+区间映射，query[0]的右边最近candle，query[1]的左边最近candle位置映射
        int n = s.length();
        int[] array = new int[n];
        int preCandleIndex = -1;
        // 前缀和
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '|') {
                if (preCandleIndex != -1) {
                    array[i] = array[i - 1] + i - preCandleIndex - 1;
                    preCandleIndex = i;
                    continue;
                }
                preCandleIndex = i;
            }
            if (i > 0) {
                array[i] = array[i - 1];
            }
        }
        // 记录candle位置
        int[] lArray = new int[n];
        int[] rArray = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                lArray[i] = i;
            } else {
                lArray[i] = i == 0 ? 0 : lArray[i-1];
            }
            
            int r = n - i - 1;
            if (s.charAt(r) == '|') {
                rArray[r] = r;
            } else {
                rArray[r] = r == n - 1 ? n - 1 : rArray[r + 1];
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            // query[0]的右边最近candle，query[1]的左边最近candle位置映射。用循环超时，二分貌似可以
            l = rArray[l];
            r = lArray[r];
            if (l < r) {
                ans[i] = array[r] - array[l];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        // [9,0,0,0,0]
        System.out.println(Arrays.toString(new PlatesBetweenCandles2055().platesBetweenCandles(s, queries)));
    }
```

## Some utils
TreeUtil convert array to TreeNode for local test.
```java
/**
 * 树工具类.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/22
 */
public class TreeUtils {

    public static TreeNode arrayToTree(Integer[] nums) {
        // 数组转树
        int index = 0;
        List<TreeNode> list = new ArrayList<>(nums.length);
        TreeNode root = new TreeNode(nums[0]);
        list.add(root);
        int col = 0;
        for (int i = 1; i < nums.length; i++) {
            Integer num = nums[i];
            TreeNode node = null;
            if (num != null) {
                node = new TreeNode(num);
            }
            list.add(node);

            TreeNode now = list.get(index);
            if (col == 0) {
                // left
                now.left = node;
                col++;
            } else if (col == 1) {
                // right
                now.right = node;
                index++;
                col = 0;
            }
        }
        return list.get(0);
    }
}
```
