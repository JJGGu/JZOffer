import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @program: JZOffer
 * @description: 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * @author: JJGGu
 * @create: 2020-09-17 18:51
 **/
public class JZ63 {
    public static void main(String[] args) {
        Integer[] x = {5,2,3,4,1,6,7,0,8};
        for (int i = 0; i < x.length; i++) {
            Insert(x[i]);
            Double aDouble = GetMedian();
            System.out.println(aDouble);
        }
    }

    // 小根堆
    static PriorityQueue<Integer> right = new PriorityQueue<>();
    // 大根堆
    static PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    public static int cnt = 0;
    public static void Insert(Integer num) {
        cnt++;
        // 总数有奇数个, 存放大根堆
        if ((cnt & 1) == 1) {
            if ((right.size() != 0) && num > right.peek()) {
                right.add(num);
                num = right.poll();
            }
            left.add(num);
        } else {
            if (left.size() != 0 && num < left.peek()) {
                left.add(num);
                num = left.poll();
            }
            right.add(num);
        }
    }

    public static Double GetMedian() {
        if (cnt == 0) {
            return 0d;
        }
        if ((cnt & 1) == 1) {
            // ji shu
            return left.peek() + 0d;
        } else {
            return ((left.peek() + 0d)+ (right.peek() + 0d)) / 2 + 0d;
        }
    }
}
