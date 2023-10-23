/**
 * 2678. 老人的数目
 * easy
 *
 * @author avatarannappa
 * @date 2023/10/23
 */
public class CountSeniors2678 {

    public int countSeniors(String[] details) {
        int ans = 0;

        for (String detail : details) {
            String str = detail.substring(12, 14);
            if (Integer.valueOf(str) > 60) {
                ans++;
            }
        }

        return ans;
    }
}
