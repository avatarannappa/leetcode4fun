/**
 * 557. 反转字符串中的单词 III
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/7
 */
public class ReverseWords557 {

    public String reverseWords(String s) {
        String[] array = s.split(" ");
        String result = "";
        for (String str : array) {
            StringBuilder sb = new StringBuilder();
            for (int j = str.length() - 1; j >= 0; j--) {
                sb.append(str.charAt(j));
            }
            result += sb.toString();
            result += " ";
        }
        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new ReverseWords557().reverseWords(s));
    }
}
