/**
 * @program: JZOffer
 * @description: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author: JJGGu
 * @create: 2020-09-15 17:21
 **/
public class JZ44 {
    public static void main(String[] args) {
        System.out.println(ReverseSentence("I am a student."));
    }
    public static String ReverseSentence(String str) {
        String[] s = str.split(" ");
        if (s.length <= 1) {
            return str;
        }
        int left = 0;
        int right = s.length - 1;
        int mid = (left + right) / 2;
        while (right != mid) {
            String temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string: s) {
            stringBuilder.append(string);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    // 方法2 自己实现，两次翻转
}
