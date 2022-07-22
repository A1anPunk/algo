package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsquences {

    // 打印一个字符串的所有子序列
    // 示例:  abc ->  a b c ab ac bc abc

    public static List<String> subs(String s) {
        char[] chars = s.toCharArray();
        String path = "";
        ArrayList<String> result = new ArrayList<>();
        process(chars, 0, path, result);
        return result;
    }

    public static void process(char[] chars, int index, String path, List<String> result) {
        if (index >= chars.length) {
            result.add(path);
            return;
        }

        process(chars, index + 1, path, result);
        process(chars,index+1, path+chars[index],result);
    }


    public static void main(String[] args) {
        List<String> abc = subs("abc");
        for (String s : abc) {
            System.out.println(s);
        }
    }


}
