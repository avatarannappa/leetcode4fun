/**
 * 2296. 设计一个文本编辑器.
 * hard
 *
 * @author avatarannappa
 * @version 2025/2/27
 */
public class TextEditor2296 {

    StringBuilder left = new StringBuilder();
    StringBuilder right = new StringBuilder();

    public TextEditor2296() {
        // 对顶堆，模拟
    }

    public void addText(String text) {
        left.append(text);
    }

    public int deleteText(int k) {
        if (left.length() == 0) {
            return 0;
        }
        int delete = Math.min(k, left.length());
        left.delete(left.length() - delete, left.length());
        return delete;
    }

    public String cursorLeft(int k) {
        if (left.length() == 0) {
            return "";
        }
        int leftMove = Math.min(k, left.length());
        right.insert(0, left.substring(left.length() - leftMove, left.length()));
        left.delete(left.length() - leftMove, left.length());
        return returnString();
    }

    public String cursorRight(int k) {
        if (right.length() == 0) {
            return returnString();
        }
        int rightMove = Math.min(k, right.length());
        left.append(right.substring(0, rightMove));
        right.delete(0, rightMove);

        return returnString();
    }

    private String returnString() {
        return left.substring(Math.max(0, left.length() - 10), left.length());
    }

    public static void main(String[] args) {
        TextEditor2296 textEditor = new TextEditor2296();
        textEditor.addText("leetcode");
        System.out.println(textEditor.deleteText(4));
        textEditor.addText("practice");
        System.out.println(textEditor.cursorRight(3));
        System.out.println(textEditor.cursorLeft(8));
        System.out.println(textEditor.deleteText(10));
        System.out.println(textEditor.cursorLeft(2));
        System.out.println(textEditor.cursorRight(6));
    }
}
