/**
 * 33. 搜索旋转排序数组.
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/8
 */
public class Search33 {
    public static void main(String[] args) {
        Search33 search33 = new Search33();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int result = search33.search(nums, target);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = left + (right-left)/2;

        while(left <= right){
            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){  //左边升序
                if(target >= nums[left] && target <= nums[mid]){//在左边范围内
                    right = mid-1;
                }else{//只能从右边找
                    left = mid+1;
                }

            }else{ //右边升序
                if(target >= nums[mid] && target <= nums[right]){//在右边范围内
                    left = mid +1;
                }else{//只能从左边找
                    right = mid-1;
                }

            }
            mid = left + (right-left)/2;
        }

        return -1;  //没找到
    }
}
