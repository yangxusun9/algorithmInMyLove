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
       new QuiclySort().qSort(nums, 0, nums.length - 1);
        for (int anInt : nums) {
            System.out.print(anInt);
        }
    }
   private void qSort(int [] nums,int l ,int r){
        if (l > r) return;
       int p =  partition(nums,l,r);
       qSort(nums,l,p -1 );
       qSort(nums,p+1,r);
   }

    private int partition(int[] nums, int l, int r) {
        //抽取中轴值
        int pi = new Random().nextInt(r - l + 1) + l;
        int pivot = nums[pi];
        //置换
        swap(nums,pi,r);
        int p = l;
        //比较并置换
        for (int i = l; i <= r; i++) {
            if (nums[i] <= pivot){
                swap(nums,p,i);
                p++;
            }
        }
        return p-1;
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
