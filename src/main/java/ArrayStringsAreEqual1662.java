/**
 * 1662. 检查两个字符串数组是否相等
 * easy
 *
 * @author avatarannappa
 * @date 2022/11/1
 */
public class ArrayStringsAreEqual1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // 简单模拟
        int j = 0;
        int jj = 0;
        for (int i = 0, ii = 0; i < word1.length; ) {
            if (j == word2.length) {
                return false;
            }
            if (word1[i].charAt(ii) != word2[j].charAt(jj)) {
                return false;
            }
            if (ii < word1[i].length() - 1) {
                ii++;
            } else {
                i++;
                ii = 0;
            }

            if (jj < word2[j].length() - 1) {
                jj++;
            } else {
                j++;
                jj = 0;
            }
        }
        return j == word2.length;
    }

    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(new ArrayStringsAreEqual1662().arrayStringsAreEqual(word1, word2));
    }
}
