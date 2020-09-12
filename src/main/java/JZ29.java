import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @program: JZOffer
 * @description: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * @author: JJGGu
 * @create: 2020-09-11 15:45
 **/
public class JZ29 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = solution2(new int[]{4, 5, 1, 6, 2, 7, 3}, 4);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
    // 方法1 堆排序
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length) {
            return result;
        }
        if (k > input.length) {
            return result;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int value : input) {
            queue.add(value);
        }
        for (; k > 0; k--) {
            result.add(queue.poll());
        }
        return result;
    }
    // 使用自己的堆
    public static ArrayList<Integer> solution(int[] input, int k) {
        Heap heap = new Heap();
        for (int i = 0; i < input.length; i++) {
            heap.add(input[i]);
        }
        ArrayList<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(heap.poll());
        }
        return result;
    }

    public static class Heap{
        private ArrayList<Integer> data;
        public Heap() {
            data = new ArrayList<>();
        }
        public void add(int value) {
            data.add(value);
            int childIndex = data.size();
            int parentIndex = childIndex / 2;
            while (parentIndex > 0 && data.get(parentIndex - 1).compareTo(data.get(childIndex - 1)) > 0) {
                // swap
                int temp = data.get(parentIndex - 1);
                data.set(parentIndex - 1, data.get(childIndex - 1));
                data.set(childIndex - 1, temp);

                childIndex = parentIndex;
                parentIndex = childIndex / 2;
            }
        }
        public int poll() {
            if (data.size() == 0) {
                throw new RuntimeException();
            }
            if (data.size() == 1){
                return data.get(0);
            }
            int first = data.get(0);
            int lastValue = data.get(data.size() - 1);
            data.set(0, lastValue);
            data.remove(data.size() - 1);
            int parentIndex = 1;
            int leftChildIndex = parentIndex * 2;
            while (leftChildIndex < data.size()) {
                if (data.get(leftChildIndex - 1) > data.get(leftChildIndex - 1 + 1)) {
                    leftChildIndex++;
                }
                if (data.get(parentIndex - 1) > data.get(leftChildIndex - 1)) {
                    // swapz
                    int temp = data.get(parentIndex - 1);
                    data.set(parentIndex - 1, data.get(leftChildIndex - 1));
                    data.set(leftChildIndex - 1, temp);

                    parentIndex = leftChildIndex;
                    leftChildIndex *= 2;
                } else {
                    break;
                }
            }

            return first;
        }
    }

    // 方法2 快排
    public static ArrayList<Integer> solution2(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length) {
            return result;
        }
        qsort(input, 0, input.length - 1);
        for (int i = 0; i < 5; i++) {
            result.add(input[i]);
        }
        return result;
    }


    private static int partation(int [] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            };
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            };
            arr[right] = arr[left];

        }

        arr[left] = pivot;
        return left;
    }

    private static void qsort(int [] arr, int left, int right){
        int mid;
        if (left < right) {
            mid = partation(arr, left, right);
            System.out.println();
            qsort(arr, left, mid - 1);
            qsort(arr, mid + 1, right);
        }
    }


}
