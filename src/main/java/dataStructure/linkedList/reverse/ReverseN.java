package dataStructure.linkedList.reverse;

import dataStructure.linkedList.ListNode;

/**
 * @author yangxu
 * @version 1.0
 * @date 2021/10/28 下午3:47
 */
public class ReverseN {

    public static ListNode surviveNode = null;
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
}
