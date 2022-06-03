import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/6/4
 */
public class NumUniqueEmails929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] arrays = email.split("@");
            String domain = "@" + arrays[arrays.length - 1];
            String name = arrays[0].split("[+]")[0].replace(".", "");
            set.add(name + domain);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"};
        // 2
        // ["linqmafia@leet+code.com","linqmafia@code.com"]
        System.out.println(new NumUniqueEmails929().numUniqueEmails(emails));
    }
}
