package baekjoon.graph;

import java.util.Scanner;

class Ice {
    int x, y;
    public Ice(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class g2573 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int n, m;

    static int[][] arr;
    static boolean[][] visited;


    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        arr = new int[n][m]; 

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int year = 0;
        while (true){
            int count = 0;
            visited = new boolean[n][m];

            for (int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if (arr[i][j]>0 && !visited[i][j]){
                        count++;
                        dfs(i, j);
                    }
                }
            }
            if (count>1) break;
            else if (count == 0){
                year = 0;
                break;
            }
            year ++; 
        }
        System.out.println(year); 
    }

    public static void dfs(int cx, int cy){
        visited[cx][cy] = true;
        for (int j=0; j<4; j++){
            int nx = cx + dx[j];
            int ny = cy + dy[j];
            if (nx>=0 && nx< n && ny>=0 && ny<m && !visited[nx][ny]){
                if (arr[cx][cy] > 0 && arr[nx][ny] == 0) arr[cx][cy]--;
                if (arr[nx][ny] > 0) dfs(nx, ny);
            }
        }
    }
}
