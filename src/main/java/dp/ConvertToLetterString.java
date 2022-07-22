package dp;

public class ConvertToLetterString {
    //  A-Z 用数字编码 1-26 则 字符串 '111' 可以表示为 'AAA' , 'AK' 'KA'
    // 题目给定一个字符串 返回一共多少种组合


    public static int getAllGroup(String s) {
        char[] arr = s.toCharArray();
        return process(arr, 0);
    }

    public static int process(char[] arr, int index) {
        if (index == arr.length) {
            return 1;
        }
        if (arr[index] == '0') {
            return 0;
        }
        int res;
        res = process(arr, index + 1);
        if (arr.length - index > 1 && (arr[index] - '0') * 10 + arr[index + 1] - '0' < 27) {
            res += process(arr, index + 2);
        }
        return res;
    }

    public static int dp(String s) {
        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length + 1];
        dp[arr.length] = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int res;
            if (arr[i] == '0') {
                dp[i] = 0;
            } else {
                res = dp[i + 1];
                if (i + 1 < arr.length && (arr[i] - '0') * 10 + arr[i + 1] - '0' < 27) res += dp[i + 2];
                dp[i] = res;
            }

        }
        return dp[0];

    }


    public static void main(String[] args) {
        System.out.println(getAllGroup("11111"));
        System.out.println(dp("11111"));
    }

}
