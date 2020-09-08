/**
 * @program: JZOffer
 * @description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。 n<=39
 * @author: JJGGu
 * @create: 2020-09-08 17:03
 **/
public class JZ07 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
