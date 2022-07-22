package dp;

public class RobotWalk {
    //  给一个范围 机器人给定一个位置, 给定一个终点, 给一个机器人走的步数 返回机器人到达点位的走法一共多少种

    public static int robotWalk1(int N, int start, int target, int step) {
        //N是范围

        // 这个方法是暴力递归的解法
        return process1(N, start, target, step);
    }

    public static int process1(int N, int current, int target, int step) {
        if (step == 0) {
            return current == target ? 1 : 0;
        }
        if (current == 1) {
            return process1(N, current + 1, target, step - 1);
        }
        if (current == N) {
            return process1(N, current - 1, target, step - 1);
        }

        return process1(N, current - 1, target, step - 1) + process1(N, current + 1, target, step - 1);
    }


    public static int robotWalk2(int N, int start, int target, int step) {
        //N是范围
        int[][] dp = new int[N + 1][step + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= step; j++) {
                dp[i][j] = -1;
            }
        }

        // 相当于使用 dp二维数组缓存已经计算过的值 从而是的
        process2(N, start, target, step, dp);
        return dp[start][step];
    }

    public static int process2(int N, int current, int target, int step, int[][] dp) {
        if (dp[current][step] != -1) {
            return dp[current][step];
        }
        int ans = 0;
        if (step == 0) {
            ans = current == target ? 1 : 0;
        } else if (current == 1) {
            ans = process2(N, current + 1, target, step - 1, dp);
        } else if (current == N) {
            ans = process2(N, current - 1, target, step - 1, dp);
        } else {
            ans = process2(N, current + 1, target, step - 1, dp) + process2(N, current - 1, target, step - 1, dp);
        }
        dp[current][step] = ans;
        return ans;
    }

    public static int robotWalk3(int N, int start, int target, int step) {
        //使用dp 二维数组直接搞 直接做出来
        int[][] dp = new int[N + 1][step + 1];
        dp[target][0] = 1;
        for (int rest = 1; rest <= step; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur < N; cur++) {
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }


        return dp[start][step];
    }


    public static void main(String[] args) {


        System.out.println(robotWalk1(5, 2, 4, 6));
        System.out.println(robotWalk2(5, 2, 4, 6));
        System.out.println(robotWalk3(5, 2, 4, 6));



    }

}
