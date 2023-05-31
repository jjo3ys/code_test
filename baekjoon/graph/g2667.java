package baekjoon.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class g2667 {
    static int [][] apart;
    static boolean [][] visited;
    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, 1, -1};
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        apart = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n;i++){
            String[] line = sc.nextLine().split("");
            for (int j=0; j<n;j++){
                apart[i][j] = Integer.parseInt(line[j]);
            }
        }
        int ccount = 0;
        ArrayList<Integer> countList = new ArrayList<>();

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (apart[i][j]==1 && !visited[i][j]){
                    visited[i][j] = true;
                    ccount ++;
                    countList.add(dfs(i, j, 1));
                }
            }
        }
        Collections.sort(countList);
        System.out.println(ccount);
        for (int i=0; i<ccount; i++){
            System.out.println(countList.get(i));
        }
    }
    public static int dfs(int s_x, int s_y, int count){
        for (int i=0; i<4; i++){
            int n_x = s_x+x[i];
            int n_y = s_y+y[i];
            if (n_x>=0 && n_x<n && n_y>=0 && n_y<n && apart[n_x][n_y]==1 && !visited[n_x][n_y]){
                visited[n_x][n_y] = true;
                count ++;
                count = dfs(n_x, n_y, count);
            }
        }
        return count;
    }
}
