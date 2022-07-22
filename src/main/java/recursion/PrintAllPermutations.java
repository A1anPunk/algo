package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrintAllPermutations {
    // 打印一个字符串所有的子序列
    // 例如 abc -> abc acb bca bac cab cba

    public static List<String> printAll1(String s) {
        // 使用暴力递归
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        process1(chars, 0, result);
        return result;
    }

    public static void process1(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(String.valueOf(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            process1(chars, index + 1, result);
            swap(chars, i, index);
        }
    }


    public static void swap(char[] chars, int index1, int index2) {
        char tmp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = tmp;
    }


    public static List<String> printAll2(String s) {
        // 使用暴力递归
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        List<Character> chars = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        System.out.println(chars.size());
        String path = "";
        process2(chars, path, result);
        return result;
    }

    public static void process2(List<Character> chars, String path, List<String> result) {
        if (chars.size() == 0) {
            result.add(path);
            return;
        }
        for (int i = 0; i < chars.size(); i++) {
            Character c1 = chars.get(i);
            chars.remove(i);
            process2(chars, path + c1, result);
            chars.add(i, c1);
        }
    }

    public static List<String> printAll3(String s) {
        // 使用暴力递归
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        process3(chars, 0, result);
        return result;
    }

    public static void process3(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(String.valueOf(chars));
            return;
        }
        boolean[] visited = new boolean[256];
        for (int i = index; i < chars.length; i++) {
            if (!visited[chars[i]]) {
                visited[chars[i]] = true;
                swap(chars, i, index);
                process3(chars, index + 1, result);
                swap(chars, i, index);
            }
        }

    }


    public static void main(String[] args) {
        List<String> abc = printAll1("acc");
        for (String s : abc) {
            System.out.println(s);
        }
        System.out.println("======================================");

        List<String> abc2 = printAll2("acc");
        for (String s : abc2) {
            System.out.println(s);
        }
        System.out.println("======================================");

        List<String> abc3 = printAll3("acc");
        for (String s : abc3) {
            System.out.println(s);
        }
    }

}
