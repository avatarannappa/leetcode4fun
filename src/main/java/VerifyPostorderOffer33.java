import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/4
 */
public class VerifyPostorderOffer33 {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : postorder) {
            list.add(i);
        }
        return recursion(list);
    }

    public boolean recursion(List<Integer> postorder) {
        if (postorder.size() <= 1) {
            return true;
        }
        int root = postorder.get(postorder.size() - 1);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        boolean rSign = false;
        for (int i = 0; i < postorder.size() - 1; i++) {
            int item = postorder.get(i);
            if (item < root) {
                if (rSign) {
                    return false;
                }
                left.add(item);
            } else {
                rSign = true;
                right.add(item);
            }
        }
        return recursion(left) && recursion(right);
    }

    public static void main(String[] args) {
        int[] postorder = {1,2,5,10,6,9,4,3};
        System.out.println(new VerifyPostorderOffer33().verifyPostorder(postorder));
    }

}
