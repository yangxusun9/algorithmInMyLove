package dataStructure.linkedList.reverse;

import dataStructure.linkedList.ListNode;

/**
 * @author yangxu
 * @version 1.0
 * @date 2021/10/28 下午3:49
 */
public class ReverseL2R {
    public static ListNode surviveNode = null;

    /**
     * 反转部分链表;
     *  https://leetcode-cn.com/problems/reverse-linked-list-ii/
     *  给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
     *  请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     * @author yangxu
     * @date 2021/3/22 下午4:34
     * @param head
     * @param m  起始下标
     * @param n   结束下标
     * @return  dataStructure.linkedList.ListNode
     */
    public static ListNode reverseSection(ListNode head, int m, int n){
        if(m == 1){
            return   reverseN(head,n);
        }
        head.next = reverseSection(head.next,m-1,n-1);
        return head;
    }
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
}
