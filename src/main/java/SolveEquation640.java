/**
 * 640. 求解方程
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/10
 */
public class SolveEquation640 {

    public String solveEquation(String equation) {
        // 模拟 a * x + b = 0
        int a = 0;
        int b = 0;
        int n = equation.length();
        char[] arr = equation.toCharArray();
        int sign = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '+') {
                sign = 1;
            } else if (arr[i] == '-') {
                sign = -1;
            } else if (arr[i] == '=') {
                a = a * -1;
                b = b * -1;
                sign = 1;
            } else {
                int end = i;
                while (end < n && arr[end] != '+' && arr[end] != '-' && arr[end] != '=') {
                    end++;
                }
                if (arr[end - 1] == 'x') {
                    a += sign * (i == end - 1 ? 1 : Integer.parseInt(equation.substring(i, end - 1)));
                } else {
                    b += sign * Integer.parseInt(equation.substring(i, end));
                }
                i = end - 1;
            }
        }
        if (a == 0) {
            return b == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + (-b / a);
    }

    public static void main(String[] args) {
        // String equation = "x+5-3+x=6+x-2";
        // x=2
        String equation = "2x=x";
        // Infinite solutions
        System.out.println(new SolveEquation640().solveEquation(equation));
    }
}
