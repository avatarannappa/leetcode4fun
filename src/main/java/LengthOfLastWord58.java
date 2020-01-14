/**
 * 58. 最后一个单词的长度
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/20
 */
public class LengthOfLastWord58 {
    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        if (array.length == 0) {
            return 0;
        } else {
            return array[array.length - 1].length();
        }
    }

    public static void main(String[] args) {
        String str = " hello world   ";
        String[] array = str.split(" ");

        LengthOfLastWord58 o = new LengthOfLastWord58();
        System.out.println(o.lengthOfLastWord(str));
    }
}
