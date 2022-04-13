package cn.xieziheng;

/**
 * @author binglang
 * @date 2022-04-11 22:06
 */
public class CountNumberWithUniqueDigits {

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 9;
        for (int i = 2;i <= n; i++) {
            int ans = 9;
            for (int j = 0; j < i - 1; j++) {
                ans *= (9 - j);
            }
            dp[i] = ans + dp[i-1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int a = countNumbersWithUniqueDigits(3);
        System.out.println(a);
    }

}
