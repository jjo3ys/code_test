package baekjoon.greedy;

import java.util.Scanner;

public class g3109 {
    static int R, C;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1 , 1};
    static boolean[][] road;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        road = new boolean[R][C];
        for (int i=0; i<R; i++){
            String next = sc.next();
            String[] str = next.split("");
            for (int j=0; j<C; j++){
                if (str[j].equals("x")) road[i][j] = true;
            }
        }
        int count = 0;
        for (int i=0; i<R; i++){
            if (!road[i][0] && dfs(i, 0))count++;
        }
        System.out.println(count);
    }
    private static boolean dfs(int x, int y){
        if (y==C-1){
            return true;
        }
        boolean check = false;
        for (int i=0; i<3; i++){
            int nx = x+ dx[i];
            int ny = y+ dy[i];
            if (nx>=0 && nx<R && ny>=0 && ny<C && !road[nx][ny]){
                road[nx][ny] = true;
                check = dfs(nx, ny);
                if (check) return check;
                road[nx][ny] = false;
            }               
        }
        return check;
    }
}
