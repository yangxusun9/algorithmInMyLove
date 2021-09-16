package tx;

import dataStructure.array.sort.QuicklySort;

import java.util.Random;

/**
 * @author yangxu
 * @version 1.0
 * @date 2021/9/10 下午3:55
 */
public class QuiclySort {
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        int[] ints = new QuiclySort().sort(nums, 0, nums.length - 1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    public int[] sort(int[] nums,int l ,int r){
        //base case
        if (l > r ) return nums;
        //选取中轴值
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums,l,i);
        int pivot = nums[l];
        int start = l;
        int end  = r;

        //开始移动指针
        while (l < r){
            while (l < r && nums[r] > pivot){
                r --;
            }
            while (l < r && nums[l] <= pivot){
                l ++;
            }
            if (l < r){
                swap(nums,l,r);
                l ++;
                r--;
            }
        }
        if ( l == r && nums[r] >pivot){
            l -- ;
        }
        swap(nums,l,start);

        sort(nums,start,l-1);
        sort(nums,l+1,end);

return nums;

    }

    /**
     * 交换
     * @author yangxu
     * @date 2021/9/10 下午3:57
 * @param a
 * @param b
     */
    void swap(int[] nums,Integer a, Integer b ){
        int temp = nums[a];
        nums[a]= nums[b];
        nums[b] = temp;
    }
}
