package dataStructure.array.search;

/**
 * 二分法
 *
 * @author yangxu
 * @version 1.0
 * @date 2021/9/20 上午10:27
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums ={1,2,2,2,4,5};
        int target  = 5;
        int result = new BinarySearch().leftSearch(nums, target);
        System.out.println(result);

    }

    /**
     * 二分法找到是否包含
     * @param nums
     * @param target
     * @return
     */
    public boolean search (int [] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left)/2;//防止值超过int 范围
            if (nums[mid] == target){
                return true;
            }else if (nums[mid] < target){
                left = mid +1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 二分法查找左边界的下标，如果不存在，返回-1
     * @param nums
     * @param target
     * @return
     */
    public int leftSearch(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left)/2;//防止值超过int 范围
            if (nums[mid] == target){
                //继续查找左边界
                 right = mid-1;
            }else if (nums[mid] < target){
                left = mid +1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        //判断循环跳出后是否找到值
       return left == nums.length  || nums[left]!= target?-1:left;

    }
}
