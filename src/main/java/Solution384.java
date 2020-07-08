import java.util.Random;

/**
 * 384. 打乱数组.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/8
 */
public class Solution384 {

    int[] array;
    int[] origin;
    Random rand = new Random();

    public Solution384(int[] nums) {
        this.array = nums;
        this.origin = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        array = origin;
        origin = origin.clone();
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
