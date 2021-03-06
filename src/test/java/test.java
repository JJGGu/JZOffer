import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: JZOffer
 * @description: 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: JJGGu
 * @create: 2020-09-06 09:27
 *
 **/

public class test {
    @Test
    public void test1(){
        MyLinkedList myLinkedList = new MyLinkedList();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        MyLinkedList.ListNode listNode = myLinkedList.create(list);
        while (listNode.next != null){
            listNode = listNode.next;
            System.out.println(listNode.val);
        }
    }
    @Test
    public void test2() {
        MyHeap<Integer> heap = new MyHeap<>();
        heap.add(10);
        heap.add(13);
        heap.add(1);
        heap.add(4);
        heap.add(85);
        for (int i = 0; i < 5; i++) {
            Integer poll = heap.poll();
            System.out.println(poll);
        }
    }

    @Test
    public void test3() {
        int[] a = {4, 4, 2, 6, 8, 1, 3, 6,10};
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length - 1; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    @Test
    public void test4() {
        System.out.println(sum(3));
    }
    private int sum(int n) {
        if (n == 1) {
            return n;
        }
        return sum(n - 1) + n;
    }
    
    @Test
    public void test5() {
        System.out.println(2 ^ 2);
    }
}
