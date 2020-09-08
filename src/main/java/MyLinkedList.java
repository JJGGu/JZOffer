import java.util.List;

/**
 * @program: JZOffer
 * @description:
 * @author: JJGGu
 * @create: 2020-09-07 18:09
 **/
public class MyLinkedList {
    // 头结点
    ListNode head = new ListNode();
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(){};
    }
    public void insert(ListNode listNode){
        // 尾插
        ListNode last = head;
        while (last.next != null){
            last = last.next;
        }
        listNode.next = null;
        last.next = listNode;
    }

    public ListNode create(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            insert(new ListNode(list.get(i)));
        }

        return head;
    }
}
