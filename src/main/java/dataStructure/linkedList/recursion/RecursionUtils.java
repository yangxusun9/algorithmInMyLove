package dataStructure.linkedList.recursion;

import dataStructure.linkedList.ListNode;

/**
 * 递归解法
 * @author yangxu
 * @version 1.0
 * @date 2021/3/22 下午5:03
 */
public class RecursionUtils {

    public static   ListNode surviveNode = null;
    /**
     *反转以 head 为起点的 n 个节点，返回新的头结点
     * @author yangxu
     * @date 2021/3/22 下午3:20
     * @param listNode
     * @param n
     * @return  dataStructure.linkedList.ListNode
     */
    public static ListNode reverseN(ListNode listNode, int n ){
        //base case
        if ( n == 1){
            surviveNode = listNode.next;
            return listNode;
        }
        ListNode newHead = reverseN(listNode.next, n - 1);
        listNode.next.next = listNode;
        listNode.next = surviveNode;
        return newHead;
    }
    /**
     * 反转整个链表
     * @author yangxu
     * @date 2021/3/22 下午3:29
     * @param head
     * @return  dataStructure.linkedList.ListNode
     */
    public static ListNode reverseHole(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode listNode = reverseHole(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    /**
     * 反转部分链表
     * @author yangxu
     * @date 2021/3/22 下午4:34
     * @param head
     * @param m  起始下标
     * @param n   结束下标
     * @return  dataStructure.linkedList.ListNode
     */
    public static ListNode reverseSection(ListNode head,int m,int n){
        if(m  ==1){
            return   reverseN(head,n);
        }
        head.next = reverseSection(head.next,m-1,n-1);
        return head;
    }


}
