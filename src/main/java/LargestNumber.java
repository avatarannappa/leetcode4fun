import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author avatarannappa
 * @version 1.0, 2018/12/21
 */
public class LargestNumber {
    public static void main(String[] args) {
        // int[] nums = {3, 30, 34, 5, 9};
        int[] nums = {12, 121};
        String check = "9534330";
        System.out.println(largestNumber(nums));
        System.out.println(check);
        System.out.println("asd".substring(0, 1));
    }

    static String largestNumber(int[] nums) {
        String result = "";
        List<String> strList = new LinkedList<String>();
        for (int i = 0; i < nums.length; i++) {
            String num = String.valueOf(nums[i]);
            strList.add(num);

        }

        Collections.sort(strList, new Comparator<String>() {
            public int compare(String o1, String o2) {

                return comp(o1, o2);
            }
        });
        Collections.reverse(strList);
        for (String s : strList) {
            result = result + s;
        }
        char[] resultArry = result.toCharArray();
        boolean isZero = true;
        for (char r : resultArry) {
            if (r != '0') {
                isZero = false;
                break;
            }
        }
        if (isZero) {
            return "0";
        }
        return result;
    }

    static int comp(String o1, String o2) {
        // {12,121}
        // {12121,12}
        // 递归比较字符串大小
        int result = 0;
        if (o1.length() == o2.length()) {
            return o1.compareTo(o2);
        } else if (o1.length() > o2.length()) {
            String pre = o1.substring(0, o2.length());
            String las = o1.substring(o2.length(), o1.length());
            int tempResult = pre.compareTo(o2);
            if (tempResult != 0) {
                return tempResult;
            } else {
                return comp(las, o2);
            }
        } else {
            String pre = o2.substring(0, o1.length());
            String las = o2.substring(o1.length(), o2.length());
            int tempResult = o1.compareTo(pre);
            if (tempResult != 0) {
                return tempResult;
            } else {
                return comp(o1, las);
            }
        }
    }
}
