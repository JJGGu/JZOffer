/**
 * @program: JZOffer
 * @description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author: JJGGu
 * @create: 2020-09-23 19:52
 **/
public class JZ012 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        reOrderArray(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public static void reOrderArray(int [] array) {
        int j = 0;
        while (j < array.length) {
            if ((array[j] & 1) == 0) {
                int i = j + 1;
                while (i < array.length && (array[i] & 1) == 0) {
                    i++;
                }
                if (i == array.length) {
                    return;
                }
                int temp = array[i];
                for (int k = i; k > j; k--) {
                    array[k] = array[k - 1];
                }
                array[j] = temp;
            }
            j++;

        }
    }
}
