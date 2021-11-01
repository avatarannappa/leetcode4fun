import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 869. 重新排序得到 2 的幂. 
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/1
 */
public class ReorderedPowerOf2I869 {
    public boolean reorderedPowerOf2(int n) {
        // 十进制排序
        Set<char[]> set = new HashSet<>();
        for (int i = 0; i < 32; i++) {
            Integer temp = 1 << i;
            char[] arr = String.valueOf(temp).toCharArray();
            Arrays.sort(arr);
            set.add(arr);
        }

        String nStr = String.valueOf(n);
        char[] nArray = nStr.toCharArray();
        Arrays.sort(nArray);

        Iterator<char[]> iterator = set.iterator();
        while (iterator.hasNext()) {
            char[] s = iterator.next();
            if (compare(s, nArray)) {
                return true;
            }
        }
        return false;
    }

    public boolean compare(char[] s, char[] t) {
        if (s.length != t.length) {
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] != t[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 46;
        System.out.println(new ReorderedPowerOf2I869().reorderedPowerOf2(n));
    }
}
