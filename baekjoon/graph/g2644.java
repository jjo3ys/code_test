package baekjoon.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class g2644 {
    static ArrayList<ArrayList<Integer>> family;
    static boolean[] visited;
    static ArrayList<Integer> cntlist = new ArrayList<>();
    static int n, t1, t2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        String[] target = sc.nextLine().split(" ");
        t1 = Integer.parseInt(target[0])-1;
        t2 = Integer.parseInt(target[1])-1;
        int m = Integer.parseInt(sc.nextLine());
        family = new ArrayList<>();
        visited = new boolean[n];
        for (int i=0; i<n;i++){
            family.add(new ArrayList<Integer>());
        }
        while (m-- >0){
            String[] s = sc.nextLine().split(" ");
            int m1 = Integer.parseInt(s[0])-1;
            int m2 = Integer.parseInt(s[1])-1;
            family.get(m1).add(m2);
            family.get(m2).add(m1);
        }
        dfs(t1, 0);
        System.out.println(cntlist.stream().mapToInt(x->x).min().orElse(-1));
    }
    public static void dfs(int v, int count){
        if (v==t2){
            cntlist.add(count);
            return;
        }
        for (int i:family.get(v)){
            if (!visited[i]){
                visited[i] = true;
                dfs(i, count+1);
            }
        }
        return;
    }
}
