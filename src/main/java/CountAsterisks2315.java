/**
 * 2315. 统计星号
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2023/1/29
 */
public class CountAsterisks2315 {

    public int countAsterisks(String s) {
        // 模拟，偶数个|
        int ans = 0;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                count++;
            } else if (c == '*') {
                if (count % 2 == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "l|*e*et|c**o|*de|";
        // 2
        System.out.println(new CountAsterisks2315().countAsterisks(s));
    }
}
