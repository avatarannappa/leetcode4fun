import java.util.HashMap;
import java.util.Map;

/**
 * 1797. 设计一个验证系统
 * medium
 *
 * @author avatarannappa
 * @date 2023/2/9
 */
public class AuthenticationManager1797 {

    Map<String, Long> map = new HashMap<>();
    long timeToLive;

    public AuthenticationManager1797(int timeToLive) {
        // 模拟，注意count函数的并发问题
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (!map.containsKey(tokenId)) {
            return;
        }
        long oldTime = map.get(tokenId);
        if (currentTime < oldTime) {
            map.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int ans = 0;
        if (map.isEmpty()) {
            return 0;
        }
        for (String tokenId : map.keySet()) {
            long expTime = map.get(tokenId);
            if (currentTime < expTime) {
                ans++;
            }
            // 这里不要remove，会有并发问题
//            else {
//                map.remove(tokenId);
//            }
        }
        return ans;
    }
}
