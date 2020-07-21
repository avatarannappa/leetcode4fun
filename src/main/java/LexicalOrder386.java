import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 386. 字典序排数.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/21
 */
public class LexicalOrder386 {

    public List<Integer> lexicalOrder(int n) {
        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            treeSet.add(String.valueOf(i));
        }
        return treeSet.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new LexicalOrder386().lexicalOrder(123));
    }

}
