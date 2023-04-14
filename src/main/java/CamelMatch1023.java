import java.util.ArrayList;
import java.util.List;

/**
 * 1023. 驼峰式匹配
 * medium
 *
 * @author avatarannappa
 * @date 2023/4/14
 */
public class CamelMatch1023 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            boolean flag = true;
            int p = 0;
            for (int i = 0; i < query.length(); i++) {
                char q = query.charAt(i);
                if (p < pattern.length() && pattern.charAt(p) == q) {
                    p++;
                } else if (Character.isUpperCase(q)) {
                    flag = false;
                    break;
                }
            }
            if (p < pattern.length()) {
                flag = false;
            }
            res.add(flag);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FoBaT";
        // false,true,false,false,false
        System.out.println(new CamelMatch1023().camelMatch(queries, pattern));
    }

}
