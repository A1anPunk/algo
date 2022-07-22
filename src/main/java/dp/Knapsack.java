package dp;

public class Knapsack {

    // 所有的货，重量和价值，都在w和v数组里
    // 为了方便，其中没有负数
    // bag背包容量，不能超过这个载重
    // 返回：不超重的情况下，能够得到的最大价值
    public static int maxValue1(int[] w, int[] v, int bag) {
        // w为重量数组, v为价值数组, bag是背包最大载重

        return process(w, v, 0, bag);
    }

    public static int process(int[] w, int[] v, int index, int bag) {
        if (index == w.length) {
            return 0;
        }
        int ans1 = 0;
        if (w[index] <= bag) {
            ans1 = v[index] + process(w, v, index + 1, bag - w[index]);
        }
        int ans2 = process(w, v, index + 1, bag);

        return Math.max(ans1, ans2);

    }





    public static int maxValue3(int[] w, int[] v, int bag) {
        int[][] dp = new int[w.length+1][bag + 1];
        for (int index = w.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = 0;
                if (w[index] <= rest) {
                    p1 = v[index] + dp[index+1][rest-w[index]];
                }
                int p2 = dp[index+1][rest];
                dp[index][rest] = Math.max(p1, p2);
            }
        }

        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7, 3, 1, 7};
        int[] values = {5, 6, 3, 19, 12, 4, 2};
        int bag = 15;
        System.out.println(maxValue1(weights, values, bag));
        System.out.println(maxValue3(weights, values, bag));
    }


}
