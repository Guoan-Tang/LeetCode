public class solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        if (obstacleGrid.length < 2 || obstacleGrid[0].length < 2) {
            if (obstacleGrid.length < 2 && obstacleGrid[0].length < 2) {
                return 1;
            } else if (obstacleGrid.length < 2) {
                for (int i = 1; i < obstacleGrid[0].length; i++) {
                    if(obstacleGrid[0][i]==1){
                        return 0;
                    }
                }
                return 1;
            } else {
                for (int i = 1; i < obstacleGrid.length; i++) {
                    if(obstacleGrid[i][0]==1){
                        return 0;
                    }
                }
                return 1;
            }
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][1] == 0) {
            dp[0][1] = 1;
        }
        if (obstacleGrid[1][0] == 0) {
            dp[1][0] = 1;
        }
        for (int i = 2; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 2; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 0 && dp[0][i - 1] == 1) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
