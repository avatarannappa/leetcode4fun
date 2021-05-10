/**
 * 633. 平方数之和
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/10
 */
public class JudgeSquareSum633 {

    public boolean judgeSquareSum(int c) {
        int end = (int) Math.sqrt(c);
        int start = 0;
        while (start <= end) {
            if (start * start + end * end == c) {
                return true;
            } else if (start * start + end * end < c) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new JudgeSquareSum633().judgeSquareSum(3));
    }
}
