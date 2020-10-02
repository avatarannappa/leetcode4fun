import java.util.Arrays;

/**
 * 685. 冗余连接 II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/2
 */
public class FindRedundantDirectedConnection685 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        UnionFind uf = new UnionFind(nodesCount + 1);
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; ++i) {
            parent[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodesCount; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                parent[node2] = node1;
                if (uf.find(node1) == uf.find(node2)) {
                    cycle = i;
                } else {
                    uf.union(node1, node2);
                }
            }
        }
        if (conflict < 0) {
            return edges[cycle];
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else {
                return conflictEdge;
            }
        }
    }

    class UnionFind {
        int[] ancestor;

        public UnionFind(int n) {
            ancestor = new int[n];
            for (int i = 0; i < n; ++i) {
                ancestor[i] = i;
            }
        }

        public void union(int index1, int index2) {
            ancestor[find(index1)] = find(index2);
        }

        public int find(int index) {
            if (ancestor[index] != index) {
                ancestor[index] = find(ancestor[index]);
            }
            return ancestor[index];
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{2, 1}, {3, 1}, {1, 3}};
        System.out.println(
                Arrays.toString(new FindRedundantDirectedConnection685().findRedundantDirectedConnection(edges)));
    }
}
