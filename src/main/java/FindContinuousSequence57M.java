import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题57 - II. 和为s的连续正数序列
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/7
 */
public class FindContinuousSequence57M {

    public int[][] findContinuousSequence(int target) {
        List<int[]> lists = new LinkedList<>();
        int sum = 0;

        int[] template = new int[target];
        for (int i = 1; i < target; i++) {
            template[i - 1] = i;
        }

        int start = 1;
        for (int i = 1; i < target; i++) {
            sum += i;
            if (sum == target) {
                int[] a = Arrays.copyOfRange(template, start - 1, i);
                lists.add(a);
            } else {
                int temp = start;
                while (sum > target) {
                    sum -= temp;
                    temp++;
                }
                start = temp;
                if (sum == target) {
                    int[] a = Arrays.copyOfRange(template, start - 1, i);
                    lists.add(a);
                }
            }
        }
        return lists.toArray(new int[lists.size()][]);
    }

    public int[][] findContinuousSequence1(int target) {
        // 超时
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 1; i < target; i++) {
            int sum = 0;
            List<Integer> l = new LinkedList<>();
            for (int j = i; j < target; j++) {
                sum += j;
                if (sum == target) {
                    l.add(j);
                    lists.add(l);
                } else if (sum < target) {
                    l.add(j);
                }
            }
        }
        return listToArray(lists);
    }

    public int[][] listToArray(List<List<Integer>> lists) {
        int m = lists.size();
        int[][] result = new int[m][];
        for (int i = 0; i < m; i++) {
            List<Integer> list = lists.get(i);
            int n = list.size();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = list.get(j);
            }
            result[i] = array;
        }
        return result;
    }

    public static void main(String[] args) {
        int target = 9;
        int[][] result = new FindContinuousSequence57M().findContinuousSequence1(target);
        System.out.println(Arrays.toString(result));
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
