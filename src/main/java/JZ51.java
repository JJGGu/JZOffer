/**
 * @program: JZOffer
 * @description: 给定一个数组A[0, 1, ..., n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];） 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 * @author: JJGGu
 * @create: 2020-09-16 11:03
 **/
public class JZ51 {
    public static void main(String[] args) {
        int[] multiply = multiply(new int[]{1, 2, 3, 4, 5,});
        for (int i = 0; i < multiply.length; i++) {
            System.out.println(multiply[i]);
        }
    }
    public static int[] multiply(int[] a) {
        int[] b = new int[a.length];
        b[0] = 1;
        // 左下角元素
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }

        // 乘以右下角元素
        int temp = 1;
        for (int i = 1; i < a.length; i++) {
            temp = temp * a[a.length - i];
            b[b.length - 1 - i] *= temp;
        }
        return b;
    }
}
