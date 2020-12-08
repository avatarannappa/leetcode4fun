import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/8
 */
public class SplitIntoFibonacci842 {

    String num;

    public List<Integer> splitIntoFibonacci(String S) {
        if (S == null || S.length() < 3) {
            return new LinkedList<>();
        }
        num = S;
        Deque<Integer> deque = new LinkedList<>();
        return backTracking(0, 0, 0, 0, deque) ? new LinkedList<>(deque) : new LinkedList<>();
    }

    public boolean backTracking(int n1, int n2, int index, int count, Deque<Integer> deque) {
        int sum = n1 + n2;
        if (index == num.length() && count > 2) {
            return true;
        }
        for (int i = index; i < num.length(); i++) {
            int num = getNumber(index, i);
            if (num == -1) {
                continue;
            }
            if (count < 2) {
                if (count == 0) {
                    n1 = num;
                } else if (count == 1) {
                    n2 = num;
                }

                deque.addLast(num);
                if (backTracking(n1, n2, i + 1, count + 1, deque)) {
                    return true;
                }
                deque.removeLast();
            }

            if (count >= 2) {
                if (sum == num) {
                    deque.addLast(num);
                    if (backTracking(n2, num, i + 1, count + 1, deque)) {
                        return true;
                    }
                    deque.removeLast();
                }
            }
        }
        return false;
    }

    public int getNumber(int l, int r) {
        try {
            if (r > l && num.charAt(l) == '0') {
                return -1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = l; i <= r; i++) {
                sb.append(num.charAt(i));
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            // 例子：11235813213455890144
            return -1;
        }
    }

    public static void main(String[] args) {

        String S = "1101111";
        System.out.println(new SplitIntoFibonacci842().splitIntoFibonacci(S));

    }

}
