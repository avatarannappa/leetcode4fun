/**
 * 434. 字符串中的单词数
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/19
 */
public class CountSegments434 {

    public int countSegments(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        String[] array = s.split(" ");
        int count = array.length;
        for (String s1 : array) {
            if (s1.isEmpty()) {
                count--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = " Hello,  my name  is John ";
        System.out.println(new CountSegments434().countSegments(s));
    }

}
