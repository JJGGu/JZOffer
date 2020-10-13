import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: JZOffer
 * @description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author: JJGGu
 * @create: 2020-09-11 15:26
 **/
public class JZ28 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        int i = MoreThanHalfNum_Solution2(arr);
        System.out.println(i);
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.replace(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > array.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    // 消除法
    public static int MoreThanHalfNum_Solution2(int [] array) {
        int count = 0;
        int curValue = -1;

        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                curValue = array[i];
                count++;
            } else {
                if (curValue == array[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        // 可能没有解，进行判断
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (curValue == array[i]) {
                count++;
            }
        }
        if (count > array.length >> 1) {
            return curValue;
        }
        else {
            return 0;
        }
    }

}
