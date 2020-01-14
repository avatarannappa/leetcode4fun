import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 12. 整数转罗马数字
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/28
 */
public class IntToRoman12 {

    public static Map<Character, Integer> map = new LinkedHashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public String intToRoman(int num) {
        String s = "";
        int stage = 1;
        for (int i = num % 10; num > 0; num = num / 10, i = num % 10) {
            if (stage == 1) {
                // 个位
                char one = 'I';
                char five = 'V';
                char ten = 'X';
                s = cul(one, five, ten, i, s);
            } else if (stage == 2) {
                // 十位
                char one = 'X';
                char five = 'L';
                char ten = 'C';
                s = cul(one, five, ten, i, s);
            } else if (stage == 3) {
                // 百位
                char one = 'C';
                char five = 'D';
                char ten = 'M';
                s = cul(one, five, ten, i, s);
            } else if (stage == 4) {
                // 千位
                char one = 'M';
                char five = ' ';
                char ten = ' ';
                s = cul(one, five, ten, i, s);
            }
            stage++;
        }
        return s;
    }

    private String cul(char one, char five, char ten, int i, String s) {
        // 个位
        if (i == 0) {

        } else if (i >= 1 && i <= 3) {
            for (int j = 0; j < i; j++) {
                s = "" + one + s;
            }
        } else if (i == 4) {
            s = "" + one + five + s;
        } else if (i == 5) {
            s = "" + five + s;
        } else if (i >= 6 && i <= 8) {
            for (int j = 0; j < i - 5; j++) {
                s = "" + one + s;
            }
            s = "" + five + s;
        } else if (i == 9) {
            s = "" + one + ten + s;
        }
        return s;
    }

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(new IntToRoman12().intToRoman(num));
    }
}
