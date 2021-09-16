package dataStructure.array.sort;

import java.util.Random;

/**
 * @author yangxu
 * @version 1.0
 * @date 2021/6/30 下午2:48
 */
public class QuicklySort {
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        int[] ints = new QuicklySort().quickSort(nums, 0, nums.length - 1);
        for (int anInt : ints) {
            System.out.print(anInt);
        }

    }

    /**
     * 快排
     * @author yangxu
     * @date 2021/6/30 下午3:00
 * @param nums  带排序
 * @param l  左下标
 * @param r   右下标
 * @return  int[]
     */
    public int[] quickSort(int[] nums,int l ,int r){
        //base case
        if (l >=  r){
            return nums;
        }
        //随机选取中轴，然后与左端点互换
            //new Random().nextInt(65)+ 64 生产范围是[64,128]
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums,l,i);
        int pivot = nums[l];

        int start = l;
        int end = r;


        //左右指针分别移动
        while (l<r){
            //先移动右指针，直到找到比中轴值小的数
            while ( l < r && nums[r] >= pivot){
                r --;
            }
            //再移动左指针，直到找到比中轴值大的数
            while ( l < r && nums[l] < pivot){
                l ++;
            }
            if (l < r){
                swap(nums,l,r);
                l ++;
                r --;
            }
        }
        //循环结束后再判断中间值是否大于pivot，大于的话需要把右指针左移一位再置换
        if ( l ==r && pivot < nums[r]){
            r --;
        }
        //置换中轴值
        swap(nums,start,r);
        //递归排序左右俩边
        quickSort(nums,start,r-1);
        quickSort(nums,r+1,end);
       return nums;
    }

    /**
     * 置换数组的俩个值
     * @author yangxu
     * @date 2021/6/30 下午3:33
 * @param nums
 * @param l
 * @param i
     */
    private void swap(int[] nums, int l, int i) {
        int tmp = nums[l];
        nums[l] = nums[i];
        nums[i] = tmp;
    }
}
