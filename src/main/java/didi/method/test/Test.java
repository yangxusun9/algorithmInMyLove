package didi.method.test;


import didi.dao.ListNode;
import didi.method.DIDI;

/**
 * @author yangxu
 * @version 1.0
 * @date 2021/4/12 下午9:25
 */
public class Test {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

        Boolean flag = DIDI.isCircle(node1);
        System.out.println(flag);
    }
}
