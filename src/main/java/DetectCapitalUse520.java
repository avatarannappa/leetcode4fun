/**
 * 520. 检测大写字母.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/10
 */
public class DetectCapitalUse520 {

    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        boolean firstUpper = false;
        int upperCount = 0;
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                if (i == 0) {
                    firstUpper = true;
                }
                upperCount++;
            }
        }
        return firstUpper ? upperCount == 1 || upperCount == array.length : upperCount == 0;
    }

    public static void main(String[] args) {
        String word = "usE";
        System.out.println(new DetectCapitalUse520().detectCapitalUse(word));
    }
}
