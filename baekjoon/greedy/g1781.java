package baekjoon.greedy;

import java.util.*;

public class g1781 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<P> arrayList = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0; i<N;i++){
            arrayList.add(new P(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(arrayList);
        for(P p:arrayList){
            queue.add(p.c);
            if(p.d<queue.size()) queue.poll();
        }
        long count =0;
        while(!queue.isEmpty()){
            count += queue.poll();
        }

        System.out.println(count);
    }
}

class P implements Comparable<P>{
    int d, c;
    public P(int d, int c){
        this.d = d;
        this.c = c;
    }
    @Override
    public int compareTo(P p){
        if(d==p.d) return p.c-c;
        return d-p.d;
    }
}
