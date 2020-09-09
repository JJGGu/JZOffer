/**
 * @program: JZOffer
 * @description:
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。 exponent 可能为负数
 * 保证base和exponent不同时为0
 * @author: JJGGu
 * @create: 2020-09-09 10:02
 **/
public class JZ12 {
    public static void main(String[] args) {
        System.out.println(Power(2.0, 3));
    }
    // 直接递归
    public static double Power(double base, int exponent) {
        if (exponent < 0){
            base = 1 / base;
            exponent = -exponent;
        }

        base = myPower3(base, exponent);
        return base;
    }
    private static double myPower(double base, int exponent){
        if (base == 0) {
            return 0d;
        }
        if (exponent == 0){
            return 1d;
        }

        base = myPower(base, exponent - 1) * base;
        return base;
    }

    // 快速幂 递归
    public static double myPower2(double base, int exponent) {
        if (base == 0) {
            return 0d;
        }
        if (exponent == 0){
            return 1d;
        }

        double result = myPower2(base, exponent / 2);
        if (exponent % 2 == 1) {
            // qishu
            return result * result * base;
        } else {
            return result * result;
        }
    }

    // 快速幂 非递归（官方pow函数做法）
    public static double myPower3(double base, int exponent) {
        double result = 1d;
        double record = base; // / 记录x^0, x^1, x^2 ...
        while (exponent != 0) {
            if (exponent % 2 == 1) {
                // 2进制最后一位为1
                result *= record; // 乘以x^0, x^1, x^2 ...
            }
            record *= record;
            exponent >>= 1; // 右移 一位
        }

        return result;
    }

}
