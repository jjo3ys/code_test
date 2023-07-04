package baekjoon.greedy;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class g1202 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<Jewel> jewelList = new ArrayList<>();
        for(int i=0; i<N; i++){
            int m = sc.nextInt();
            int v = sc.nextInt();
            jewelList.add(new Jewel(m, v));
        }
        ArrayList<Integer> bagList = new ArrayList<>();
        for(int i=0; i<K; i++) bagList.add(sc.nextInt());
        
        Collections.sort(jewelList);
        Collections.sort(bagList);
        
        PriorityQueue<Jewel> pqueue = new PriorityQueue<>((j1, j2) -> j2.v-j1.v);
        long sum = 0;
        for (int i=0, j=0; i<K; i++){
            int w = bagList.get(i);
            while(j<N && jewelList.get(j).m <=w){
                Jewel jewel = jewelList.get(j);
                pqueue.add(jewel);
                j++;
            }
            if(!pqueue.isEmpty()) sum += pqueue.poll().v;
        }
        System.out.println(sum);
    }
}

class Jewel implements Comparable<Jewel>{
    int m;
    int v;
    public Jewel(int m, int v){
        this.m = m;
        this.v = v;
    }

    @Override
    public int compareTo(Jewel jewel) {
        if (m < jewel.m) return -1;
        if (m > jewel.m) return 1;
        return 0;
    }
}