import java.util.ArrayList;
import java.util.List;

/**
 * 792. 匹配子序列的单词数
 * medium
 *
 * @author avatarannappa
 * @date 2022/11/17
 */
public class NumMatchingSubseq792 {

    public int numMatchingSubseq(String s, String[] words) {
        // 预处理，记录字母在s中位置
        // 二分查找优化
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String w : words) {
            if (w.length() > s.length()) {
                --res;
                continue;
            }
            int p = -1;
            for (int i = 0; i < w.length(); ++i) {
                char c = w.charAt(i);
                int index = c - 'a';
                if (pos[index].isEmpty() || pos[index].get(pos[index].size() - 1) <= p) {
                    --res;
                    break;
                }
                p = binarySearch(pos[index], p);
            }
        }
        return res;
    }

    public int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }

    public static void main(String[] args) {
        // 输入: s = "abcde", words = ["a","bb","acd","ace"]
        // 输出: 3
        // 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(new NumMatchingSubseq792().numMatchingSubseq(s, words));
    }
}
