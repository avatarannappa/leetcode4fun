import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. 简化路径.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/29
 * @version 1.1, 2022/1/13
 */
public class SimplifyPath71 {

    public String simplifyPath(String path) {
        // 修复badcase "/hello../world" -> 结果：“/hello../world”
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuilder ans = new StringBuilder();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }

    public String simplifyPathOld(String path) {
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
        String path = "/hello../world";
        System.out.println(new SimplifyPath71().simplifyPath(path));
    }
}
