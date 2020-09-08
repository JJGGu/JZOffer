/**
 * @program: JZOffer
 * @description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author: JJGGu
 * @create: 2020-09-06 16:09
 **/
public class JZ02 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We are Happy");
        System.out.println(replaceSpace2(str));
    }
    public static String replaceSpace(StringBuffer str){
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            System.out.println(c);
            if (" ".equals(c.toString())){
                str.replace(i, i + 1, "%20");
            }
        }
        return str.toString();
    }

    public static String replaceSpace2(StringBuffer str){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); ++i){
            char c = str.charAt(i);
            if (" ".equals(Character.toString(c))){
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

}
