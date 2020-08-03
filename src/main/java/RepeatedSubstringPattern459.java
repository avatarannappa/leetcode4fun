/**
 * 459. 重复的子字符串.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/3
 */
public class RepeatedSubstringPattern459 {

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

}
