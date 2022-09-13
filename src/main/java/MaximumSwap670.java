import java.util.Arrays;
import java.util.Comparator;

/**
 * 670. 最大交换
 * medium
 *
 * @author avatarannappa
 * @date 2022/9/13
 */
public class MaximumSwap670 {

    public int maximumSwap(int num) {
        if (num / 10 == 0) {
            return num;
        }
        String numStr = String.valueOf(num);
        char[] arrTemp = numStr.toCharArray();
        Character[] arr = new Character[numStr.length()];
        for (int i = 0; i < arrTemp.length; i++) {
            arr[i] = arrTemp[i];
        }

        Arrays.sort(arr, Comparator.reverseOrder());
        char[] ans = new char[numStr.length()];
        boolean hasChange = false;
        for (int i = 0; i < numStr.length(); i++) {
            if (hasChange) {
                if (ans[i] < '0') {
                    ans[i] = numStr.charAt(i);
                }
            } else {
                if (!hasChange && numStr.charAt(i) < arr[i]) {
                    ans[i] = arr[i];
                    for (int j = numStr.length() - 1; j >= 0; j--) {
                        if (numStr.charAt(j) == arr[i]) {
                            ans[j] = numStr.charAt(i);
                            break;
                        }
                    }
                    hasChange = true;
                } else {
                    ans[i] = numStr.charAt(i);
                }
            }
        }

        String str = "";

        for (char an : ans) {
            str = str + an;
        }
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        int num = 2736;
        // int num = 10909091;
        // error  90901091
        // output 90909011
        System.out.println(new MaximumSwap670().maximumSwap(num));
    }
}
