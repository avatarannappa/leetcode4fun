import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1462. 课程表IV
 * medium
 *
 * @author avatarannappa
 * @date 2023/9/12
 */
public class CheckIfPrerequisite1462 {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // 广度优先搜索，拓扑排序
        List<Boolean> ans = new LinkedList<>();

        boolean[][] origin = new boolean[numCourses][numCourses];
        boolean[][] mask = new boolean[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            origin[pre[0]][pre[1]] = true;
            mask[pre[0]][pre[1]] = true;
            inDegree[pre[1]]++;
        }

        Deque<Integer> rootList = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                rootList.add(i);
            }
        }

        // 拓扑排序
        while (!rootList.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            while (!rootList.isEmpty()) {
                int root = rootList.pollFirst();
                for (int i = 0; i < numCourses; i++) {
                    if (!origin[root][i]) {
                        continue;
                    }
                    for (int j = 0; j < numCourses; j++) {
                        if (mask[j][root]) {
                            mask[j][i] = true;
                        }
                    }
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        temp.add(i);
                    }
                }
            }
            rootList.addAll(temp);
        }

        for (int[] query : queries) {
            ans.add(mask[query[0]][query[1]]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] queries = {{0, 4}, {4, 0}, {1, 3}, {3, 0}};
        // [true,false,true,false]
        System.out.println(new CheckIfPrerequisite1462().checkIfPrerequisite(numCourses, prerequisites, queries));
    }
}
