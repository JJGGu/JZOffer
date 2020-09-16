/**
 * @program: JZOffer
 * @description: 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * @author: JJGGu
 * @create: 2020-09-16 10:25
 **/
public class JZ49 {
    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483649"));
        System.out.println(Integer.parseInt("-2147483649"));

    }
    public static int StrToInt(String str) {
        char[] chars = str.toCharArray();
        int num = 0;
        int a = 10;
        int i;
        for (i = chars.length - 1; i >= 0; i--) {
            int b = (int)Math.pow(a, chars.length - 1 - i);
            int c = chars[i] - '0';
            if (c < 0 || c > 9) {
                break;
            }
            num += b * c;
        }
        if (i == 0) {
            if (chars[i] == '+') {
                return num;
            } else if (chars[i] == '-') {
                return -num;
            }
        } else if (i > 0) {
            return 0;
        }
        return num;
    }
}
