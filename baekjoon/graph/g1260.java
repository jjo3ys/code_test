package baekjoon.graph;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class g1260 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken())-1;
        int[][] arr = new int[n][n];
        int p_n, c_n;
        for (int i=0; i<m;i++){
            st = new StringTokenizer(sc.nextLine());
            p_n = Integer.parseInt(st.nextToken())-1;
            c_n = Integer.parseInt(st.nextToken())-1;
            arr[p_n][c_n] = 1;
            arr[c_n][p_n] = 1;
        }

        boolean[] visited = new boolean[n];
        ArrayList<String> dfsList = dfs(arr, v, visited, new ArrayList<String>());
        System.out.println(String.join(" ", dfsList));

        visited = new boolean[n];
        ArrayList<String> bfsList = bfs(arr, v, visited, new ArrayList<String>());
        System.out.println(String.join(" ", bfsList));
    }
    public static ArrayList<String> dfs(int[][] arr, int index, boolean[] visited, ArrayList<String> result){
        if (visited[index]) return result;
        visited[index] = true;
        result.add(String.valueOf(index+1));
        for (int i=0; i<arr.length; i++){
            if (arr[index][i] == 1){
                result = dfs(arr, i, visited, result);
            }            
        }
        return result;
    }

    public static ArrayList<String> bfs(int[][] arr, int index, boolean[] visited, ArrayList<String> result){
        Queue<Integer> queue = new LinkedList<>();
        visited[index] = true;
        queue.add(index);
        result.add(String.valueOf(index+1));
        while (!queue.isEmpty()){
            int vertex = queue.poll();
            for (int i=0; i<arr.length; i++){
                if (arr[vertex][i]==1 && !visited[i]){
                    visited[i] = true;
                    result.add(String.valueOf(i+1));
                    queue.add(i);
                }
            }
        }
        return result;
    }
}
