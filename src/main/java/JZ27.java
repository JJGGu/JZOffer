import java.util.*;

/**
 * @program: JZOffer
 * @description: 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @author: JJGGu
 * @create: 2020-09-11 12:07
 **/
public class JZ27 {
    public static TreeSet<String> set = new TreeSet<String>();
    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> permutation = Permutation(str);
        for (String string: permutation) {
            System.out.println(string);
        }
    }
    public static ArrayList<String> Permutation(String str) {
        recur(0, str.toCharArray());
        return new ArrayList<String>(set);
    }

    public static void recur(int pos, char [] str) {
        if (pos == str.length - 1) {
            set.add(new String(str));
            return;
        }
        for (int i = pos; i < str.length; i++) {
            char temp = str[i];
            str[i] = str[pos];
            str[pos] = temp;

            recur(pos + 1, str);

            temp = str[i];
            str[i] = str[pos];
            str[pos] = temp;
        }
    }

}
