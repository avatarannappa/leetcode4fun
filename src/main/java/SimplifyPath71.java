import java.util.LinkedList;

/**
 * 71. 简化路径.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/29
 */
public class SimplifyPath71 {

    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();
        char[] arr = path.toCharArray();
        LinkedList<String> list = new LinkedList<>();
        String section = "/";

        for (int i = 1; i < arr.length; i++) {
            char c = arr[i];
            if ('/' == c) {
                if (arr[i - 1] != '/') {
                    if (section.length() != 0) {
                        list.add(section);
                    }
                    section = "/";
                }
            } else if ('.' == c) {
                int dotLen = 0;
                int j = i;
                for (; j < arr.length; j++) {
                    if (arr[j] == '/') {
                        break;
                    } else {
                        dotLen++;
                    }
                    section += arr[j];
                }
                if (dotLen == 1) {
                } else if (dotLen == 2) {
                    if (!list.isEmpty()) {
                        list.removeLast();
                    }
                } else {
                    list.add(section);
                }
                section = "/";
                i = j;
            } else {
                section += c;
            }
        }
        if (section.length() > 1) {
            list.add(section);
        }
        for (String s : list) {
            result.append(s);
        }
        return result.toString().length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        String path = "/home/foo";
        System.out.println(new SimplifyPath71().simplifyPath(path));
    }
}
