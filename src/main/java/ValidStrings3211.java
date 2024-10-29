import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 3211. 生成不含相邻零的二进制字符串.
 * medium
 *
 * @author avatarannappa
 * @version 2024/10/29
 */
public class ValidStrings3211 {


    public List<String> validStrings(int n) {
        // TODO 位运算：首先将数字按位取反，记为 t。如果 t & (t>>1) 为 0，则 t 中没有相邻的 0
        Deque<String> res = new ArrayDeque<>();
        res.add("0");
        res.add("1");
        while (n > 1) {
            List<String> tmp = new ArrayList<>();
            while (!res.isEmpty()) {
                String s = res.poll();
                if (s.endsWith("0")) {
                    tmp.add(s + "1");
                } else {
                    tmp.add(s + "0");
                    tmp.add(s + "1");
                }
            }
            res.addAll(tmp);
            n--;
        }
        return new LinkedList<>(res);
    }

    public static void main(String[] args) {
        int n = 3;
        // 输出： ["010","011","101","110","111"]
        System.out.println(new ValidStrings3211().validStrings(n));
    }
}
