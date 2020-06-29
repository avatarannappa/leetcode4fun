import java.util.Arrays;

/**
 * 547. 朋友圈.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/29
 */
public class FindCircleNum547 {

    int count = 0;
    int[] parent;

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        count = M.length;
        parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = i; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(i, j);
                }
            }
        }
        return count;
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
            count--;
        }
    }

    private int find(int x) {
        while (parent[x] != -1) {
            x = parent[x];
        }
        return x;
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new FindCircleNum547().findCircleNum(M));
    }
}
