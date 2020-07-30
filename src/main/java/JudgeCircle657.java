/**
 * 657. 机器人能否返回原点.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/30
 */
public class JudgeCircle657 {

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        char[] array = moves.toCharArray();
        int x = 0;
        int y = 0;
        for (char c : array) {
            if ('U' == c) {
                y++;
            } else if ('D' == c) {
                y--;
            } else if ('L' == c) {
                x++;
            } else if ('R' == c) {
                x--;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        String moves = "URDL";
        System.out.println(new JudgeCircle657().judgeCircle(moves));
    }
}
