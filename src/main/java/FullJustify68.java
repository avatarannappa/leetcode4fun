import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/28
 */
public class FullJustify68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        String line = "";
        int lineLen = 0;
        for (int i = 0; i < words.length; i++) {
            String nowStr = words[i];
            int nowLen = nowStr.length();
            if (nowLen == maxWidth) {
                if (lineLen == 0) {
                    list.add(nowStr);
                    line = "";
                    lineLen = 0;
                } else {
                    list.add(line);
                    list.add(nowStr);
                    line = "";
                    lineLen = 0;
                }
            } else if (lineLen + nowLen + 1 > maxWidth) {
                list.add(line);
                line = nowStr;
                lineLen = nowLen;
            } else if (lineLen + nowLen + 1 == maxWidth) {
                if (lineLen == 0) {
                    list.add(nowStr);
                    line = "";
                    lineLen = 0;
                } else {
                    list.add(line + " " + nowStr);
                    line = "";
                    lineLen = 0;
                }
            } else {
                if (lineLen == 0) {
                    line += nowStr;
                    lineLen += nowLen;
                } else {
                    line += " " + nowStr;
                    lineLen += nowLen + 1;
                }
            }
        }
        if (line.length() > 0) {
            list.add(line);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String originStr = list.get(i);
            int gap = maxWidth - originStr.length();
            if (i == list.size() - 1) {
                for (int j = 0; j < gap; j++) {
                    originStr += " ";
                }
                result.add(originStr);
            } else {
                String[] originArray = originStr.split(" ");
                int blankCount = originArray.length - 1;

                String blank = " ";
                String str = "";

                if (blankCount == 0) {
                    str += originArray[0];
                    for (int j = 0; j < maxWidth - originArray[0].length(); j++) {
                        str += blank;
                    }
                } else {
                    int count = gap / blankCount;
                    if (count > 0) {
                        for (int m = 0; m < count; m++) {
                            blank += " ";
                        }
                    }
                    int left = gap % blankCount;

                    for (int j = 0; j < blankCount; j++) {
                        str += originArray[j] + blank;
                        if (left > 0) {
                            str += " ";
                            left--;
                        }
                    }
                    str += originArray[originArray.length - 1];
                }
                result.add(str);

            }
        }
        return result;
    }

    public static void main(String[] args) {
        //        String[] words =
        //                {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
        //                "computer.",
        //                        "Art", "is", "everything", "else", "we", "do"};
        //        int maxWidth = 20;int maxWidth =

        //        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        //        int maxWidth = 16;

        //        String[] words = {"Listen", "to", "many,", "speak", "to", "a", "few."};
        //        int maxWidth = 6;

        //        String[] words =
        //                {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
        //                "computer.",
        //                        "Art", "is", "everything", "else", "we", "do"};
        //        int maxWidth = 20;

        //        String[] words = {"a"};
        //        int maxWidth = 2;

        String[] words = {"What", "must", "be", "shall", "be."};
        int maxWidth = 5;
        System.out.println(new FullJustify68().fullJustify(words, maxWidth));
        System.out.println("everything else we do".length());
    }
}
