/**
 * @program: JZOffer
 * @description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author: JJGGu
 * @create: 2020-09-21 21:28
 **/
public class JZ002 {
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("we are happy")));
    }
    public static String replaceSpace(StringBuffer str) {
        String string = str.toString();
        return string.replace(" ", "%20");
    }
}
