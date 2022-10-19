
/**
 * 1700. 无法吃午餐的学生数量
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/19
 */
public class CountStudents1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        boolean[] visited = new boolean[n];
        int sandIndex = 0;
        int step = 0;
        for (int i = 0; ; i++) {
            i = i % n;
            if (!visited[i] && students[i] == sandwiches[sandIndex]) {
                visited[i] = true;
                step = 0;
                sandIndex++;
                if (sandIndex == n) {
                    return 0;
                }
            } else {
                step++;
                if (step == n) {
                    break;
                }
            }
        }
        return n - sandIndex;
    }

    public static void main(String[] args) {
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        // 输入：students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
        // 输出：3

        // students = [1,1,0,0], sandwiches = [0,1,0,1]
        // 0
        System.out.println(new CountStudents1700().countStudents(students, sandwiches));
    }
}
