package baekjoon.graph;

import java.util.Scanner;

public class g14503 {
    static int n, m ,d;
    static int cnt = 1;

    static int[][] arr;
    static boolean[][] visited;

    static int[] x = {-1, 0, 1, 0};
    static int[] y = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        d = sc.nextInt();

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        visited[sx][sy] = true;
        dfs(sx, sy);
        System.out.println(cnt);
    }
    public static void dfs(int cx, int cy){
        for (int i=0; i<4; i++){
            if (d==0) d = 3;
            else d--;
            int nx = cx+x[d];
            int ny = cy+y[d];
            if (nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && arr[nx][ny]==0){
                visited[nx][ny] = true;
                cnt++;
                dfs(nx, ny);
                return;
            }
        }       
        int nx = cx-x[d];
        int ny = cy-y[d];
        if (nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]==0){
            if(!visited[nx][ny]){
                cnt ++;
                visited[nx][ny] = true;
            }
            dfs(nx, ny);
        }
    }    
}
