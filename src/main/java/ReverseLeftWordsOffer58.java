/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/23
 */
public class ReverseLeftWordsOffer58 {

    public String reverseLeftWords(String s, int n) {
        if (n > s.length()) {
            n = n % s.length();
        }
        String start = s.substring(0, n);
        String end = s.substring(n);
        return end + start;
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 6;
        System.out.println(new ReverseLeftWordsOffer58().reverseLeftWords(s, n));
    }

}
