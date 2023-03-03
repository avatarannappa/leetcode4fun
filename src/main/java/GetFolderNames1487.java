import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1487. 保证文件名唯一
 * medium
 *
 * @author avatarannappa
 * @date 2023/3/3
 */
public class GetFolderNames1487 {

    public String[] getFolderNames(String[] names) {
        String[] ans = new String[names.length];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (map.containsKey(name)) {
                int k = map.get(name) + 1;
                while (map.containsKey(add(name, k))) {
                    k++;
                }
                map.put(name, k);
                ans[i] = add(name, k);
                map.put(add(name, k), 0);
            } else {
                map.put(name, 0);
                ans[i] = name;
            }
        }

        return ans;
    }

    private String add(String names, int k) {
        return names + "(" + k + ")";
    }

    public static void main(String[] args) {
        // names = ["kaido","kaido(1)","kaido","kaido(1)"]
        // 输出：["kaido","kaido(1)","kaido(2)","kaido(1)(1)"]
        String[] names = {"kaido", "kaido(1)", "kaido", "kaido(1)"};
        System.out.println(Arrays.toString(new GetFolderNames1487().getFolderNames(names)));
    }
}
