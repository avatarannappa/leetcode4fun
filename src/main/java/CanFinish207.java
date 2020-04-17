import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表.
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/17
 */
public class CanFinish207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] t : prerequisites) {
            indegrees[t[0]]++;
            adjacency.get(t[1]).add(t[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (Integer cur : adjacency.get(pre)) {
                if (--indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(new CanFinish207().canFinish(numCourses, prerequisites));
    }
}
