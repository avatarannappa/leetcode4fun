import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1078. Bigram 分词.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/26
 */
public class FindOcurrences1078 {

    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();

        String temp = first + " " + second + " ";
        int from = 0;
        for (int i = text.indexOf(temp, from); i < text.length(); i = text.indexOf(temp, from)) {
            if (i == -1) {
                break;
            }
            from = i + first.length();
            if (i > 0 && text.charAt(i - 1) != ' ') {
                continue;
            }
            int start = i + temp.length();
            int end = text.indexOf(" ", start);
            end = end == -1 ? text.length() : end;
            String str = text.substring(start, end);
            list.add(str);

        }

        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String text = "alice is aa good girl she is a good student";
        String first = "a";
        String second = "good";
        System.out.println(Arrays.toString(new FindOcurrences1078().findOcurrences(text, first, second)));
    }
}
