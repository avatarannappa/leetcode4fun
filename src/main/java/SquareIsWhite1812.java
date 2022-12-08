/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 * easy
 *
 * @author avatarannappa
 * @date 2022/12/8
 */
public class SquareIsWhite1812 {

    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a';
        int y = coordinates.charAt(1) - '1';
        return (x + y) % 2 == 1;
    }

    public static void main(String[] args) {
        String coordinates = "a1";
        // false
        System.out.println(new SquareIsWhite1812().squareIsWhite(coordinates));
    }
}
