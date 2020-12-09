import java.util.HashSet;
import java.util.Set;

/**
 * 1079. 活字印刷
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/9
 */
public class NumTilePossibilities1079 {

    Set<String> set = new HashSet<>();
    char[] array;

    public int numTilePossibilities(String tiles) {
        if (tiles == null || tiles.length() < 1) {
            return 0;
        }

        boolean[] visited = new boolean[tiles.length()];
        this.array = tiles.toCharArray();
        backTracking(visited, 0, "");
        return set.size();
    }

    public void backTracking(boolean[] visited, int size, String s) {
        if (size == array.length) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                set.add(s + array[i]);
                backTracking(visited, size + 1, s + array[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String tiles = "AAABBC";
        // AAB 8
        // AAABBC 188
        System.out.println(new NumTilePossibilities1079().numTilePossibilities(tiles));
    }
}
