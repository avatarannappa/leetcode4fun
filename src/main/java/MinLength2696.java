import java.util.Stack;

/**
 * 2696. 删除子串后的字符串最小长度
 * easy
 *
 * @author avatarannappa
 * @date 2024/1/10
 */
public class MinLength2696 {

    public int minLength(String s) {
        char[] arr = s.toCharArray();
        boolean[] visited = new boolean[arr.length];
        int ans = arr.length;
        boolean cont;
        do {
            cont = false;
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i] && (arr[i] == 'A' || arr[i] == 'C')) {
                    for (int j = i + 1; j < arr.length; j++) {
                        if (!visited[j]) {
                            if (((arr[i] == 'A' && arr[j] == 'B') || (arr[i] == 'C' && arr[j] == 'D'))) {
                                visited[i] = true;
                                visited[j] = true;
                                ans -= 2;
                                cont = true;
                            }
                            break;
                        }
                    }
                }
            }
        } while (cont);
        return ans;
    }

    public int minLengthNew(String s) {
        int ans = s.length();

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == 'B') {
                if (!stack.isEmpty() && stack.peek() == 'A') {
                    stack.pop();
                    ans -= 2;
                    continue;
                }
            } else if (c == 'D') {
                if (!stack.isEmpty() && stack.peek() == 'C') {
                    stack.pop();
                    ans -= 2;
                    continue;
                }
            }
            stack.push(c);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "CCDAABBDCD";
        // 0
        System.out.println(new MinLength2696().minLength(s));
    }
}
