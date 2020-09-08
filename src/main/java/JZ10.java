/**
 * @program: JZOffer
 * @description: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author: JJGGu
 * @create: 2020-09-08 20:58
 **/
public class JZ10 {
    public static int RectCover(int n) {
        if (n==0 || n==1 || n==2) return n;
        int a = 1, b = 2, c = 0;
        for (int i=3; i<=n; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
