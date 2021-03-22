import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 212. 单词搜索 II
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/22
 */
public class FindWords212 {

    Set<String> result = new HashSet<>();
    char[][] board;
    int m, n;

    public List<String> findWords(char[][] board, String[] words) {

        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        Map<Character, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                int[] array = new int[2];
                array[0] = i;
                array[1] = j;
                List<int[]> list = map.getOrDefault(c, new LinkedList<>());
                list.add(array);
                map.put(c, list);
            }
        }

        for (String word : words) {
            char w = word.charAt(0);
            if (map.containsKey(w)) {
                List<int[]> list = map.get(w);
                for (int[] ints : list) {
                    int x = ints[0];
                    int y = ints[1];
                    boolean[][] visited = new boolean[m][n];
                    dfs(x, y, 0, word, visited);
                }
            }
        }
        return new LinkedList<>(result);
    }

    public void dfs(int x, int y, int index, String word, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        if (visited[x][y]) {
            return;
        }

        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            if (index + 1 == word.length()) {
                result.add(word);
                return;
            }
            dfs(x - 1, y, index + 1, word, visited);
            dfs(x + 1, y, index + 1, word, visited);
            dfs(x, y - 1, index + 1, word, visited);
            dfs(x, y + 1, index + 1, word, visited);
            visited[x][y] = false;
        }

    }

    public static void main(String[] args) {
        //        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l',
        //        'v'}};
        //        String[] words = {"oath", "pea", "eat", "rain"};
        //        char[][] board = {{'a', 'a'}};
        //        String[] words = {"aaa"};
        char[][] board = {{'a', 'b', 'c', 'e'}, {'x', 'x', 'c', 'd'}, {'x', 'x', 'b', 'a'}};
        String[] words = {"abcd"};
        System.out.println(new FindWords212().findWords(board, words));
    }
}
