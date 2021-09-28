package dataStructure.array.reverse;

/**
 * 反转
 *
 * @author yangxu
 * @version 1.0
 * @date 2021/9/20 上午11:29
 */
public class ArrayReverse {
    public void reverse(int [] nums){
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            swap(nums,left,right);
            left ++;
            right--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
