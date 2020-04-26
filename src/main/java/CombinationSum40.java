import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 40. 组合总和 II
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/26
 */
public class CombinationSum40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        int min = candidates[0];
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(candidates.length, target, new LinkedList<>());
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node no = queue.poll();
            int index = no.index;
            int value = no.value;
            List<Integer> list = no.list;
            int pre = 0;
            for (int i = index - 1; i >= 0; i--) {
                if (pre == candidates[i]) {
                    continue;
                }
                if (value - candidates[i] == 0) {
                    List<Integer> newList = new LinkedList<>(list);
                    newList.add(candidates[i]);
                    result.add(newList);
                } else if (value - candidates[i] > 0) {
                    List<Integer> newList = new LinkedList<>(list);
                    newList.add(candidates[i]);
                    Node newNode = new Node(i, value - candidates[i], newList);
                    queue.offer(newNode);
                }
                pre = candidates[i];
            }
        }
        return result;
    }

    public static class Node {
        int index;
        int value;
        List<Integer> list;

        Node(int index, int value, List<Integer> list) {
            this.index = index;
            this.value = value;
            this.list = list;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new CombinationSum40().combinationSum2(candidates, target));
    }
}
