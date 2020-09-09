import java.util.ArrayList;
import java.util.List;

/**
 * @program: JZOffer
 * @description: 输入一个链表，输出该链表中倒数第k个结点。
 * @author: JJGGu
 * @create: 2020-09-09 11:41
 **/
public class JZ14 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        MyLinkedList.ListNode listNode = myLinkedList.create(list);

        MyLinkedList.ListNode listNode1 = FindKthToTail(listNode, 2);
        System.out.println(listNode1.val);

    }
    // 快慢指针法
    public static MyLinkedList.ListNode FindKthToTail(MyLinkedList.ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        MyLinkedList.ListNode slow = head;
        MyLinkedList.ListNode fast = head;
        int i = k;
        while (i-- > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
