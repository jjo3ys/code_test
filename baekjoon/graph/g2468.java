package baekjoon.graph;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Math;

public class g2468 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static Queue<int[]> queue;
    static boolean[][] visited;
    static int[][] arr;

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int maxM = 0;
        arr = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                int m = sc.nextInt();
                arr[i][j] = m;
                maxM = Math.max(maxM, m);// 영역 중 최대 높이
            }
        }
        int maxC = 1;
        for (int i=0; i<maxM; i++){ // i=0인 이유:비가 오지 않는 경우의 수도 포함해야함
            queue = new LinkedList<>();
            visited = new boolean[n][n];
            int cnt = 0;

            for (int x=0; x<n; x++){
                for (int y=0; y<n; y++){
                    if (arr[x][y] > i && !visited[x][y]){
                        cnt ++;
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                        bfs(i);
                    }
                }
            }
            maxC = Math.max(maxC, cnt);
        }
        System.out.println(maxC);
    }
    public static void dfs(int i, int x, int y){
        for (int j=0; j<4; j++){
            int nx = x+dx[j];
            int ny = y+dy[j];
            if (nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] >i && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(i, nx, ny);
            }
        }
    }
    public static void bfs(int i){
        while(!queue.isEmpty()){
            int[] xy = queue.poll();

            for (int j=0; j<4; j++){
                int nx = xy[0]+dx[j];
                int ny = xy[1]+dy[j];
                if (nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] >i && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
