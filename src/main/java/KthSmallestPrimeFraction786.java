import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 786. 第 K 个最小的素数分数.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/7
 */
public class KthSmallestPrimeFraction786 {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // 优先队列，大顶堆
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                double r = o2.val - o1.val;
                return r > 0 ? 1 : r < 0 ? -1 : 0 ;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double d = arr[i] * 1.0 / arr[j];
                Node node = new Node();
                node.val = d;
                node.i = arr[i];
                node.j = arr[j];
                queue.add(node);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return new int[]{queue.peek().i, queue.peek().j};
    }

    public static class Node {

        double val;
        int i;
        int j;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        // 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
        // [2,5]
        int k = 3;
        System.out.println(Arrays.toString(new KthSmallestPrimeFraction786().kthSmallestPrimeFraction(arr, k)));
    }
}
