import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 736. Lisp语法解析.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/22
 */
public class Evaluate736 {

    List<Map<String, Integer>> scope = new LinkedList<>();

    public int evaluate(String expression) {
        scope.add(new HashMap<>());
        int res = evaluateInner(expression);
        scope.remove(scope.size() - 1);
        return res;
    }

    private int evaluateInner(String expression) {
        if (expression.charAt(0) != '(') {
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') {
                return Integer.parseInt(expression);
            }
            for (int i = scope.size() - 1; i >= 0; --i) {
                if (scope.get(i).containsKey(expression)) {
                    return scope.get(i).get(expression);
                }
            }
        }
        List<String> expressions = parseExpression(expression.substring(1, expression.length() - 1));
        if ("add".equals(expressions.get(0))) {
            return evaluate(expressions.get(1)) + evaluate(expressions.get(2));
        } else if ("mult".equals(expressions.get(0))) {
            return evaluate(expressions.get(1)) * evaluate(expressions.get(2));
        } else {
            for (int i = 0; i + 2 < expressions.size(); i = i + 2) {
                scope.get(scope.size() - 1).put(expressions.get(i + 1), evaluate(expressions.get(i + 2)));
            }
            return evaluate(expressions.get(expressions.size() - 1));
        }
    }

    public List<String> parseExpression(String expression) {
        List<String> res = new LinkedList<>();
        String[] arr = expression.split(" ");
        int len = arr.length;
        res.add(arr[0]);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 1; i < len; i++) {
            String str = arr[i];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    count++;
                } else if (str.charAt(j) == ')') {
                    count--;
                }
            }
            sb.append(str);
            if (count == 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(" ");
            }
        }
        if (sb.length() > 0) {
            res.add(sb.toString().trim());
        }
        return res;
    }

    public static void main(String[] args) {
        String expression = "(let x 2 (add (let x 3 (let x 4 x)) x))";
        System.out.println(new Evaluate736().evaluate(expression));

//        String e1 = "let x 2 a1 3 b1 4 a1";
//        String e2 = "add 3 4";
//        String e3 = "mult 5 6";
//        System.out.println(new Evaluate736().evaluateSimple(e1));
//        System.out.println(new Evaluate736().evaluateSimple(e2));
//        System.out.println(new Evaluate736().evaluateSimple(e3));
    }
}
