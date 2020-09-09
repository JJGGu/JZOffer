import java.util.List;

/**
 * @program: JZOffer
 * @description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author: JJGGu
 * @create: 2020-09-09 15:23
 **/
public class JZ16 {
    public static void main(String[] args) {

    }
    public static MyLinkedList.ListNode Merge(MyLinkedList.ListNode list1, MyLinkedList.ListNode list2) {
        MyLinkedList.ListNode head = new MyLinkedList.ListNode();
        MyLinkedList.ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        }
        if (list2 == null) {
            cur.next = list1;
        }
        return head;
    }
}
