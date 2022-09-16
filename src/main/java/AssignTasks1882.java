import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1882. 使用服务器处理任务
 * medium
 *
 * @author avatarannappa
 * @date 2022/9/16
 */
public class AssignTasks1882 {

    public static class Tuple {

        int key;
        int[] val;

        public Tuple(int key, int[] val) {
            this.key = key;
            this.val = val;
        }

    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] ans = new int[tasks.length];

        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (o1, o2) -> o1[1] - o2[1] == 0 ? o1[0] - o2[0] : o1[1] - o2[1]);
        for (int i = 0; i < servers.length; i++) {
            int[] arr = new int[2];
            arr[0] = i;
            arr[1] = servers[i];
            queue.add(arr);
        }
        int time = 0;
        // 用map,当任务多且长的时候会超时，再用一个优先队列
        // Map<Integer, List<int[]>> map = new HashMap<>();
        PriorityQueue<Tuple> taskQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.key));
        for (int i = 0; i < tasks.length; i++, time++) {
            // 完成任务的机器，放回机器堆
            while (taskQueue.peek() != null && taskQueue.peek().key == time) {
                queue.add(taskQueue.poll().val);
            }

            while (queue.isEmpty()) {
                // 没有空闲机器，等待机器处理完成
                // timingWheel 类似时间轮
                time = taskQueue.peek().key;
                while (taskQueue.peek() != null && taskQueue.peek().key == time) {
                    queue.add(taskQueue.poll().val);
                }
            }

            for (; !queue.isEmpty() && i < tasks.length && i <= time; i++) {
                // 获取处理机器，构造结果
                int[] server = queue.poll();
                ans[i] = server[0];

                // 放入工作中map
                int end = time + tasks[i];
                Tuple tuple = new Tuple(end, server);
                taskQueue.add(tuple);
            }
            i--;

        }

        return ans;
    }

    public int[] assignTasksOld(int[] servers, int[] tasks) {
        // 用map,当任务多且长的时候会超时
        int[] ans = new int[tasks.length];

        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (o1, o2) -> o1[1] - o2[1] == 0 ? o1[0] - o2[0] : o1[1] - o2[1]);
        for (int i = 0; i < servers.length; i++) {
            int[] arr = new int[2];
            arr[0] = i;
            arr[1] = servers[i];
            queue.add(arr);
        }
        int time = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++, time++) {
            // 完成任务的机器，放回机器堆
            if (map.containsKey(time)) {
                queue.addAll(map.get(time));
            }

            while (queue.isEmpty()) {
                // 没有空闲机器，等待机器处理完成
                // timingWheel 类似时间轮
                time++;
                if (map.containsKey(time)) {
                    queue.addAll(map.get(time));
                }
            }

            for (; !queue.isEmpty() && i < tasks.length && i <= time; i++) {
                // 获取处理机器，构造结果
                int[] server = queue.poll();
                ans[i] = server[0];

                // 放入工作中map
                int end = time + tasks[i];
                List<int[]> list = map.getOrDefault(end, new ArrayList<>());
                list.add(server);
                map.put(end, list);
            }
            i--;

        }

        return ans;
    }

    public static void main(String[] args) {
        // 给你两个 下标从 0 开始 的整数数组 servers 和 tasks ，长度分别为 n 和 m 。
        // servers[i] 是第 i 台服务器的 权重 ，而 tasks[j] 是处理第 j 项任务 所需要的时间（单位：秒）。
        // 你正在运行一个仿真系统，在处理完所有任务后，该系统将会关闭。
        // 每台服务器只能同时处理一项任务。第 0 项任务在第 0 秒可以开始处理，相应地，第 j 项任务在第 j秒可以开始处理。
        // 处理第 j 项任务时，你需要为它分配一台 权重最小 的空闲服务器。
        // 如果存在多台相同权重的空闲服务器，请选择 下标最小 的服务器。
        // 如果一台空闲服务器在第 t 秒分配到第 j 项任务，那么在 t + tasks[j] 时它将恢复空闲状态。
        // 如果没有空闲服务器，则必须等待，直到出现一台空闲服务器，并 尽可能早地处理剩余任务。 
        // 如果有多项任务等待分配，则按照 下标递增 的顺序完成分配。
        // 如果同一时刻存在多台空闲服务器，可以同时将多项任务分别分配给它们。
        // 构建长度为m 的答案数组 ans ，其中 ans[j] 是第 j 项任务分配的服务器的下标。
        // 返回答案数组 ans 。

        //- 0 秒时，第 0 项任务加入到任务队列，使用第 1 台服务器处理到 2 秒。
        //- 1 秒时，第 1 项任务加入到任务队列，使用第 4 台服务器处理到 2 秒。
        //- 2 秒时，第 1 台和第 4 台服务器空闲，第 2 项任务加入到任务队列，使用第 1 台服务器处理到 4 秒。
        //- 3 秒时，第 3 项任务加入到任务队列，使用第 4 台服务器处理到 7 秒。
        //- 4 秒时，第 1 台服务器空闲，第 4 项任务加入到任务队列，使用第 1 台服务器处理到 9 秒。
        //- 5 秒时，第 5 项任务加入到任务队列，使用第 3 台服务器处理到 7 秒。
        //- 6 秒时，第 6 项任务加入到任务队列，使用第 2 台服务器处理到 7 秒。
        // 输入：servers = [5,1,4,3,2], tasks = [2,1,2,4,5,2,1]
        // 输出：[1,4,1,4,1,3,2]
        int[] servers = {338, 890, 301, 532, 284, 930, 426, 616, 919, 267, 571, 140, 716, 859, 980, 469, 628, 490, 195,
            664, 925, 652, 503, 301, 917, 563, 82, 947, 910, 451, 366, 190, 253, 516, 503, 721, 889, 964, 506, 914, 986,
            718, 520, 328, 341, 765, 922, 139, 911, 578, 86, 435, 824, 321, 942, 215, 147, 985, 619, 865};
        int[] tasks = {773, 537, 46, 317, 233, 34, 712, 625, 336, 221, 145, 227, 194, 693, 981, 861, 317, 308, 400, 2,
            391, 12, 626, 265, 710, 792, 620, 416, 267, 611, 875, 361, 494, 128, 133, 157, 638, 632, 2, 158, 428, 284,
            847, 431, 94, 782, 888, 44, 117, 489, 222, 932, 494, 948, 405, 44, 185, 587, 738, 164, 356, 783, 276, 547,
            605, 609, 930, 847, 39, 579, 768, 59, 976, 790, 612, 196, 865, 149, 975, 28, 653, 417, 539, 131, 220, 325,
            252, 160, 761, 226, 629, 317, 185, 42, 713, 142, 130, 695, 944, 40, 700, 122, 992, 33, 30, 136, 773, 124,
            203, 384, 910, 214, 536, 767, 859, 478, 96, 172, 398, 146, 713, 80, 235, 176, 876, 983, 363, 646, 166, 928,
            232, 699, 504, 612, 918, 406, 42, 931, 647, 795, 139, 933, 746, 51, 63, 359, 303, 752, 799, 836, 50, 854,
            161, 87, 346, 507, 468, 651, 32, 717, 279, 139, 851, 178, 934, 233, 876, 797, 701, 505, 878, 731, 468, 884,
            87, 921, 782, 788, 803, 994, 67, 905, 309, 2, 85, 200, 368, 672, 995, 128, 734, 157, 157, 814, 327, 31, 556,
            394, 47, 53, 755, 721, 159, 843};
        System.out.println(Arrays.toString(new AssignTasks1882().assignTasks(servers, tasks)));
    }
}
