public class SearchInsert35 {
    public static void main(String[] args) {
        SearchInsert35 searchInsert35 = new SearchInsert35();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int result = searchInsert35.searchInsert(nums, target);
        System.out.println(result);
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
