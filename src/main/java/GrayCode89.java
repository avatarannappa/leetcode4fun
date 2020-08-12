import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 89. 格雷编码.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/12
 */
public class GrayCode89 {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        int i = 0;
        queue.offer("");
        while (i < n) {
            List<String> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }

            for (int j = 0; j < list.size(); j++) {
                if (j % 2 == 0) {
                    queue.offer(list.get(j) + "0");
                    queue.offer(list.get(j) + "1");
                } else {
                    queue.offer(list.get(j) + "1");
                    queue.offer(list.get(j) + "0");
                }
            }

            i++;
        }

        for (String s : queue) {
            result.add(binToOct(s));
        }

        return result;
    }

    static int binToOct(String bin) {
        int total = 0;
        char[] binCharArray = bin.toCharArray();
        for (int i = 0; i < binCharArray.length; i++) {
            total = total + binCharArray[i] - 48;
            if (i != binCharArray.length - 1) {
                total = total << 1;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(new GrayCode89().grayCode(n));
    }

}
