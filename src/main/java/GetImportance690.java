import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 690. 员工的重要性 easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/8/27
 */
public class GetImportance690 {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee.id == id) {
                queue.add(employee.id);
            }
            map.put(employee.id, employee);
        }

        int res = 0;
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                Employee now = map.get(queue.poll());
                res += now.importance;
                if (now.subordinates != null && !now.subordinates.isEmpty()) {
                    temp.addAll(now.subordinates);
                }
            }
            queue.addAll(temp);
        }

        return res;
    }

    static class Employee {

        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
