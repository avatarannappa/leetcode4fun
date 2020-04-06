import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 385. 迷你语法分析器.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/6
 */
public class Deserialize385 {

    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) {
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger result = new NestedInteger();
        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));
            switch (temp) {
                case "[":
                    NestedInteger node = new NestedInteger();
                    if (!stack.isEmpty()) {
                        stack.peek().add(node);
                    }
                    stack.push(node);
                    break;
                case "]":
                    result = stack.pop();
                    break;
                case ",":
                    break;
                default:
                    String inStr = "";
                    int j = i;
                    for (; j < s.length(); j++) {
                        char c = s.charAt(j);
                        if (c == ',' || c == ']') {
                            break;
                        }
                        inStr += c;
                    }
                    if (']' == s.charAt(j)) {
                        i = j - 1;
                    } else {
                        i = j;
                    }

                    int in = Integer.parseInt(inStr);
                    NestedInteger n = new NestedInteger(in);
                    if (stack.isEmpty()) {
                        stack.push(n);
                    } else {
                        stack.peek().add(n);
                    }
            }
        }
        return result;
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {

        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {

        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return null;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {

        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {

        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }
}
