package 动态规划;

import java.util.Arrays;

public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        // 初始化数组为一个无法达到的值
        Arrays.fill(dp, amount + 1);
        // 金额为0时所需硬币数量为0
        dp[0] = 0;
        // 从1开始遍历到amount的每个金额
        for (int i = 1; i <= amount; i++) {
            // 遍历硬币
            for (int coin : coins) {
                // 当前的金额大于等于硬币的面值
                if (i >= coin) {
                    // 当前金额 = coin + （i - coin）
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
