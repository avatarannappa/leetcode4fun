import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 39. 组合总和
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/23
 */
public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        int min = candidates[0];
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(candidates.length - 1, target, new LinkedList<>());
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node no = queue.poll();
            int index = no.index;
            int value = no.value;
            List<Integer> list = no.list;
            for (int i = index; i >= 0; i--) {
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
        CombinationSum39 c = new CombinationSum39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = c.combinationSum(candidates, target);
        System.out.println(result);
    }
}
