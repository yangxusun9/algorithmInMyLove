package didi.method;

import didi.dao.ListNode;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yangxu
 * @version 1.0
 * @date 2021/4/12 下午9:19
 */
public class DIDI {
   static ListNode slow,fast;
    public static Boolean isCircle(ListNode root){
        //init
        slow = fast = root;
        while (fast !=null && fast.next !=null ){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

}
