package dataStructure.linkedList;

import dataStructure.linkedList.iteration.IterationUtils;
import dataStructure.linkedList.recursion.RecursionUtils;

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
public class ReverseListNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        travel(head);
        System.out.println("*************");

//        ListNode result = reverseHole(head);
//        ListNode result = reverseN(head, 3);
//        ListNode result = RecursionUtils.reverseSection(head, 2,4);
        ListNode result = IterationUtils.reverseAll(head);
        travel(result);

    }

}
