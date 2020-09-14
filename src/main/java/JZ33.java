import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @program: JZOffer
 * @description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author: JJGGu
 * @create: 2020-09-14 09:34
 **/
public class JZ33 {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(5));
    }
    public static int GetUglyNumber_Solution(int n) {
        if (n <= 0 ) {
            return 0;
        }
        int [] a = new int[n];
        a[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            a[i] = Math.min(a[p2] * 2, Math.min(a[p3] * 3, a[p5] * 5));
            if (a[i] == a[p2] * 2) {
                p2++;
            }
            if (a[i] == a[p3] * 3) {
                p3++;
            }
            if (a[i] == a[p5] * 5) {
                p5++;
            }

        }
        return a[n - 1];
    }
}
