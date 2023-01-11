/**
 * 2283. 判断一个数的数字计数是否等于数位的值
 * easy
 *
 * @author avatarannappa
 * @date 2023/1/11
 */
public class DigitCount2283 {

    public boolean digitCount(String num) {
        // 简单模拟，O(n)
        int[] arr = new int[10];
        for (int i = 0; i < num.length(); i++) {
            int c = num.charAt(i) - '0';
            arr[c]++;
        }
        for (int i = 0; i < num.length(); i++) {
            int c = num.charAt(i) - '0';
            if (c != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String num = "1210";
        System.out.println(new DigitCount2283().digitCount(num));
    }
}
