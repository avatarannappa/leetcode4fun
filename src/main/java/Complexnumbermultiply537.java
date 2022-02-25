/**
 * 537. 复数乘法.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/2/25
 */
public class Complexnumbermultiply537 {

    public String complexNumberMultiply(String num1, String num2) {
        String[] arr1 = num1.split("\\+");
        String[] arr2 = num2.split("\\+");
        int a = Integer.parseInt(arr1[0]);
        int b = Integer.parseInt(arr1[1].substring(0, arr1[1].length() - 1));
        int c = Integer.parseInt(arr2[0]);
        int d = Integer.parseInt(arr2[1].substring(0, arr2[1].length() - 1));
        String ans = "";
        int x = a * c - b * d;
        int y = a * d + b * c;
        ans = x + "+" + y + "i";
        return ans;
    }

    public static void main(String[] args) {
        String num1 = "1+-1i", num2 = "1+-1i";
        // "0+-2i"
        System.out.println(new Complexnumbermultiply537().complexNumberMultiply(num1, num2));
    }

}
