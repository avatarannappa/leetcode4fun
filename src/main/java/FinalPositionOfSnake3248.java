import java.util.List;

/**
 * 3248. 矩阵中的蛇.
 * easy
 *
 * @author avatarannappa
 * @version 2024/11/21
 */
public class FinalPositionOfSnake3248 {

    public int finalPositionOfSnake(int n, List<String> commands) {
        int res = 0;
        for (String command : commands) {
            if (command.equals("UP")) {
                res -= n;
            } else if (command.equals("DOWN")) {
                res += n;
            } else if (command.equals("LEFT")) {
                res--;
            } else if (command.equals("RIGHT")) {
                res++;
            }
        }
        return res;
    }

}
