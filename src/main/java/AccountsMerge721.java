import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 721. 账户合并
 * medium
 *
 * @author avatarannappa
 * @date 2024/7/15
 */
public class AccountsMerge721 {

    Map<String, Integer> refMap = new HashMap<>();
    Map<Integer, Set<String>> map = new HashMap<>();
    List<List<String>> accounts;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 哈希表 + 贪心 + 合并
        // TODO 连通图数量，DFS
        // TODO 哈希表 + 并查集
        this.accounts = accounts;
        List<List<String>> result = new ArrayList<>();
        if (accounts == null || accounts.isEmpty()) {
            return result;
        }

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            Set<String> emails = new HashSet<>();
            map.put(i, emails);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (refMap.containsKey(email) && !refMap.get(email).equals(i)) {
                    merge(email, refMap.get(email), i);
                    map.remove(i);
                    break;
                } else {
                    refMap.put(email, i);
                    emails.add(email);
                }
            }

        }

        for (Map.Entry<Integer, Set<String>> entry : map.entrySet()) {
            Integer index = entry.getKey();
            Set<String> emails = entry.getValue();
            List<String> list = new LinkedList<>(emails);
            list.sort(String::compareTo);
            list.add(0, accounts.get(index).get(0));
            result.add(list);
        }
        return result;
    }

    private void merge(String connectEmail, Integer target, Integer source) {
        List<String> account = accounts.get(source);
        Set<String> targetEmails = map.get(target);
        for (int i = 1; i < account.size(); i++) {
            String email = account.get(i);
            if (email.equals(connectEmail)) {
                continue;
            }
            if (refMap.containsKey(email) && !refMap.get(email).equals(target)) {
                // 合并以存在
                mergeExist(target, refMap.get(email));
            } else {
                targetEmails.add(email);
            }
            refMap.put(email, target);
        }
    }

    private void mergeExist(Integer target, Integer source) {
        Set<String> targetEmails = map.get(target);
        Set<String> sourceEmails = map.get(source);
        for (String s : sourceEmails) {
            refMap.put(s, target);
        }
        targetEmails.addAll(sourceEmails);
        map.remove(source);
    }

    public static void main(String[] args) {
        String[][] accountsArr = {{"Alex", "Alex5@m.co", "Alex0@m.co"}, {"Alex", "Alex2@m.co", "Alex3@m.co"}, {"Alex", "Alex0@m.co", "Alex2@m.co"}};
        List<List<String>> accounts = new ArrayList<>();
        for (String[] account : accountsArr) {
            accounts.add(Arrays.asList(account));
        }
        // 输出：[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  
        // ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
        List<List<String>> result = new AccountsMerge721().accountsMerge(accounts);
        for (List<String> r : result) {
            System.out.println(r);
        }
    }
}
