package dataStructure.linkedList.iteration;

import dataStructure.linkedList.ListNode;
import sun.jvm.hotspot.memory.HeapBlock;

import java.util.List;

/**
 * 迭代解法
 * @author yangxu
 * @version 1.0
 * @date 2021/3/22 下午5:07
 */
public class IterationUtils {
    /**
     * 反转head->tail部分的链表,左开右闭
     * @author yangxu
     * @date 2021/3/22 下午5:27 
 * @param head  头节点
     * @param tail 尾节点
 * @return  dataStructure.linkedList.ListNode
     */
    public static ListNode reverseAll(ListNode head,ListNode tail){
        ListNode pre = null;
        ListNode current = head;
        ListNode last = current;
        while (current != tail){
            last = current.next;
            current.next =pre;
            //移动指针
            pre = current;
           current = last;
        }
        return pre;
    }
    //https://leetcode-cn.com/problems/reverse-nodes-in-k-group/

    public static ListNode reverseKGroup(ListNode head,Integer k){
       ListNode cur = head;
       ListNode tail = head;
        for (Integer i = 0; i < k; i++) {
            //base case ，返回头节点
            if (tail == null){
                return cur;
            }
            tail = tail.next;
        }
        ListNode newHead = reverseAll(cur, tail);
       cur.next = reverseKGroup(tail, k);
       return newHead;

    }


    
}
