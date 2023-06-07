package baekjoon.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.lang.Math;
class XY{
    int x, y;
    boolean visited;
    XY(int x, int y){
        this.x = x;
        this.y = y;
        this.visited = false;
    }
}
public class g9205 {
    static int n, tx, ty;
    static XY[] xy;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            n = sc.nextInt();

            xy = new XY[n+1];
            for (int i=0; i<n+1; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                xy[i] = new XY(x, y);
            }
            tx =sc.nextInt();
            ty =sc.nextInt();
            if(bfs()) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    public static boolean bfs(){
        Queue<XY> queue = new LinkedList<>();
        queue.add(xy[0]);
        xy[0].visited = true;
        while(!queue.isEmpty()){
            XY cxy = queue.poll();
            if (checkD(tx, ty, cxy.x, cxy.y)) return true;
            for (int i=1; i<n+1; i++){
                XY nxy = xy[i];
                if (!nxy.visited && checkD(cxy.x, cxy.y, nxy.x, nxy.y)){
                    nxy.visited = true;
                    queue.add(nxy);
                }
            }
        }
        return false;
    }

    public static boolean checkD(int cx, int cy, int nx, int ny){
        if(Math.abs(cx-nx)+Math.abs(cy-ny) <= 1000) return true;
        return false;
    }
}
