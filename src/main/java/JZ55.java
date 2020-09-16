/**
 * @program: JZOffer
 * @description: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @author: JJGGu
 * @create: 2020-09-16 15:06
 **/
public class JZ55 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = pHead;
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }
}
