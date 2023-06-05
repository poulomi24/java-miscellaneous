package com.pratice.coderpad;

public class OptimalPath {

    public static Integer optimalPath(Integer[][] grid)
        {   int row = grid.length;
            int col = grid[0].length;
            int[][] dp = new int[row][col];
            for(int i=0; i<row;i++){
                for(int j=col-1;j>=0;j--){
                    if(i == 0 && j == col-1)
                        dp[i][j] = grid[i][j];
                    else if(i == 0)
                        dp[i][j] = grid[i][j] + dp[i][j+1];
                    else if(j==col-1)
                        dp[i][j] = grid[i][j] + dp[i-1][j];
                    else
                        dp[i][j] = grid[i][j] + Math.max(dp[i-1][j], dp[i][j+1]);
                }
            }
            return dp[row-1][0];
    }


    public static boolean doTestsPass()
    {
        boolean result = true;
        result &= optimalPath(new Integer[][]{{0,0,0,0,5},{0,1,1,1,0},{2,0,0,0,0}}) == 10;
        return result;
    }

    public static void main(String[] args)
    {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}
