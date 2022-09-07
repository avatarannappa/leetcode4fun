import java.util.ArrayList;
import java.util.List;

/**
 * 1592. 重新排列单词间的空格
 * easy
 *
 * @author avatarannappa
 * @date 2022/9/7
 */
public class ReorderSpaces1592 {

    public String reorderSpaces(String text) {
        StringBuilder sb = new StringBuilder();
        int blankCount = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                blankCount++;
            } else {
                String str = "";
                while (i < text.length() && text.charAt(i) != ' ') {
                    str += text.charAt(i++);
                }
                list.add(str);
                if (i == text.length()) {
                    break;
                }
                i--;
            }
        }
        if (list.size() == 1) {
            sb.append(list.get(0));
            for (int i = 0; i < blankCount; i++) {
                sb.append(' ');
            }
        } else {
            int avg = blankCount / (list.size() - 1);
            int tail = blankCount % (list.size() - 1);
            String avgStr = "";
            String tailStr = "";
            for (int i = 0; i < avg; i++) {
                avgStr += ' ';
            }
            for (int i = 0; i < tail; i++) {
                tailStr += ' ';
            }
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(avgStr);
                }
            }
            sb.append(tailStr);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String text = " practice   ";
        //输入：text = " practice   makes   perfect"
        //输出："practice   makes   perfect "
        System.out.println(new ReorderSpaces1592().reorderSpaces(text));
    }
}
