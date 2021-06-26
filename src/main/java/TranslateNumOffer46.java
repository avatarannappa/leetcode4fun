/**
 * Offer 46. 把数字翻译成字符串
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/27
 */
public class TranslateNumOffer46 {

    int res = 0;

    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        String str = String.valueOf(num);
        recursion(str, 0);
        return res;
    }

    public void recursion(String num, int index) {
        if (index == num.length()) {
            res++;
            return;
        }
        if ("0".equals(num.substring(index, index + 1))) {
            recursion(num, index + 1);
        } else {
            recursion(num, index + 1);
            if (index + 2 <= num.length() && Integer.parseInt(num.substring(index, index + 2)) < 26) {
                recursion(num, index + 2);
            }
        }
    }

    public static void main(String[] args) {
        int num = 506;
        // "bccfi", "bwfi", "bczi", "mcfi"和"mzi"
        System.out.println(new TranslateNumOffer46().translateNum(num));
    }
}
