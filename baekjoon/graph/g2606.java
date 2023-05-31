package baekjoon.graph;

import java.util.Scanner;
import java.util.StringTokenizer;

public class g2606 {
    static int[][] arr;
    static boolean[] visited;
    static int sum = 0;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        n = Integer.parseInt(sc.nextLine());
        int e = Integer.parseInt(sc.nextLine());

        arr = new int[n][n];
        visited = new boolean[n];

        while (e-- >0){
            st = new StringTokenizer(sc.nextLine());
            int p_n = Integer.parseInt(st.nextToken())-1;
            int c_n = Integer.parseInt(st.nextToken())-1;
            arr[p_n][c_n] = 1;
            arr[c_n][p_n] = 1;
        }
        visited[0] = true;
        dfs(0);
        System.out.println(sum);
    }
    public static void dfs(int s){      
        for (int i=0; i<n; i++){
            if (arr[s][i]==1 && !visited[i]){
                visited[i] = true;
                sum ++;
                dfs(i);
            }
        }
    }
}
