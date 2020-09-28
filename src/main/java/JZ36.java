/**
 * @program: JZOffer
 * @description: 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * @author: JJGGu
 * @create: 2020-09-14 21:24
 **/
public class JZ36 {
    // 暴力解法1
    public MyLinkedList.ListNode FindFirstCommonNode(MyLinkedList.ListNode pHead1, MyLinkedList.ListNode pHead2) {
        MyLinkedList.ListNode p = pHead2;
        while (pHead1 != null) {
            while (p != null) {
                if (pHead1 == p){
                    return pHead1;
                }
                p = p.next;
            }
            pHead1 = pHead1.next;
            p = pHead2;
        }

        return null;
    }

    // 双指针法
    public MyLinkedList.ListNode FindFirstCommonNode2(MyLinkedList.ListNode pHead1, MyLinkedList.ListNode pHead2) {
        MyLinkedList.ListNode pa = pHead1;
        MyLinkedList.ListNode pb = pHead2;
        while (pa != pb) {
            pa = (pa == null) ? pHead2 : pa.next;
            pb = (pb == null) ? pHead1 : pb.next;
        }
        return pa;
    }
}
