import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 1807. 替换字符串中的括号内容
 * medium
 *
 * @author avatarannappa
 * @date 2023/1/12
 */
public class Evaluate1807 {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                String temp = "";
                i++;
                while (i < s.length() && s.charAt(i) != ')') {
                    temp += s.charAt(i);
                    i++;
                }
                if (map.containsKey(temp)) {
                    sb.append(map.get(temp));
                } else {
                    sb.append("?");
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        String[][] array = {{"name", "bob"}, {"age", "two"}};
        List<List<String>> knowledge = new LinkedList<>();
        for (String[] strings : array) {
            List<String> temp = new LinkedList<>();
            temp.add(strings[0]);
            temp.add(strings[1]);
            knowledge.add(temp);
        }
        System.out.println(new Evaluate1807().evaluate(s, knowledge));
    }
}
