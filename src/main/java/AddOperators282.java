import java.util.ArrayList;
import java.util.List;

/**
 * 282. 给表达式添加运算符 hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/13
 */
public class AddOperators282 {

    // 定义类变量，减少递归中的参数
    List<String> res = new ArrayList<>();
    String num;
    int target;

    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {
            return res;
        }
        this.num = num;
        this.target = target;
        backTracking(new StringBuilder(), 0, 0, 0);
        return res;
    }

    /**
     * 回溯
     *
     * @param sb        表达式stringBuilder
     * @param index     数字开始位置
     * @param calResult 当前表达式的计算结果
     * @param pre       前一个算子的值，为了*的优先级计算，定义的参数
     */
    public void backTracking(StringBuilder sb, int index, long calResult, long pre) {
        if (index == num.length()) {
            // 结束条件，遍历到num结尾，判断calResult和target是否相同，是否表达式加入结果
            if (calResult == target) {
                res.add(sb.toString());
            }
            return;
        }

        for (int i = index + 1; i <= num.length(); i++) {
            String subStr = num.substring(index, i);
            long temp = Long.valueOf(subStr);
            if (index == 0) {
                // 表达式开始 回溯
                sb.append(subStr);
                backTracking(sb, i, temp, temp);
                sb.delete(0, subStr.length());
            } else {
                // 加 减 乘 分别回溯
                sb.append("+").append(subStr);
                backTracking(sb, i, calResult + temp, temp);
                sb.delete(sb.length() - subStr.length() - 1, sb.length());
                sb.append("-").append(subStr);
                backTracking(sb, i, calResult - temp, -temp);
                sb.delete(sb.length() - subStr.length() - 1, sb.length());
                sb.append("*").append(subStr);
                // 注意*的优先级，需要特殊处理
                backTracking(sb, i, calResult - pre + pre * temp, pre * temp);
                sb.delete(sb.length() - subStr.length() - 1, sb.length());
            }
            if (temp == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        String num = "3456237490";
        int target = 9191;
        System.out.println(new AddOperators282().addOperators(num, target));
    }
}
