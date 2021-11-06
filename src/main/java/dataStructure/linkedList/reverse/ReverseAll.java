package dataStructure.linkedList.reverse;

import dataStructure.linkedList.ListNode;

/**
 * 反转整个链表
 * @author yangxu
 * @version 1.0
 * @date 2021/10/28 下午3:40
 */
public class ReverseAll {

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
}
