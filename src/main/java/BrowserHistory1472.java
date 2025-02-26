import java.util.Stack;

/**
 * 1472. 设计浏览器历史记录.
 * medium
 *
 * @author avatarannappa
 * @version 2025/2/26
 */
public class BrowserHistory1472 {

    Stack<String> stackBack = new Stack<>();
    Stack<String> stackForward = new Stack<>();

    public BrowserHistory1472(String homepage) {
        // 对顶栈
        // TODO 用队列模拟
        stackBack.push(homepage);
    }

    public void visit(String url) {
        stackBack.push(url);
        stackForward.clear();
    }

    public String back(int steps) {
        while (steps > 0 && stackBack.size() > 1) {
            stackForward.push(stackBack.pop());
            steps--;
        }
        return stackBack.peek();
    }

    public String forward(int steps) {
        while (steps > 0 && !stackForward.isEmpty()) {
            stackBack.push(stackForward.pop());
            steps--;
        }
        return stackBack.peek();
    }

}
