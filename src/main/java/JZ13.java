/**
 * @program: JZOffer
 * @description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author: JJGGu
 * @create: 2020-09-09 11:13
 **/
public class JZ13 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void reOrderArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                // 为奇数,找之前是否有偶数
                for (int j = 0; j < i; j++) {
                    if (array[j] % 2 == 0) {
                        // 为偶数，交换
                        int temp = array[j];
                        array[j] = array[i];
                        array[i] = temp;
                    }
                }
            }
        }
    }
}
