import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 749. 隔离病毒
 * hard
 *
 * @author avatarannappa
 * @date 2022/7/18
 */
public class ContainVirus749 {

    int[][] mask = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] isInfected;

    public int containVirus(int[][] isInfected) {
        // 1.bfs搜索联通区域，记录边和邻接0
        // 2.添加栏杆
        // 3.扩散
        this.isInfected = isInfected;
        int res = 0;

        while (true) {
            if (end()) {
                break;
            }

            int max = 0;
            int maxZero = 0;
            int ii = 0, jj = 0;
            boolean[][] visited = new boolean[isInfected.length][isInfected[0].length];
            for (int i = 0; i < isInfected.length; i++) {
                for (int j = 0; j < isInfected[0].length; j++) {
                    if (isInfected[i][j] == 1) {
                        // 记录边数量，注意：边数量大，0数量不一定大
                        Map<String, Integer> map = new HashMap<>();
                        // 记录0数量，防止重复
                        Set<String> set = new HashSet<>();
                        bfs(visited, i, j, map, set);
                        if (set.size() > maxZero) {
                            ii = i;
                            jj = j;
                            max = map.get("key");
                            maxZero = set.size();
                        }
                    }
                }
            }
            res += max;
            block(ii, jj);
            visited = new boolean[isInfected.length][isInfected[0].length];
            for (int i = 0; i < isInfected.length; i++) {
                for (int j = 0; j < isInfected[0].length; j++) {
                    if (isInfected[i][j] == 1) {

                        spread(visited, i, j);
                    }
                }
            }


        }
        return res;
    }

    public String gen(int i, int j) {
        return i + "_" + j;
    }

    public boolean end() {
        for (int i = 0; i < isInfected.length; i++) {
            for (int j = 0; j < isInfected[0].length; j++) {
                if (isInfected[i][j] == 0 && neighborZero(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean neighborZero(int i, int j) {
        for (int[] m : mask) {
            int ii = i + m[0];
            int jj = j + m[1];
            if (ii >= 0 && ii < isInfected.length && jj > 0 && jj < isInfected[0].length) {
                if (isInfected[ii][jj] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public void bfs(boolean[][] visited, int i, int j, Map<String, Integer> map, Set<String> set) {
        if (i < 0 || i >= isInfected.length || j < 0 || j >= isInfected[0].length) {
            return;
        }
        if (isInfected[i][j] == 2) {
            return;
        }
        if (isInfected[i][j] == 0) {
            map.put("key", map.getOrDefault("key", 0) + 1);
            set.add(gen(i, j));
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        for (int[] m : mask) {
            bfs(visited, i + m[0], j + m[1], map, set);
        }
    }

    public void block(int i, int j) {
        // 阻拦住
        if (i < 0 || i >= isInfected.length || j < 0 || j >= isInfected[0].length) {
            return;
        }
        if (isInfected[i][j] != 1) {
            return;
        }
        isInfected[i][j] = 2;
        for (int[] m : mask) {
            block(i + m[0], j + m[1]);
        }
    }

    public void spread(boolean[][] visited, int i, int j) {
        // 扩散
        if (i < 0 || i >= isInfected.length || j < 0 || j >= isInfected[0].length) {
            return;
        }
        if (isInfected[i][j] == 2) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (isInfected[i][j] == 0) {
            isInfected[i][j] = 1;
            return;
        }

        for (int[] m : mask) {
            spread(visited, i + m[0], j + m[1]);
        }
    }

    public static void main(String[] args) {
        int[][] isInfected = {
            {1, 1, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 0, 0, 0}};
        // 13
        // int[][] isInfected = {{0, 1, 1, 0}, {1, 0, 0, 0}, {0, 0, 0, 0}};
        // 7
//        int[][] isInfected = {
//            {0, 0, 0, 0, 0},
//            {0, 1, 1, 1, 0},
//            {0, 1, 0, 1, 0},
//            {0, 1, 1, 1, 0},
//            {0, 0, 0, 0, 0}};
        // 16 = 12 + 4
//        int[][] isInfected = {
//            {0, 1, 0, 1, 1, 1, 1, 1, 1, 0},
//            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//            {0, 0, 1, 1, 1, 0, 0, 0, 1, 0},
//            {0, 0, 0, 1, 1, 0, 0, 1, 1, 0},
//            {0, 1, 0, 0, 1, 0, 1, 1, 0, 1},
//            {0, 0, 0, 1, 0, 1, 0, 1, 1, 1},
//            {0, 1, 0, 0, 1, 0, 0, 1, 1, 0},
//            {0, 1, 0, 1, 0, 0, 0, 1, 1, 0},
//            {0, 1, 1, 0, 0, 1, 1, 0, 0, 1},
//            {1, 0, 1, 1, 0, 1, 0, 1, 0, 1}};
        // 38
        System.out.println(new ContainVirus749().containVirus(isInfected));
    }
}
