package dataStructure.linkedList.recursion;

import dataStructure.linkedList.ListNode;
import dataStructure.linkedList.iteration.IterationUtils;

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


    // * https://leetcode-cn.com/problems/reverse-linked-list-ii/
    // *给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
    // * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
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
        if(m == 1){
            return   reverseN(head,n);
        }
        head.next = reverseSection(head.next,m-1,n-1);
        return head;
    }

    /**
     * 判断回文链表-后序遍历法
     * （时间复杂度O(n),空间复杂度O(n)）
     * @author yangxu
     * @date 2021/3/23 上午11:57
     * @param head
     * @return  dataStructure.linkedList.ListNode
     */
    public static Boolean isPalindrome(ListNode head){
        left =head;
        return traverseJudgment(head);
    }
    private static ListNode left;

    /**
     * 递归判断链表头节点与尾节点是否相等
     * @author yangxu
     * @date 2021/3/23 下午2:38 
 * @param head   
 * @return  java.lang.Boolean
     */
    public static Boolean traverseJudgment(ListNode head){
        if (head == null) return true;
        Boolean result = traverseJudgment(head.next);
        boolean flag = result && (head.value == left.value);
        left =left.next;
        return flag;
    }
    
    /**
     * 判断回文链表-中节点反转法
     * 时间复杂度O(n),空间复杂度O(1)
     * @author yangxu
     * @date 2021/3/23 下午2:41 
 * @param head 头节点
 * @return  null
     */
    public static Boolean isPalindromeBest(ListNode head){
        ListNode middle = IterationUtils.findMiddle(head);
        ListNode listNode2 = IterationUtils.reverseAll(middle);
        Boolean flag= true;
        while (listNode2 != null){
            if (head.value != listNode2.value){
                flag = false;
                return flag;
            }
            head = head.next;
            listNode2 = listNode2.next;
        }
        return flag;
    }

}
