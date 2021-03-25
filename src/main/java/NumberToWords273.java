/**
 * 273. 整数转换英文表示
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/25
 */
public class NumberToWords273 {

    String[] a1 = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] a2 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        String res = recursion(num);
        return res.length() > 0 ? res : "Zero";
    }

    public String recursion(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return a1[num - 1];
        } else if (num < 100) {
            if (num % 10 == 0) {
                return a2[num / 10 - 2];
            } else {
                return a2[num / 10 - 2] + " " + recursion(num % 10);
            }
        } else if (num < 1000) {
            if (num % 100 == 0) {
                return a1[num / 100 - 1] + " Hundred";
            } else {
                return a1[num / 100 - 1] + " Hundred " + recursion(num % 100);
            }
        } else if (num < 100_0000) {
            if (num % 1000 == 0) {
                return recursion(num / 1000) + " Thousand";
            } else {
                return recursion(num / 1000) + " Thousand " + recursion(num % 1000);
            }
        } else if (num < 10_0000_0000) {
            if (num % 100_0000 == 0) {
                return recursion(num / 100_0000) + " Million";
            } else {
                return recursion(num / 100_0000) + " Million " + recursion(num % 100_0000);
            }
        } else {
            if (num % 10_0000_0000 == 0) {
                return recursion(num / 10_0000_0000) + " Billion";
            } else {
                return recursion(num / 10_0000_0000) + " Billion " + recursion(num % 10_0000_0000);
            }
        }
    }

    public static void main(String[] args) {
        // "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
        // int num = 1234567891;
        int num = 20;
        System.out.println(new NumberToWords273().numberToWords(num));
    }
}
