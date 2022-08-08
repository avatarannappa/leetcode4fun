import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 761. 特殊的二进制序列
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/8
 */
public class MakeLargestSpecial761 {

    public String makeLargestSpecial(String s) {
        // 递归，每一层都最大
        if (s.length() == 0) {
            return "";
        }
        List<String> list = new LinkedList<>();
        int count = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                String str = "1" + makeLargestSpecial(s.substring(index + 1, i)) + "0";
                list.add(str);
                index = i + 1;
            }
        }
        list.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String s1 : list) {
            sb.append(s1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "11011000";
        // 11100100
        System.out.println(new MakeLargestSpecial761().makeLargestSpecial(s));
    }
}
