package daily;

import java.util.LinkedList;
import java.util.Queue;

public class d33 {
    public static void main(String[] args) {
        int[][] room = new int[][]{
        {0, 0, 0, 0, 0, 0},
        {0, 1, 1, 0, 1, 0},
        {0, 1, 0, 0, 0, 0},
        {0, 0, 1, 1, 1, 0},
        {1, 0, 0, 0, 0, 0}
        };
        int[] src = new int[]{4, 2};
        int[] dst = new int[]{2, 2};
        int output = robotPath(room, src, dst);
        System.out.println(output);
    }
    public static int robotPath(int[][] room, int[] src, int[] dst) {
    // TODO :
    int M = room.length;
    int N = room[0].length;
    System.out.println("M :"+M+", N:"+N);
    int[][] arr = new int[M][N];
    boolean[][] visited = new boolean[M][N];
    int[] x = {1, -1, 0, 0};
    int[] y = {0, 0, 1, -1};
    Queue<int[]> queue = new LinkedList<>();
    visited[src[0]][src[1]] = true;
    queue.add(src);
    
    while(!queue.isEmpty()){
      int[] next = queue.poll();
      int cm = next[0];
      int cn = next[1];
      if (cm == dst[0] && cn == dst[1]) break;

      for (int i=0; i<4; i++){
        int nm = cm+x[i];
        int nn = cn+y[i];
        if (nm>=0 && nm <M && nn>=0 && nn <N && room[nm][nn]==0){
          if (!visited[nm][nn]){
            visited[nm][nn] = true;
            arr[nm][nn] = arr[cm][cn]+1;
            queue.add(new int[]{nm, nn});
          }          
        }
      }
    }
    return arr[dst[0]][dst[1]];
  }
}
