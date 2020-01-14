import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * ***递归参数，result移到类变量，时间从10ms减少到4ms***
 *
 * @author avatarannappa
 * @version 1.0, 2019/6/24
 */
public class GenerateParenthesis22 {
    public static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        GenerateParenthesis22 g = new GenerateParenthesis22();
        g.generateParenthesis(4).forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        generate("", n, n, n*2);
        return result;
    }

    public void gen(String str, int left, int right, int n) {
        if (left == 0) {
            while (right > 0) {
                right--;
                str += ")";
            }
            if (str.length() / 2 == n && str.length() % 2 == 0) {
                result.add(str);
            }
            return;
        }

        gen(str + "(", left - 1, right, n);
        while (left < right) {
            gen(str + ")", left, right - 1, n);
            right--;
        }
    }

    public void generate(String str, int left, int right, int n) {
        if (left == 0 && right == 0) {
            if (str.length() == n) {
                result.add(str);
            }
            return;
        }

        if (left > 0) {
            generate(str + "(", left - 1, right, n);
        }
        while (right > left) {
            generate(str + ")", left, right - 1, n);
            right--;
        }
    }
}
