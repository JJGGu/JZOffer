
/**
 * @program: JZOffer
 * @description: 输入一个链表，反转链表后，输出新链表的表头。
 * @author: JJGGu
 * @create: 2020-09-09 15:11
 **/
public class JZ15 {
    public static MyLinkedList.ListNode ReverseList(MyLinkedList.ListNode head) {
        if (head == null) {
            return null;
        }
        MyLinkedList.ListNode cur = head.next;
        MyLinkedList.ListNode first = head;
        while (cur != null) {
            head.next = cur.next;
            cur.next = first;
            first = cur;
            cur = head.next;

        }
        return first;
    }
}
