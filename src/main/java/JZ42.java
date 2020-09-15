import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: JZOffer
 * @description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @author: JJGGu
 * @create: 2020-09-15 14:40
 **/
public class  JZ42 {
    public static void main(String[] args) {
        System.out.println(FindNumbersWithSum2(new int[]{1, 2, 3 ,4 ,5 , 8, 10}, 10));
    }

    // 1.哈希法
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>(2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], array[i]);
        }
        int min = 10000000;
        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            int b = sum - a;
            if (map.containsKey(b)) {
                if (a * b < min) {
                    min = a * b;
                    arrayList.add(a);
                    arrayList.add(b);
                }
            }
        }
        return arrayList;
    }

    // 2.双指针法
    public static ArrayList<Integer> FindNumbersWithSum2(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            if (array[left] + array[right] < sum) {
                left++;
            }
            if (array[left] + array[right] > sum) {
                right--;
            }
            if (array[left] + array[right] == sum) {
                arrayList.add(array[left]);
                arrayList.add(array[right]);
                break;
            }
        }
        return arrayList;
    }
}
