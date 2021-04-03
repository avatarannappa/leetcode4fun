import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 781. 森林中的兔子
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/4
 */
public class NumRabbits781 {

    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }
        int result = 0;

        Arrays.sort(answers);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 0) {
                result += 1;
                continue;
            }
            int num = answers[i];
            if (map.containsKey(num)) {
                int count = map.get(num);
                if (num == count + 1) {
                    map.remove(num);
                    result += num + 1;
                } else {
                    map.put(num, count + 1);
                }
            } else {
                map.put(num, 0);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result += entry.getKey() + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] answers = {1, 0, 1, 0, 0};
        System.out.println(new NumRabbits781().numRabbits(answers));
    }
}
