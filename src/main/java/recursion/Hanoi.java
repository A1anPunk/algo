package recursion;

public class Hanoi {
    // 汉诺塔问题
    // 打印每一步移动盘子的动作


    public static void Hanoi1(int n) {

        leftToRight(n);

    }

    public static void leftToRight(int n) {
        if (n == 1) {
            System.out.println("移动 1 左 -> 右");
            return;
        }
        leftToMid(n - 1);
        System.out.println("移动 " + n + " 左 -> 右");
        midToRight(n - 1);

    }

    public static void leftToMid(int n) {
        if (n == 1) {
            System.out.println("移动 1 左 -> 中");
            return;
        }
        leftToRight(n - 1);
        System.out.println("移动 " + n + " 左 -> 中");
        rightToMid(n - 1);
    }

    private static void rightToMid(int n) {
        if (n == 1) {
            System.out.println("移动 1 右 -> 中");
            return;
        }
        rightToLeft(n - 1);
        System.out.println("移动 " + n + " 右 -> 中");
        leftToMid(n - 1);

    }

    private static void rightToLeft(int n) {
        if (n == 1) {
            System.out.println("移动 1 右 -> 中");
            return;
        }
        rightToMid(n - 1);
        System.out.println("移动 " + n + " 右 -> 中");
        midToLeft(n - 1);

    }

    private static void midToLeft(int n) {
        if (n == 1) {
            System.out.println("移动 1 中 -> 左");
            return;
        }
        midToRight(n - 1);
        System.out.println("移动 " + n + " 中 -> 左");
        rightToLeft(n - 1);

    }

    public static void midToRight(int n) {
        if (n == 1) {
            System.out.println("移动 1 中 -> 右");
            return;
        }
        midToLeft(n - 1);
        System.out.println("移动 " + n + " 中 -> 右");
        leftToRight(n - 1);
    }


    public static void Hanoi2(int n) {
        func(n,"左","右","中");
    }

    public static void func(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("移动 1 " + from + " -> " + to);
            return;
        }
        func(n - 1, from, other, to);
        System.out.println("移动 " + n + " " + from + " -> " + to);
        func(n - 1, other, to, from);
    }


    public static void main(String[] args) {
//        Hanoi1(3);
        System.out.println("==================================");
        Hanoi2(2);
    }
}
