/**
 * 258. 各位相加
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/14
 */
public class AddDigits258 {

    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        int num = 38;
        System.out.println(new AddDigits258().addDigits(num));
    }
}
