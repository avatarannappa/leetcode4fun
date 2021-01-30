import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 433. 最小基因变化
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/1/30
 */
public class MinMutation433 {

    int res = 0;
    List<Integer> reList = new LinkedList<>();
    String start;
    String end;
    String[] bank;

    public int minMutation(String start, String end, String[] bank) {

        this.start = start;
        this.end = end;
        this.bank = bank;
        boolean[] mask = new boolean[bank.length];
        backing(mask, start);
        reList.sort(Comparator.naturalOrder());
        return reList.isEmpty() ? -1 : reList.get(0);
    }

    public void backing(boolean[] mask, String source) {
        for (int i = 0; i < bank.length; i++) {
            if (!mask[i]) {
                String s = bank[i];
                if (diff1(source, s)) {
                    res++;
                    mask[i] = true;
                    if (s.equals(end)) {
                        reList.add(res);
                    } else {
                        backing(mask, s);
                    }
                    res--;
                    mask[i] = false;
                }
            }
        }
    }

    public boolean diff1(String source, String target) {
        int diff = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                if (diff > 0) {
                    return false;
                } else {
                    diff++;
                }
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        String start = "AAAACCCC";
        String end = "CCCCCCCC";
        String[] bank =
                {"AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(new MinMutation433().minMutation(start, end, bank));
    }
}
