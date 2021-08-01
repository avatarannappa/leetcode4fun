import java.util.*;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/8/1
 */
public class KWeakestRows1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int[] ints = mat[i];
            int val = 0;
            for (int anInt : ints) {
                if (anInt == 0) break;
                val++;
            }
            map.put(i, val);
        }


        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue() == 0 ? o1.getKey() - o2.getKey() : o1.getValue() - o2.getValue());
        priorityQueue.addAll(map.entrySet());

        for (int i = 0; i < res.length; i++) {
            res[i] = priorityQueue.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        int k = 3;
        System.out.println(Arrays.toString(new KWeakestRows1337().kWeakestRows(mat, k)));

    }
}
