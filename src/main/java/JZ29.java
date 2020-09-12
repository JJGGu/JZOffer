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
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
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
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int value : input) {
            queue.add(value);
        }
        for (; k > 0; k--) {
            result.add(queue.poll());
        }
        return result;
    }

}
