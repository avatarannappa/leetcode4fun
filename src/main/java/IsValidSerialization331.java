import java.util.Stack;

/**
 * 331. 验证二叉树的前序序列化
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/15
 */
public class IsValidSerialization331 {

    public boolean isValidSerialization(String preorder) {
        String[] array = preorder.split(",");
        if (array.length < 2) {
            return array[0].equals("#");
        }
        Stack<Integer> stack = new Stack<>();
        if (!array[0].equals("#")) {
            stack.push(2);
        }
        for  (int i = 1; i < array.length; i++) {
            String item = array[i];
            if (stack.isEmpty()) {
                return false;
            } else {
                int top = stack.pop();
                top--;
                if (top > 0) {
                    stack.push(top);
                }
            }

            if (!item.equals("#")) {
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String preorder = "9,#,#,1";
        System.out.println(new IsValidSerialization331().isValidSerialization(preorder));
    }
}
