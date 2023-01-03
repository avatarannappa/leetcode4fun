/**
 * 2042. 检查句子中的数字是否递增
 * easy
 *
 * @author avatarannappa
 * @date 2023/1/3
 */
public class AreNumbersAscending2042 {

    public boolean areNumbersAscending(String s) {
        String[] arr = s.split(" ");
        int pre = 0;

        for (String s1 : arr) {
            if (s1.charAt(0) >= '0' && s1.charAt(0) <= '9') {
                int num = Integer.parseInt(s1);
                if (num <= pre) {
                    return false;
                }
                pre = num;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        // true
        System.out.println(new AreNumbersAscending2042().areNumbersAscending(s));
    }
}
