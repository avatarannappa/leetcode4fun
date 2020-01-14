import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15 三数之和.
 *
 * @author avatarannappa
 * @version 1.0, 2019/2/20
 */
public class ThreeSum {

    public static List<List<Integer>> threeSumTimeOut(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> exist = new ArrayList<>();
        List<String> existStr = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        Collections.sort(temp);
                        if (!existStr.isEmpty()) {
                            if (existStr.contains("" + temp.get(0) + temp.get(1) + temp.get(2))) {
                                continue;
                            }
                        }

                        result.add(temp);
                        existStr.add("" + temp.get(0) + temp.get(1) + temp.get(2));
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumNew(int[] nums) {
        // 87s
        List<List<Integer>> result = new ArrayList<>();
        Long start = System.currentTimeMillis();
        Arrays.sort(nums);
        System.out.println("sort time : " + (System.currentTimeMillis() - start) + "ms");
        List<List<Integer>> exist = new ArrayList<>();
        List<String> existStr = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] > 0) {
                    break;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] > 0) {
                        break;
                    }
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        if (!existStr.isEmpty()) {
                            if (existStr.contains("" + temp.get(0) + temp.get(1) + temp.get(2))) {
                                continue;
                            }
                        }

                        result.add(temp);
                        existStr.add("" + temp.get(0) + temp.get(1) + temp.get(2));
                    }
                }
            }
        }
        System.out.println("result : " + (System.currentTimeMillis() - start) + "ms");
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Long start = System.currentTimeMillis();
        Arrays.sort(nums);
        System.out.println("sort time : " + (System.currentTimeMillis() - start) + "ms");
        List<List<Integer>> exist = new ArrayList<>();
        List<String> existStr = new ArrayList<>();

        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int nowInt = nums[i];
            if (nowInt > 0) {
                break;
            }
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                if (nowInt + nums[l] + nums[r] == 0) {

                    List<Integer> temp = new ArrayList<>();
                    temp.add(nowInt);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    if (!existStr.isEmpty()) {
                        if (existStr.contains("" + temp.get(0) + temp.get(1) + temp.get(2))) {
                            // {0,0,0,0} 情况，防止死循环
                            l++;
                            continue;
                        }
                    }

                    result.add(temp);
                    existStr.add("" + temp.get(0) + temp.get(1) + temp.get(2));
                } else if (nowInt + nums[l] + nums[r] > 0) {
                    r--;
                    if (r < l) {
                        break;
                    }
                } else {
                    l++;
                    if (l >= len - 1) {
                        break;
                    }
                }

            }

        }
        System.out.println("result : " + (System.currentTimeMillis() - start) + "ms");
        return result;
    }

    public static List<List<Integer>> threeSumOther(int[] nums) {
        Long start = System.currentTimeMillis();
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }

        int n = nums.length;
        if (n == 0) {
            return res;
        }

        //为了查询时加速，这里先排序
        Arrays.sort(nums);

        //收缩窗口的方式，时间复杂度O(n2)
        for (int i = 0; i < n; i++) {
            int a = nums[i], l = i + 1, r = n - 1;
            //加速n
            if (i > 0 && a == nums[i - 1]) {
                continue;
            }

            //收缩窗口
            while (l < r) {
                int b = nums[l], c = nums[r], sum = a + b + c;
                if (sum < 0) {
                    l++;       //左->右收缩
                } else if (sum > 0) {
                    r--;  //右->左收缩
                } else {
                    List<Integer> abc = new ArrayList<>();
                    abc.add(a);
                    abc.add(b);
                    abc.add(c);
                    res.add(abc);

                    //加速l
                    while (l < r && b == nums[l + 1]) {
                        l++;
                    }
                    //加速r
                    while (l < r && c == nums[r - 1]) {
                        r--;
                    }

                    l++;
                    r--;   //左、右收缩
                }
            }
        }
        System.out.println("result : " + (System.currentTimeMillis() - start) + "ms");
        return res;
    }

    public static void main(String[] args) {
        // int[] nums = {-1, 0, 1, 2, -1, -4};
        // int[] nums = {-2, 0, 1, 1, 2};
        // int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> temp : result) {
            System.out.print("[");
            for (Integer num : temp) {
                System.out.print(num + ",");
            }
            System.out.println("]");
        }
        System.out.println(Math.pow(3,7));
    }
}
