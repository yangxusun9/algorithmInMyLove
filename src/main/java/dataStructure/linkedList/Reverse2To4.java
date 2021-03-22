package dataStructure.linkedList;

import java.util.LinkedList;

import static dataStructure.linkedList.ListNode.*;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * @author yangxu
 * @version 1.0
 * @date 2021/3/22 下午3:04
 */
public class Reverse2To4 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
       /* ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node5.next =null;*/
        travel(head);
        System.out.println("*************");

//        ListNode result = reverseHole(head);
//        ListNode result = reverseN(head, 3);
        ListNode result = reverseSection(head, 2,4);
        travel(result);

    }

}
