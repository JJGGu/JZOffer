import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: JZOffer
 * @description: 在一个字符串(0 < = 字符串长度 < = 10000 ， 全部由字母组成)中找到第一个只出现一次的字符, 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * @author: JJGGu
 * @create: 2020-09-14 10:44
 **/
public class JZ34 {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("hfheraafadfei"));
    }
    // 使用bitmap
    public static int FirstNotRepeatingChar(String str) {
        BitSet bitSet1 = new BitSet('z');
        BitSet bitSet2 = new BitSet('z');
        for (int i = 0; i < str.length(); i++) {
            if (bitSet1.get(str.charAt(i))) {
                bitSet2.set(str.charAt(i));
            } else {
                bitSet1.set(str.charAt(i));
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (bitSet1.get(str.charAt(i)) && !bitSet2.get(str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
