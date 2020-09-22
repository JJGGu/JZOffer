import java.util.ArrayList;

/**
 * @program: JZOffer
 * @description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @author: JJGGu
 * @create: 2020-09-21 21:55
 **/
public class JZ003 {

    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(){};
    }
    // 1.直接反转链表
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null) {
            return arrayList;
        }
        ListNode head = listNode;
        ListNode newHead = listNode;
        ListNode cur;
        while (head.next != null) {
            cur = head.next;
            head.next = cur.next;
            cur.next = newHead;
            newHead  = cur;
        }
        while (newHead != null) {
            arrayList.add(newHead.val);
            newHead = newHead.next;
        }
        return arrayList;
    }

    // 2. 将链表按序存到数组中，对数组进行翻转

    // 3. 后序遍历
    ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
