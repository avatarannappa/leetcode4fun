import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级.
 * medium
 *
 * @author avatarannapa
 * @version 1.0, 2020/10/23
 */
public class DiffWaysToCompute241 {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.valueOf(input));
            return result;
        }
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                for (Integer left : diffWaysToCompute(input.substring(0, i))) {
                    for (Integer right : diffWaysToCompute(input.substring(i + 1))) {
                        if (input.charAt(i) == '+') {
                            result.add(left + right);
                        } else if (input.charAt(i) == '-') {
                            result.add(left - right);
                        } else if (input.charAt(i) == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
        System.out.println(new DiffWaysToCompute241().diffWaysToCompute(input));
    }
}
