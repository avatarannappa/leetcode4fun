import java.util.Arrays;

/**
 * 684. 冗余连接
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/1/13
 */
public class FindRedundantConnection684 {

    public int[] findRedundantConnection(int[][] edges) {
        // 并查集
        int nodesCount = edges.length;
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int in = edge[0];
            int out = edge[1];
            if (find(parent, in) != find(parent, out)) {
                union(parent, in, out);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public static void main(String[] args) {
        // [[1,2], [2,3], [3,4], [1,4], [1,5]] result [1, 4]
        // [[1,4],[3,4],[1,3],[1,2],[4,5]] result[1, 3]
        int[][] edges = {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}};
        System.out.println(Arrays.toString(new FindRedundantConnection684().findRedundantConnection(edges)));
    }
}
