import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 1233. 删除子文件夹
 * medium
 *
 * @author avatarannappa
 * @date 2023/2/8
 */
public class RemoveSubfolders1233 {

    public List<String> removeSubfolders(String[] folder) {
        // 字典树Trie
        Trie root = new Trie();
        for (int i = 0; i < folder.length; i++) {
            String[] arr = folder[i].split("/");
            Trie cur = root;
            for (int j = 0; j < arr.length; j++) {
                String s = arr[j];
                Trie t = cur.child.getOrDefault(s, new Trie());
                cur.child.put(s, t);
                if (j == arr.length - 1) {
                    t.ref = i;
                }
                cur = t;
            }
        }
        List<String> ans = new LinkedList<>();
        bfs(root, folder, ans);
        return ans;
    }

    private void bfs(Trie root, String[] folder, List<String> ans) {
        if (root.ref != -1) {
            ans.add(folder[root.ref]);
            return;
        }
        for (String f : root.child.keySet()) {
            bfs(root.child.get(f), folder, ans);
        }
    }

    public static class Trie {

        int ref;
        Map<String, Trie> child;

        public Trie() {
            ref = -1;
            child = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        String[] folder = {"/a/b", "/a", "/c/d/e", "/c/d", "/c/f"};
        // ["/a","/c/d","/c/f"]
        System.out.println(new RemoveSubfolders1233().removeSubfolders(folder));
    }
}
