package dataStructure.array.sort;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author yangxu
 * @version 1.0
 * @date 2021/6/30 下午2:48
 */
public class QuicklySort {
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
         new QuicklySort().nonRecQuickSort(nums, 0, nums.length - 1);
        for (int anInt : nums) {
            System.out.print(anInt);
        }

    }

    /**
     * 递归快排
     * @author yangxu
     * @date 2021/6/30 下午3:00
 * @param nums  带排序
 * @param l  左下标
 * @param r   右下标
 * @return  int[]
     */
    public void quickSort(int[] nums,int l ,int r){
        //base case
        if (l >=  r){
            return ;
        }
        int p = partition(nums, l, r);
        quickSort(nums,l,p-1);
        quickSort(nums,p+1,r);

    }

    private int partition(int[] nums, int l, int r) {
        // 选取中轴值
        int pivot = (new Random().nextInt(r - l + 1)) + l;
        swap(nums,pivot,r);
        //起始点
        int p = l;
        for (int i = l; i <= r; i++) {
            //如果小于中轴值，就置换
            if (nums[i]<=nums[r]){
                swap(nums,i,p);
                p++;
            }
        }
        return p-1;
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

    //非递归实现快速排序
    public  void nonRecQuickSort(int[] a,int start,int end) {
        LinkedList<Integer> stack = new LinkedList<Integer>();  //用栈模拟
        if(start < end) {
            stack.push(end);
            stack.push(start);
            while(!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(a, l, r);
                if(l < index - 1) {
                    stack.push(index-1);
                    stack.push(l);
                }
                if(r > index + 1) {
                    stack.push(r);
                    stack.push(index+1);
                }
            }
        }
    }

}
