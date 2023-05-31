package coplit.graph;

import java.util.*;

public class dfs_bfs_vertex { 
	public static int connectedVertices(int[][] edges) {
    // TODO:
    int max = 0;
    int count = 0;

    for (int[] edge : edges){
      for (int i=0; i<2;i++){
        max = edge[i] > max ? edge[i]:max;
      }
    }

    int[][] arr = new int[max+1][max+1];
    boolean[] visited = new boolean[max+1];

    for(int[] edge:edges){
        arr[edge[0]][edge[1]] = 1;
        arr[edge[1]][edge[0]] = 1;
    }
    
    for (int v=0; v< max+1; v++){
        System.out.println(("visitied:" +Arrays.toString(visited)));
      if (!visited[v]){
        count ++;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        
        while(!queue.isEmpty()){
          int f = queue.poll();
          for(int i=0; i<arr.length;i++){
            if(arr[f][i]==1 && !visited[i]){
              queue.add(i);
              visited[i] = true;
            }
          }
        }
      }
    }
    return count;  
	} 
    public static void main(String[] args) {
        System.out.println(connectedVertices(new int[][]{
            {0, 1},
            {2, 3},
            {4, 5},
        }));
    }
}
