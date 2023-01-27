/**
 * 1945. 字符串转化后的各位数字之和.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/12/15
 */
public class GetLucky1945 {

    public int getLucky(String s, int k) {
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a' + 1;
            temp += String.valueOf(num);
        }
        for (int i = 0; i < k; i++) {
            int num = 0;
            for (int j = 0; j < temp.length(); j++) {
                num += temp.charAt(j) - '0';
            }
            temp = String.valueOf(num);
        }
        return Integer.parseInt(temp);
    }

    public static void main(String[] args) {
        String s = "zbax";
        int k = 2;
        // 8
        System.out.println(new GetLucky1945().getLucky(s, k));
    }
}
