package daily;

import java.util.Arrays;

public class d44 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,-4,5,-4,5,-4,-4,-1};
        System.out.println(LSCS(a));
    }
    public static int LSCS(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i=1;i<arr.length;i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);

        }
        System.out.println(Arrays.toString(dp));
        return dp[arr.length-1];
    }
}
