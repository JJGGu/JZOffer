/**
 * @program: JZOffer
 * @description: 输入一个链表，输出该链表中倒数第k个结点。
 * @author: JJGGu
 * @create: 2020-09-23 20:44
 **/
public class JZ013 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        if (k != 0) {
            return null;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
