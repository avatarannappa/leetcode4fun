/**
 * 1816. 截断句子
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/17
 */
public class TruncateSentence1816 {

    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for (int i = 0; i < k; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(new TruncateSentence1816().truncateSentence(s, k));
    }
}
