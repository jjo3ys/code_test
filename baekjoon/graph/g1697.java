package baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class g1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean find = false;
        int[] dp = new int[200_000+1];
        dp[n] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        
        a: while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int next:new int[]{cur-1, cur+1, cur*2}){
                if (next>200_000 || next <0) continue;
                if (dp[next]!=0) continue;
                if (next == k){
                    find = true;
                    System.out.println(dp[cur]);
                    break a;
                }
                dp[next] = dp[cur] +1;
                queue.add(next);
            }
        }
        if(! find) System.out.println(0);
    }
}
