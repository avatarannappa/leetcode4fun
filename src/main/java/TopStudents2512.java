import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 2512. 奖励最顶尖的 K 名学生
 * medium
 *
 * @author avatarannappa
 * @date 2023/10/11
 */
public class TopStudents2512 {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> feedback = new HashMap<>();
        for (String s : positive_feedback) {
            feedback.put(s, 3);
        }
        for (String s : negative_feedback) {
            feedback.put(s, -1);
        }

        List<Integer[]> l = new LinkedList<>();
        for (int i = 0; i < student_id.length; i++) {
            int id = student_id[i];
            String re = report[i];
            String[] arr = re.split(" ");
            int score = 0;
            for (String s : arr) {
                if (feedback.containsKey(s)) {
                    score += feedback.get(s);
                }
            }
            Integer[] temp = new Integer[2];
            temp[0] = id;
            temp[1] = score;
            l.add(temp);
        }

        l.sort((o1, o2) -> o1[1] - o2[1] == 0 ? o1[0] - o2[0] : o2[1] - o1[1]);
        List<Integer> ans = new LinkedList<>();
        for (Integer[] t : l) {
            ans.add(t[0]);
            k--;
            if (k == 0) {
                break;
            }
        }
        return ans;
    }

}
