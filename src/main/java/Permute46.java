import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

/**
 * 46. 全排列
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/3
 */
public class Permute46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            return result;
        }
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            // int[] newNums = ArrayUtils.remove(nums,i);
            int[] newNums = new int[length - 1];
            System.arraycopy(nums, 0, newNums, 0, i);
            if (i < length - 1) {
                System.arraycopy(nums, i + 1, newNums, i, length - i - 1);
            }
            List<List<Integer>> wtf = permute(newNums);
            for (List<Integer> l : wtf) {
                l.add(num);
                result.add(l);
            }
        }
        return result;
    }

    public List<List<Integer>> permuteOld(int[] nums) {
        // 网站没有ArrayUtils.remove(nums, i)方法，用原写法替换
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            return result;
        }
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int[] newNums = ArrayUtils.remove(nums, i);
        List<List<Integer>> wtf = permuteOld(newNums);
        for (List<Integer> l : wtf) {
            l.add(num);
            result.add(l);
        }
    }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Permute46().permuteOld(nums));
    }
}
