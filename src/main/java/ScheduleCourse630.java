import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 630. 课程表III.
 * hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/12/30
 */
public class ScheduleCourse630 {

    public int scheduleCourse(int[][] courses) {
        // 贪心，1.deadline排序选deadline小的，2.不满足cost+duration>deadline选之前duration小的
        Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        int cost = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] course : courses) {
            int duration = course[0];
            int deadline = course[1];
            cost += duration;
            queue.add(duration);
            if (cost > deadline) {
                int max = queue.poll();
                cost -= max;
            }
        }
        
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(new ScheduleCourse630().scheduleCourse(courses));
    }
}
