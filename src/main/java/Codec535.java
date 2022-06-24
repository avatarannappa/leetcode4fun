import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 535. TinyURL 的加密与解密.
 * medium
 *
 * @author avatarannappa
 * @date 2022/6/24
 */
public class Codec535 {

    String domain = "http://tinyurl.com/";
    Map<String, String> map = new HashMap<>();
    Map<String, String> reversMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        // 用数字+大小写字母字典，random 6次。(10 + 26*2)^6也基本不会重，还很短。懒得写
        if (map.containsKey(longUrl)) {
            return map.get(longUrl);
        } else {
            String path = domain + UUID.randomUUID().toString();
            map.put(longUrl, path);
            reversMap.put(path, longUrl);
            return path;
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return reversMap.get(shortUrl);
    }

    public static void main(String[] args) {
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        Codec535 codec = new Codec535();
        String shortUrl = codec.encode(longUrl);
        System.out.println(shortUrl);
        System.out.println(codec.decode(shortUrl));
    }
}
