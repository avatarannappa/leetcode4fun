import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. 递增子序列.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/29
 */
public class FindSubsequences491 {

    List<List<Integer>> result = new ArrayList<>();
    int[] numsOrigin;
    Set<String> set = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length < 2) {
            return result;
        }
        this.numsOrigin = nums;
        backTracking(0, new ArrayList<>());
        return result;
    }

    public void backTracking(int index, List<Integer> list) {
        if (index == numsOrigin.length) {
            return;
        }

        Integer pre = null;
        for (int i = index; i < numsOrigin.length; i++) {
            List<Integer> newList = new ArrayList<>(list);
            Integer num = numsOrigin[i];
            if (!list.isEmpty() && num < list.get(list.size() - 1)) {
                continue;
            }
            newList.add(numsOrigin[i]);
            if (!num.equals(pre) && newList.size() >= 2) {
                String str = listToString(newList);
                if (!set.contains(str)) {
                    result.add(newList);
                }
                set.add(str);

            }
            if (index == 0 || !num.equals(pre)) {
                backTracking(i + 1, newList);
            }
            pre = num;
        }
    }

    public static String listToString(List<Integer> mList) {
        final String SEPARATOR = ",";
        StringBuilder sb = new StringBuilder();
        String convertedListStr = "";
        if (null != mList && mList.size() > 0) {
            for (Integer item : mList) {
                sb.append(item);
                sb.append(SEPARATOR);
            }
            convertedListStr = sb.toString();
            convertedListStr = convertedListStr.substring(0, convertedListStr.length() - SEPARATOR.length());
            return convertedListStr;
        } else {
            return "List is null!!!";
        }
    }

    public static void main(String[] args) {
        int[] nums = {100, 90, 80, 70, 60, 50, 60, 70, 80, 90, 100};
        System.out.println(new FindSubsequences491().findSubsequences(nums));
    }
}
