package LCP;

import java.util.Arrays;

/**
 * LCP 40. 心算挑战
 * easy
 *
 * @author avatarannappa
 * @date 2024/8/1
 */
public class MaxmiumScore40 {

    public int maxmiumScore(int[] cards, int cnt) {
        // 排序+贪心
        Arrays.sort(cards);
        int sum = 0;
        int cntCopy = cnt;
        int minOddIndex = -1;
        int minEvenIndex = -1;
        for (int i = cards.length - 1; i >= 0; i--) {
            sum += cards[i];
            cnt--;
            if (cards[i] % 2 == 1) {
                minOddIndex = i;
            } else {
                minEvenIndex = i;
            }

            if (cnt == 0) {
                if (sum % 2 == 0) {
                    return sum;
                }
                break;
            }
        }

        if (minOddIndex == -1 && minEvenIndex == -1) {
            return 0;
        }

        int maxOdd = -1;
        int maxEven = -1;
        for (int i = cards.length - 1 - cntCopy; i >= 0; i--) {
            if (cards[i] % 2 == 1 && maxOdd == -1) {
                maxOdd = cards[i];
            } else if (cards[i] % 2 == 0 && maxEven == -1) {
                maxEven = cards[i];
            }
        }
        int res = 0;
        if (maxOdd != -1 && minEvenIndex != -1) {
            res = Math.max(res, sum - cards[minEvenIndex] + maxOdd);
        }
        if (maxEven != -1 && minOddIndex != -1) {
            res = Math.max(res, sum - cards[minOddIndex] + maxEven);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] cards = {1, 2, 8, 9};
        int cnt = 3;
        // 输出：18
        System.out.println(new MaxmiumScore40().maxmiumScore(cards, cnt));
    }
}
