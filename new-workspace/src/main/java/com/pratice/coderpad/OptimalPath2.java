package com.pratice.coderpad;

public class OptimalPath2 {
    public static int optimalPath(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // Fill in the dp array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}
        };

        int maxRocks = optimalPath(grid);
        System.out.println("Maximum number of rocks collected: " + maxRocks);
    }
}

