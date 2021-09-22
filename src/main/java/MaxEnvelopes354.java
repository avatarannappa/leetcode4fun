import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. 俄罗斯套娃信封问题. hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/22
 */
public class MaxEnvelopes354 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0]));
        int res = 1;
        int[] record = new int[envelopes.length];
        Arrays.fill(record, 1);
        for (int i = 1; i < envelopes.length; i++) {
            int[] envelop = envelopes[i];
            for (int j = 0; j < i; j++) {
                if (envelop[0] > envelopes[j][0] && envelop[1] > envelopes[j][1]) {
                    record[i] = record[i] > record[j] ? record[i] : record[j] + 1;
                    res = Math.max(res, record[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] envelopes = { { 4, 5 }, { 4, 6 }, { 6, 7 }, { 2, 3 }, { 1, 1 } };
        // 4
        System.out.println(new MaxEnvelopes354().maxEnvelopes(envelopes));
    }

}
