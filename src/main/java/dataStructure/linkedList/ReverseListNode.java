package dataStructure.linkedList;

import dataStructure.linkedList.iteration.IterationUtils;
import dataStructure.linkedList.recursion.RecursionUtils;

import java.util.LinkedList;

import static dataStructure.linkedList.ListNode.*;

/**
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
        ListNode result = IterationUtils.reverseKGroup(head,3);
        travel(result);

    }

}
