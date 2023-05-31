package baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class g5014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int s = sc.nextInt();
        int g = sc.nextInt();
        int u = sc.nextInt();
        int d = sc.nextInt();
        if (s==g) {
            System.out.println(0);
            return;
        }
        int[] elevator = new int[f+1];
        Queue<Integer> queue = new LinkedList<>();
        elevator[s] = 1;
        queue.add(s);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int next:new int[]{cur+u, cur-d}){
                if (next>f || next <=0) continue;
                if (elevator[next] != 0) continue;
                if (next==g){
                    System.out.println(elevator[cur]);
                    return;
                }
                elevator[next] = elevator[cur] +1;
                queue.add(next);
            }
        }
        System.out.println("use the stairs");
    }
}
