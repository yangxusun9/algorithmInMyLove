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
     * 反转head->tail部分的链表,左开右闭
     * @author yangxu
     * @date 2021/3/22 下午5:27 
 * @param head  头节点
     * @param tail 尾节点
 * @return  dataStructure.linkedList.ListNode
     */
    public static ListNode reverseSection(ListNode head, ListNode tail){
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

    public static  ListNode reverseAll(ListNode head){
        ListNode pre,cur,net;
        pre =null;
        cur = head;
        while (cur != null){
            net = cur.next;
            cur.next = pre;
            pre = cur;
            cur = net;
        }
        return pre;
    }





    /**
     * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
     *k个一组链表反转
     * @author yangxu
     * @date 2021/3/23 下午2:56
 * @param head
 * @param k
 * @return  dataStructure.linkedList.ListNode
     */
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
        ListNode newHead = reverseSection(cur, tail);
       cur.next = reverseKGroup(tail, k);
       return newHead;

    }

    /**
     * 找寻链表中间节点（同化成一个路程问题，同一段路程，A的速度是B的两倍，他们同时出发，当A走完全程时，B也就刚好走过一半））
     *
     * @author yangxu
     * @date 2021/3/23 上午11:23
 * @param head
 * @return  dataStructure.linkedList.ListNode
     */
    public static ListNode findMiddle(ListNode head){
        //定义快慢指针
        ListNode fast ,slow;
        //初始化
        fast = slow = head;
        while (fast !=null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
        }
        //为解决回文链表问题，需要将指针下移到回文开始的地方
        if(fast != null){
            slow = slow.next;
        }
        return slow;
    }





    
}
