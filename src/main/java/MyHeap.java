import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @program: JZOffer
 * @description: heap
 * @author: JJGGu
 * @create: 2020-09-12 09:02
 **/
// 最小堆,关键点在于：1.数组实际index与堆的index
//    2.在siftDown时，注意while循环的判断条件应当是判断左孩子的index是否小于等于data.size
//    3.
public class MyHeap<E extends Comparable<E>> {
    private ArrayList<E> data;
    public MyHeap() {
        data = new ArrayList<>();
    }
    public int size() {
        return data.size();
    }
    private int parent(int childIndex) {
        return childIndex / 2;
    }
    private int leftChild(int parentIndex) {
        return parentIndex * 2;
    }
    private int rightChild(int parentIndex) {
        return parentIndex * 2 + 1;
    }
    private void siftUp(int index) {
        while (index > 1 && (data.get(parent(index) - 1).compareTo(data.get(index - 1)) > 0)) {
            E temp = data.get(index - 1);
            data.set(index - 1, data.get(parent(index) - 1));
            data.set(parent(index) - 1, temp);
            index = parent(index);
        }
    }
    private void siftDown(int index) {
        while (leftChild(index) <= data.size()) {
            int tempIndex = leftChild(index);
            if (tempIndex + 1 <= data.size() && data.get(leftChild(index) - 1).compareTo(data.get(rightChild(index) - 1)) > 0) {
                tempIndex++;
            }
            // swap
            E temp = data.get(index - 1);
            data.set(index - 1, data.get(tempIndex - 1));
            data.set(tempIndex - 1, temp);

            index = tempIndex;
        }
    }
    public boolean add(E value) {
        data.add(value);
        if (data.size() == 1) {
            return true;
        }
        siftUp(data.size());

        return true;
    }
    public E poll() {
        if (data.size() <= 0) {
            throw new RuntimeException();
        }
        E tempValue = data.get(0);
        int lastIndex = data.size() - 1;
        E lastValue = data.get(lastIndex);
        data.set(0, lastValue);
        data.remove(lastIndex);
        siftDown(1);

        return tempValue;
    }
    public E peek() {
        if (data.size() == 0) {
            throw new RuntimeException();
        }
        return data.get(0);
    }

    public void print() {
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }
}
