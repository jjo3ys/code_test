package baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.lang.Math;

public class g7569 {
    static int m, n, h;

    static int[] x = {1, -1, 0, 0, 0, 0};
    static int[] y = {0, 0, 1, -1, 0, 0};
    static int[] z = {0, 0, 0, 0, 1, -1};

    static Queue<int[]> queue;
    static int[][][] boxes;
    static boolean[][][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        boxes = new int[h][n][m];
        visited = new boolean[h][n][m];
        queue = new LinkedList<>();

        for (int i=0; i<h; i++){
            for (int j=0; j<n; j++){
                for (int k=0; k<m; k++){
                    int t = sc.nextInt();
                    boxes[i][j][k] = t;
                    if (t==1) queue.add(new int[]{i, j, k});
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        while (!queue.isEmpty()){
            int[] xyz = queue.poll();
            int cx = xyz[2];
            int cy = xyz[1];
            int cz = xyz[0];
            for (int i=0; i<6; i++){
                int nx = cx + x[i];
                int ny = cy + y[i];
                int nz = cz + z[i];
                if (nx>=0 && nx <m && ny>=0 && ny<n && nz>=0 && nz<h && boxes[nz][ny][nx]==0){
                    boxes[nz][ny][nx] = boxes[cz][cy][cx]+1;
                    if(visited[nz][ny][nx]){
                        boxes[nz][ny][nx] = Math.min(boxes[nz][ny][nx], boxes[cz][cy][cx]+1);
                    }
                    visited[nz][ny][nx] = true;
                    queue.add(new int[]{nz, ny, nx});
                }
            }
            if (queue.size()==1){
                System.out.println(boxes[cz][cy][cx]);
            }
        }
        int maxV = 0;
        for (int i=0; i<h; i++){
            for (int j=0; j<n; j++){
                for (int k=0; k<m; k++){
                    if (boxes[i][j][k]==0) return -1;
                    maxV = Math.max(maxV, boxes[i][j][k]);
                }
            }
        }
        return maxV-1;     
    }
}
