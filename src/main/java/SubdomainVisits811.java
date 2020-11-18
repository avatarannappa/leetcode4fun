import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. 子域名访问计数
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/18
 */
public class SubdomainVisits811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();

        if (cpdomains == null || cpdomains.length < 1) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] str = cpdomain.split(" ");
            int count = Integer.parseInt(str[0]);
            String domain = str[1];
            String[] array = domain.split("\\.");
            String temp = array[array.length - 1];
            map.put(temp, map.getOrDefault(temp, 0) + count);
            for (int i = array.length - 2; i >= 0; i--) {
                String s = array[i];
                temp = s + "." + temp;
                map.put(temp, map.getOrDefault(temp, 0) + count);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String s = entry.getValue() + " " + entry.getKey();
            result.add(s);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(new SubdomainVisits811().subdomainVisits(cpdomains));
    }

}
