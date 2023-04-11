/**
 * 1041. 困于环中的机器人
 * medium
 *
 * @author avatarannappa
 * @date 2023/4/11
 */
public class IsRobotBounded1041 {

    public boolean isRobotBounded(String instructions) {
        int[][] steps = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int direction = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'G') {
                x += steps[direction][0];
                y += steps[direction][1];
            } else if (c == 'L') {
                direction = (direction + 4 - 1) % 4;
            } else {
                direction = (direction + 1) % 4;
            }
        }
        return direction != 0 || x == 0 && y == 0;
    }

    public static void main(String[] args) {
        String instructions = "GL";
        System.out.println(new IsRobotBounded1041().isRobotBounded(instructions));
    }
}
