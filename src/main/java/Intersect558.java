/**
 * 558. 四叉树交集
 * medium
 *
 * @author avatarannappa
 * @date 2022/7/15
 */
public class Intersect558 {

    public Node intersect(Node quadTree1, Node quadTree2) {
        // 递归
        if (quadTree1 == null && quadTree2 == null) {
            return null;
        } else if (quadTree1 == null) {
            return quadTree2;
        } else if (quadTree2 == null) {
            return quadTree1;
        }
        Node res;
        if ((quadTree1.isLeaf && quadTree1.val) || (quadTree2.isLeaf && quadTree2.val)) {
            res = new Node(true, true, null, null, null, null);
            return res;
        } else if (quadTree1.isLeaf && quadTree2.isLeaf) {
            res = new Node(false, true, null, null, null, null);
            return res;
        }

        res = new Node();
        res.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        res.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        res.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        res.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        // 合并
        if (res.topLeft.isLeaf && res.topRight.isLeaf && res.bottomLeft.isLeaf && res.bottomRight.isLeaf) {
            if (res.topLeft.val && res.topRight.val && res.bottomLeft.val && res.bottomRight.val) {
                res = new Node(true, true, null, null, null, null);
                return res;
            } else if (!res.topLeft.val && !res.topRight.val && !res.bottomLeft.val && !res.bottomRight.val) {
                res = new Node(false, true, null, null, null, null);
                return res;
            }
        }
        return res;
    }

    class Node {

        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    ;
}
