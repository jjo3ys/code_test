package baekjoon.greedy;

import java.util.Scanner;

public class g1459 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt();
        long y = sc.nextInt();
        long w = sc.nextInt();
        long s = sc.nextInt();
        
        long max = Math.max(x,y);
        long min = Math.min(x,y);

        long answer = 0;
        if(2*w<s) answer = (x+y)*w;
        else if(w>s) {
            answer = max*s;
            if ((x+y)%2!=0) answer += w-s;
        } else{
            answer = min*s+(max-min)*w;
        }
        System.out.println(answer);
    }
}
