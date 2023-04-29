/**
 * 2423. 删除字符使频率相同
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2023/4/29
 */
public class EqualFrequency2423 {

    public boolean equalFrequency(String word) {
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            arr[c - 'a'] += 1;
        }

        int a = 0;
        int b = 0;
        int ca = 0;
        int cb = 0;
        for (int i : arr) {
            if (i == 0) {
                continue;
            }
            if (a == 0) {
                a = i;
                ca++;
            } else if (a == i) {
                ca++;
            } else if (b == 0) {
                b = i;
                cb++;
            } else if (b == i) {
                cb++;
            } else {
                return false;
            }
        }
        return (b == 0 && (a == 1 || ca == 1))
                || Math.abs(a - b) == 1 && (a > b ? ca == 1 : cb == 1)
                || ca == 1 && a == 1
                || cb == 1 && b == 1;
    }

    public static void main(String[] args) {
        String word = "aaaabbbbccc";
        System.out.println(new EqualFrequency2423().equalFrequency(word));
    }
}
