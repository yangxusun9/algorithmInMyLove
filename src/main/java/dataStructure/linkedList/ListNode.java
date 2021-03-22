package dataStructure.linkedList;

import java.util.List;

/**
 * @author yangxu
 * @version 1.0
 * @date 2021/3/22 下午3:09
 */
public class ListNode {
  public   Integer value ;
   public ListNode next;
    ListNode(int x ){
        value = x;
    }
    StringBuilder stringBuilder = new StringBuilder();

    public static  void   travel(ListNode p){
        if (p ==null){
//            System.out.print(p.value);
            return;
        }
        System.out.println(p.value);
        travel(p.next);
    }
    public void add(int newval) {
        ListNode newNode = new ListNode(newval);
        if(this.next == null)
            this.next = newNode;
        else
            this.next.add(newval);
    }




}
