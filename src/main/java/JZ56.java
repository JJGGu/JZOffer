/**
 * @program: JZOffer
 * @description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author: JJGGu
 * @create: 2020-09-16 17:17
 **/
public class JZ56 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        // 借助头结点更方便一些
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = pHead;
        while (cur != null) {
           if (cur.next != null && cur.val == cur.next.val) {
               while (cur.next != null && cur.val == cur.next.val) {
                   cur = cur.next;
               }
               pre.next = cur.next;
               cur.next = null;
               cur = pre.next;
           } else {
               pre = cur;
               cur = cur.next;
           }
        }
        return head.next;
    }
}
