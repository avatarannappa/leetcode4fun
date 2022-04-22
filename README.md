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
        int len = s.length();
        int[] sum = new int[len];
        int[] leftCandy = new int[len];
        int[] rightCandy = new int[len];

        int l = -1;
        for (int i = 0; i < len; i++) {
            if (i >= 1) {
                sum[i] = sum[i - 1];
            }
            if (s.charAt(i) == '|') {
                l = i;
            } else {
                sum[i]++;
            }
            leftCandy[i] = l;
        }
        
        int r = len;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            rightCandy[i] = r;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (leftCandy[query[1]] <= rightCandy[query[0]]) {
                res[i] = 0;
            } else {
                res[i] = sum[leftCandy[query[1]]] - sum[rightCandy[query[0]]];
            }
        }
        return res;
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
