/**
 * 944. 删列造序.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/5/12
 */
public class MinDeletionSize944 {

    public int minDeletionSize(String[] strs) {
        int res = 0;

        int arrayLen = strs.length;
        int strlen = strs[0].length();
        for (int i = 0; i < strlen; i++) {
            for (int j = 0; j < arrayLen-1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinDeletionSize944 minDeletionSize944 = new MinDeletionSize944();
        String[] strs = {"zyx", "wvu", "tsr"};
        System.out.println(minDeletionSize944.minDeletionSize(strs));
    }
}
