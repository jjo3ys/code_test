package baekjoon.graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Queue;
public class g2178 {
    static int N;
    static int M;
    static int[][] maze;
    static boolean[][] visited;
    static int[][] distance;
    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];
        for (int i=0; i<N; i++){
            String[] arr = sc.nextLine().split("");
            for (int j=0; j<M;j++){
                maze[i][j] = Integer.parseInt(arr[j]);
            }
        }
        bfs();
        System.out.println(distance[N-1][M-1]);
        // System.out.println(dfs( 0, 0, 0));
    }
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        distance[0][0] = 1;
        while (!queue.isEmpty()){
            int[] curXY = queue.poll();

            for (int i=0; i<4; i++){
                int n = curXY[0] + x[i];
                int m = curXY[1] + y[i];
                if (n>=0 && n<N && m>=0 && m<M && maze[n][m]==1 && !visited[n][m]){
                    visited[n][m] = true;
                    distance[n][m] = distance[curXY[0]][curXY[1]]+1;
                    queue.add(new int[]{n, m});
                }
            }
            
        }
    }
    public static int dfs(int n, int m, int sum){ // 시간초과... bfs로 풀어야함!!
        if (n==N-1 && m==M-1){
            return sum+1;
        }
        int cnt = sum+1;
        ArrayList<Integer> arr = new ArrayList<>();
        if (n-1>=0 && maze[n-1][m]==1 && !visited[n-1][m]){
            visited[n-1][m] = true;
            int u = dfs(n-1, m, cnt);
            if (u == cnt) arr.add(N*M);
            else arr.add(u);
            visited[n-1][m] = false;
        }
        if (n+1< maze.length && maze[n+1][m]==1 && !visited[n+1][m]){
            visited[n+1][m] = true;
            int d = dfs(n+1, m, cnt);
            if (d == cnt) arr.add(N*M);
            else arr.add(d);
            visited[n+1][m] = false;
        }
        if (m-1>=0 && maze[n][m-1]==1 && !visited[n][m-1]){
            visited[n][m-1] = true;
            int l = dfs(n, m-1, cnt);
            if (l == cnt) arr.add(N*M);
            else arr.add(l);
            visited[n][m-1] = false;

        }
        if (m+1< maze[0].length && maze[n][m+1]==1 && !visited[n][m+1]){
            visited[n][m+1] = true;
            int r = dfs(n, m+1, cnt);
            if (r == cnt) arr.add(N*M);
            else arr.add(r);
            visited[n][m+1] = false;
        }
        if (arr.isEmpty()) return M*N;
        return Collections.min(arr);
    }
}
