package dataStructure.linkedList.iteration;

import dataStructure.linkedList.ListNode;

import java.util.List;

/**
 * 迭代解法
 * @author yangxu
 * @version 1.0
 * @date 2021/3/22 下午5:07
 */
public class IterationUtils {
    /**
     * 反转整个链表
     * @author yangxu
     * @date 2021/3/22 下午5:27 
 * @param head   
 * @return  dataStructure.linkedList.ListNode
     */
    public static ListNode reverseAll(ListNode head){
        ListNode pre = null;
        ListNode current = head;
        ListNode last = current;
        while (current != null){
            last = current.next;
            current.next =pre;
            //移动指针
            pre = current;
           current = last;
        }
        return pre;
    }


    
}
