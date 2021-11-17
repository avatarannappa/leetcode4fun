import java.util.LinkedList;
import java.util.List;

/**
 * 682. 棒球比赛. 
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/17
 */
public class CalPoints682 {
    public int calPoints(String[] ops) {
        List<Integer> queue = new LinkedList<>();
        for (String op : ops) {
            if ("C".equals(op)) {
                queue.remove(queue.size() - 1);
            } else if ("D".equals(op)) {
                queue.add(queue.get(queue.size() - 1) * 2);
            } else if ("+".equals(op)) {
                queue.add(queue.get(queue.size() - 1) + queue.get(queue.size() - 2));
            } else {
                queue.add(Integer.valueOf(op));
            }
        }
        return queue.stream().mapToInt(o -> o).sum();
    }

    public static void main(String[] args) {
        String[] ops = { "5", "-2", "4", "C", "D", "9", "+", "+" };
        // 27
        System.out.println(new CalPoints682().calPoints(ops));
    }
}
