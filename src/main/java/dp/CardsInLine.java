package dp;

public class CardsInLine {
    // 两个绝顶聪明的高手玩扑克游戏,  每次可以从数组的左右两端取走一个扑克 到最后取完的分数最高 , 返回这个最高的分数

    public static int win1(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int p1 = first1(arr, 0, arr.length - 1);
        int p2 = then1(arr, 0, arr.length - 1);
        return Math.max(p1, p2);
    }

    public static int first1(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int left = arr[L] + then1(arr, L + 1, R);
        int right = arr[R] + then1(arr, L, R - 1);
        return Math.max(left, right);
    }

    public static int then1(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int left = first1(arr, L + 1, R);
        int right = first1(arr, L, R - 1);
        return Math.min(left, right);
    }


    public static int win2(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int len = arr.length;
        int[][] f = new int[len][len];
        int[][] t = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                f[i][j] = -1;
                t[i][j] = -1;
            }
        }
        int p1 = first2(arr, 0, arr.length - 1, f, t);
        int p2 = then2(arr, 0, arr.length - 1, f, t);
        return Math.max(p1, p2);
    }

    public static int first2(int[] arr, int L, int R, int[][] dp1, int[][] dp2) {
        if (dp1[L][R] != -1) {
            return dp1[L][R];
        }
        int ans;
        if (L == R) {
            ans = arr[L];
        } else {
            ans = Math.max(arr[L] + then2(arr, L + 1, R, dp1, dp2), arr[R] + then2(arr, L, R - 1, dp1, dp2));
        }
        dp1[L][R] = ans;
        return ans;

    }

    public static int then2(int[] arr, int L, int R, int[][] dp1, int[][] dp2) {
        if (dp2[L][R] != -1) {
            return dp2[L][R];
        }
        int ans;
        if (L == R) {
            ans = 0;
        } else {
            ans = Math.min(first2(arr, L + 1, R, dp1, dp2), first2(arr, L, R - 1, dp1, dp2));
        }
        dp2[L][R] = ans;
        return ans;
    }

    public static int win3(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int len = arr.length;
        int[][] f = new int[len][len];
        int[][] t = new int[len][len];
        for (int i = 0; i < len; i++) {
            f[i][i] = arr[i];
            t[i][i] = 0;
        }
        for (int col = 1; col < len; col++) {
            int L = 0;
            int R = col;
            while (R < len) {
                f[L][R] = Math.max(arr[L] + t[L + 1][R], arr[R] + t[L][R - 1]);
                t[L][R] = Math.min(f[L + 1][R], f[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(f[0][len-1],t[0][len-1]);
    }


    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7};
        System.out.println(win1(arr));
        System.out.println(win2(arr));
//        System.out.println(win2(arr));
        System.out.println(win3(arr));

    }

}
