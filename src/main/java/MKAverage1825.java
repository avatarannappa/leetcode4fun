import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 1825. 求出 MK 平均值
 * hard
 *
 * @author avatarannappa
 * @date 2023/1/18
 */
public class MKAverage1825 {

    private int m, k;
    private Queue<Integer> q = new ArrayDeque<>();
    private TreeMap<Integer, Integer> low = new TreeMap<>(Comparator.reverseOrder());
    private TreeMap<Integer, Integer> mid = new TreeMap<>(Comparator.reverseOrder());
    private TreeMap<Integer, Integer> high = new TreeMap<>(Comparator.reverseOrder());
    private int lowSize = 0;
    private int midSize = 0;
    private int highSize = 0;
    private long sum = 0;

    public MKAverage1825(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        // 用map的删除的时候是O(1),不然用PriorityQueue也可以
        q.offer(num);
        if (q.size() > m) {
            // 超过了，先删除
            int del = q.poll();
            if (high.containsKey(del)) {
                highSize--;
                int count = high.get(del);
                if (count == 1) {
                    high.remove(del);
                } else {
                    high.put(del, count - 1);
                }
            } else {
                int temp;
                if (highSize > 0) {
                    highSize--;
                    temp = high.lastKey();
                    int count = high.get(temp);
                    if (count == 1) {
                        high.remove(temp);
                    } else {
                        high.put(temp, count - 1);
                    }

                    mid.put(temp, mid.getOrDefault(temp, 0) + 1);
                    midSize++;
                    sum += temp;
                }

                if (mid.containsKey(del)) {
                    sum -= del;
                    midSize--;
                    int count = mid.get(del);
                    if (count == 1) {
                        mid.remove(del);
                    } else {
                        mid.put(del, count - 1);
                    }
                } else {
                    if (midSize > 0) {
                        midSize--;
                        temp = mid.lastKey();
                        int count = mid.get(temp);
                        if (count == 1) {
                            mid.remove(temp);
                        } else {
                            mid.put(temp, count - 1);
                        }

                        low.put(temp, low.getOrDefault(temp, 0) + 1);
                        lowSize++;
                        sum -= temp;
                    }

                    lowSize--;
                    int count = low.get(del);
                    if (count == 1) {
                        low.remove(del);
                    } else {
                        low.put(del, count - 1);
                    }
                }
            }
        }

        // 直接添加
        if (lowSize == 0 || lowSize < k) {
            low.put(num, low.getOrDefault(num, 0) + 1);
            lowSize++;
            return;
        }

        // 添加，移动
        if (num < low.firstKey()) {
            low.put(num, low.getOrDefault(num, 0) + 1);
            lowSize++;
            if (lowSize <= k) {
                return;
            }
            lowSize--;
            num = low.firstKey();
            int count = low.get(num);
            if (count == 1) {
                low.remove(num);
            } else {
                low.put(num, count - 1);
            }
        }


        if (midSize == 0 || midSize < (m - 2 * k)) {
            mid.put(num, mid.getOrDefault(num, 0) + 1);
            midSize++;
            sum += num;
            return;
        }

        if (num < mid.firstKey()) {
            mid.put(num, mid.getOrDefault(num, 0) + 1);
            midSize++;
            sum += num;
            if (midSize <= (m - 2 * k)) {
                return;
            }
            midSize--;
            num = mid.firstKey();
            sum -= num;
            int count = mid.get(num);
            if (count == 1) {
                mid.remove(num);
            } else {
                mid.put(num, count - 1);
            }
        }
        
        if (highSize == 0 || highSize < k) {
            high.put(num, high.getOrDefault(num, 0) + 1);
            highSize++;
            return;
        }
        
        if (num < high.firstKey()) {
            high.put(num, high.getOrDefault(num, 0) + 1);
            highSize++;
            if (highSize <= k) {
                return;
            }
            highSize--;
            num = high.firstKey();
            int count = high.get(num);
            if (count == 1) {
                high.remove(num);
            } else {
                high.put(num, count - 1);
            }
        }

        
    }

    public int calculateMKAverage() {
        if (q.size() < m) {
            return -1;
        }
        return (int) (sum / (m - 2 * k));
    }

    public static void main(String[] args) {
        MKAverage1825 ob = new MKAverage1825(3, 1);
        ob.addElement(17612);
        ob.addElement(74607);
        ob.addElement(8272);
        ob.addElement(33433);
        ob.addElement(15456);
        ob.addElement(64938);
    }
}
