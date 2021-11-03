import java.util.HashMap;
import java.util.Map;

/**
 * 329. 矩阵中的最长递增路径.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/3
 */
public class LongestIncreasingPath329 {

	int[][] matrix;
	int m;
	int n;
	int[][] mask = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	int max = 0;
	Map<String, Integer> map = new HashMap<>();

	public int longestIncreasingPath(int[][] matrix) {
		this.matrix = matrix;
		this.m = matrix.length;
		this.n = matrix[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, dfs(i, j));
			}
		}
		return max;
	}

	public int dfs(int x, int y) {
		String key = x + "#" + y;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		int res = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + mask[i][0];
			int ny = y + mask[i][1];
			if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] > matrix[x][y]) {
				res = Math.max(res, dfs(nx, ny) + 1);
			}
		}
		map.put(key, res);
		return res;
	}

	// 回溯 case:135/138 超时
	// int[][] matrix;
	// int m;
	// int n;
	// int[][] mask = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	// int res = 0;
	// Map<String, Integer> map = new HashMap<>();

	// public int longestIncreasingPath(int[][] matrix) {
	// this.matrix = matrix;
	// this.m = matrix.length;
	// this.n = matrix[0].length;

	// for (int i = 0; i < m; i++) {
	// for (int j = 0; j < n; j++) {
	// dfs(new boolean[m][n], i, j, 1);
	// }
	// }
	// return res;
	// }

	// public void dfs(boolean[][] visited, int x, int y, int count) {
	// 好像不用visited，因为是递增
	// res = Math.max(res, count);
	// for (int i = 0; i < 4; i++) {
	// int nx = x + mask[i][0];
	// int ny = y + mask[i][1];
	// if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
	// if (matrix[nx][ny] > matrix[x][y]) {
	// visited[nx][ny] = true;
	// dfs(visited, nx, ny, count + 1);
	// visited[nx][ny] = false;

	// }

	// }
	// }
	// }
	public static void main(String[] args) {
		int[][] matrix = { { 5, 4, 3 }, { 6, 1, 2 }, { 7, 8, 9 } };
		System.out.println(new LongestIncreasingPath329().longestIncreasingPath(matrix));
	}
}
