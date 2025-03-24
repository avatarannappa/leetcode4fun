import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215. 数组中的第K个最大元素.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/20
 */
public class FindKthLargest215 {

    public int findKthLargestHeap(int[] nums, int k) {
        // 堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public int findKthLargestMyHeap(int[] nums, int k) {
        // 自己实现堆
        int n = nums.length;
        int heapSize = n;
        // 构造大顶堆
        buildMaxHeap(nums, heapSize);
        for (int i = n - 1; i >= n - k + 1; i--) {
            // 移除顶部 k - 1 个，则顶部的是第 k 大的数
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            // 从底部构造
            maxHeapify(nums, i, heapSize);
        }
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        // 堆化
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, largest, i);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public int findKthLargest(int[] nums, int k) {
        // 排序
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargestQuickSelect(int[] nums, int k) {
        // 自己实现快排
        List<Integer> l = new ArrayList<>(nums.length);
        for (int num : nums) {
            l.add(num);
        }
        return quickSelect(l, k);
    }

    private int quickSelect(List<Integer> nums, int k) {
        Random random = new Random();
        int pivot = nums.get(random.nextInt(nums.size()));
        // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int num : nums) {
            if (num == pivot) {
                equal.add(num);
            } else if (num > pivot) {
                big.add(num);
            } else {
                small.add(num);
            }
        }
        if (k <= big.size()) {
            return quickSelect(big, k);
        } else if (k <= big.size() + equal.size()) {
            return pivot;
        } else {
            return quickSelect(small, k - big.size() - equal.size());
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        int k = 2;
        System.out.println(new FindKthLargest215().findKthLargestQuickSelect(nums, k));
    }
}
