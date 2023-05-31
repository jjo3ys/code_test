package coplit.greedy;

import java.util.Arrays;

public class dp1 {
    public static void main(String[] args) {
        ocean(50, new int[]{10, 20, 50});
    }
    public static long ocean(int target, int[] type) {
        // TODO:
            Arrays.sort(type);
        long[][] dp = new long[type.length][target+1];
        for (int i=0; i<=target;i++){
          if (i%type[0]==0){
            dp[0][i] = 1;
          }
        }
        for (int i=1; i<type.length; i++){
          for (int j=0; j<=target; j++){
            if (j < type[i]){
              dp[i][j] = dp[i-1][j];
            } else{
              dp[i][j] = dp[i][j-type[i]] + dp[i-1][j];
            }
          }
        }
        return dp[type.length-1][target];
    } 
}
