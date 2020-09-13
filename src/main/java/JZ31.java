/**
 * @program: JZOffer
 * @description: 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * @author: JJGGu
 * @create: 2020-09-13 10:52
 **/
public class JZ31 {
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(13));
    }
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += count(i);
        }
        return count;
    }
    private static int count(int x) {
        int count = 0;
        while (x != 0) {
            int p = x % 10;
            if (p == 1) {
                count++;
            }
            x = x / 10;
        }
        return count;
    }
}
