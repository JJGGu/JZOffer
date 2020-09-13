import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: JZOffer
 * @description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author: JJGGu
 * @create: 2020-09-13 11:07
 **/
public class JZ32 {
    public static ArrayList<ArrayList<String>> result = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(PrintMinNumber2(new int [] {3334,3,3333332}));
    }
    public static String PrintMinNumber(int [] numbers) {
        String [] data = new String[numbers.length];
        if (numbers.length == 0) {
            return "";
        }
        for (int i = 0; i < numbers.length; i++) {
            data[i] = String.valueOf(numbers[i]);
        }

        perm(data, 0);

        StringBuilder minStr = new StringBuilder();
        Long min;
        for (int i = 0; i < data.length; i++) {
            minStr.append(data[i]);
        }
        min = Long.parseLong(minStr.toString());
        for (ArrayList<String> arrayList: result) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s: arrayList) {
                stringBuilder.append(s);
            }
            Long i = Long.parseLong(stringBuilder.toString());
            if (min > i) {
                min = i;
            }
        }
        return String.valueOf(min);
    }
    // 全排列 暴力解法
    private static void perm(String [] data, int pos) {
        if (pos + 1 == data.length) {
            result.add(new ArrayList<>(Arrays.asList(data)));
        }
        for (int i = pos; i < data.length; i++) {
            String temp = data[i];
            data[i] = data[pos];
            data[pos] = temp;

            perm(data, pos + 1);

            temp = data[i];
            data[i] = data[pos];
            data[pos] = temp;

        }
    }

    // 方法2 "排序"后计算
    public static String PrintMinNumber2(int [] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (compare(numbers[j], numbers[j + 1]) > 0) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            stringBuilder.append(numbers[i]);
        }
        return stringBuilder.toString();
    }
    // a > b 返回1 反之返回-1 相等返回0
    private static int compare(int a, int b) {
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        String[] split1 = str1.split("");
        String[] split2 = str2.split("");
        int i = 0;
        while (i < split1.length && i < split2.length) {
            if (split1[i].equals(split2[i])) {
                i++;
                continue;
            }
            if (Integer.parseInt(split1[i]) < Integer.parseInt(split2[i])) {
                return -1;
            } else {
                return 1;
            }
        }
        if (i == split1.length) {
            for (int j = i; j < split2.length; j++){
                if (Integer.parseInt(split1[i - 1]) < Integer.parseInt(split2[j])) {
                    return -1;
                }
            }

            return 1;
        } else if (i == split2.length) {
            for (int j = i; j < split1.length; j++){
                if (Integer.parseInt(split2[i - 1]) < Integer.parseInt(split1[j])) {
                    return 1;
                }
            }
            return -1;
        } else {
            return 0;
        }
    }


}
