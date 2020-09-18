import java.util.ArrayList;

/**
 * @program: JZOffer
 * @description: 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。 窗口大于数组长度的时候，返回空
 * @author: JJGGu
 * @create: 2020-09-18 10:52
 **/
public class JZ64 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3);
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }

    // 接近暴力解法
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(size > num.length || size == 0) {
            return arrayList;
        }
        int left = 0;
        int right = size - 1;
        int max = Integer.MIN_VALUE;
        while (right < num.length) {
            // 确定滑动窗口内的最大值
            if (left == 0) {
                for (int i = 0; i <= right; i++) {
                    max = Math.max(max, num[i]);
                }
                arrayList.add(max);
                left++;
                right++;
                continue;
            }
            if (max < num[right]) {
                max = num[right];
                left++;
                right++;
                arrayList.add(max);
            } else {
                if (max == num[left - 1]) {
                    int temp = Integer.MIN_VALUE;
                    for (int i = left; i <= right; i++) {
                        temp = Math.max(temp, num[i]);
                    }
                    max = temp;
                }
                left++;
                right++;
                arrayList.add(max);
            }

        }

        return arrayList;
    }


    // 大根堆
    public static ArrayList<Integer> maxInWindows1(int [] num, int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        return arrayList;
    }
}

