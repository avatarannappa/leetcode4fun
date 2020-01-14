import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 36. 有效的数独.
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/30
 */
public class IsValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rowList = new ArrayList<>();
        List<Set<Character>> colList = new ArrayList<>();
        List<Set<Character>> setList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rowList.add(new HashSet<>());
            colList.add(new HashSet<>());
            setList.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char temp = board[i][j];
                if (temp == '.') {
                    continue;
                }
                int index = i / 3 + (j / 3) * 3;
                if (rowList.get(i).contains(temp) || colList.get(j).contains(temp) || setList.get(index).contains(
                        temp)) {
                    return false;
                }
                rowList.get(i).add(temp);
                colList.get(j).add(temp);
                setList.get(index).add(temp);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new IsValidSudoku36().isValidSudoku(board));
    }
}
