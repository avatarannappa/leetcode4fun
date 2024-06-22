import java.util.*;

/**
 * 2663. 字典序最小的美丽字符串
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2024/6/22
 */
public class SmallestBeautifulString2663 {

    public String smallestBeautifulString(String s, int k) {
        // 贪心
        char bound = (char) ('a' + k);
        char[] arr = s.toCharArray();
        int n = arr.length;

        int i = n - 1;
        arr[i]++;
        while (true) {
            if (arr[i] == bound) {
                if (i == 0) return "";
                arr[i] = 'a';
                arr[--i]++;
            } else if ((i > 0 && arr[i] == arr[i - 1]) || (i > 1 && arr[i] == arr[i - 2])) {
                arr[i]++;
            } else {
                break;
            }
        }
        Deque<Character> q = new ArrayDeque<>();
        if (i - 1 >= 0) {
            q.addLast(arr[i - 1]);
        }
        q.addLast(arr[i]);
        i++;

        char[] mask = {'a', 'b', 'c', 'd'};
        for (; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                if (q.contains(mask[j])) {
                    continue;
                }
                arr[i] = mask[j];
                if (q.size() == 2) {
                    q.pollFirst();
                }
                q.addLast(mask[j]);
                break;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "cfedf";
        int k = 6;
        // dabca
        System.out.println(new SmallestBeautifulString2663().smallestBeautifulString(s, k));
    }
}
