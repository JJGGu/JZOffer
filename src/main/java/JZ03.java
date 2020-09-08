import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 * @program: JZOffer
 * @description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @author: JJGGu
 * @create: 2020-09-06 16:40
 **/

public class JZ03 {
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = printListFromTailToHead3();
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }

    // 思路1 直接将linkedlist数据按顺序存到ArrayList然后使用 java 的Collections去reverse 或者使用交换的方式逆序
    public static ArrayList<Integer> printListFromTailToHead(MyLinkedList.ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        MyLinkedList.ListNode cur = listNode;
        while (cur != null){
            arr.add(cur.val);
            cur = cur.next;
        }
//        Collections.reverse(arr);

        return arr;
    }

    // 思路2 递归实现，将链表作为一个每个非叶子节点只有一个分支的 二叉树，然后后序遍历
    public static ArrayList<Integer> printListFromTailToHead2(MyLinkedList.ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    // 思路3 反转链表
    public static ArrayList<Integer> printListFromTailToHead3() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        MyLinkedList myLinkedList = new MyLinkedList();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        MyLinkedList.ListNode listNode = myLinkedList.create(list);

        MyLinkedList.ListNode origin = listNode;
        MyLinkedList.ListNode cur = listNode.next;
        MyLinkedList.ListNode first = listNode;
        while (cur != null){
            origin.next = cur.next;
            cur.next = first;
            first = cur;
            cur = origin.next;
        }
        while (first.next != null){
            arrayList.add(first.val);
            first = first.next;
        }
        return arrayList;
    }
}
