package baekjoon.greedy;
import java.util.Scanner;
import java.util.Arrays;

public class g17420 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i=0; i<2; i++){
            for (int j=0; j<N; j++){
                arr[j][i] = sc.nextInt();
            }
        }
        Arrays.sort(arr, (a1, a2)->{
            if (a1[1]==a2[1]) return a1[0]-a2[0];
            return a1[1]-a2[1];
        });
        int count = 0;
        int M = arr[0][1];
        int cM = 0;

        for (int i=0; i<N;i++){
            if(M > arr[i][0]){
                if(M <arr[i][1]) M = arr[i][1];

                int t = (M-arr[i][0]+29)/30;
                arr[i][0] += t*30;
                count += t;
            }
            cM = Math.max(cM, arr[i][0]);

        }

        System.out.println(count);
    }
}
class Ticket implements Comparable<Ticket>{
    int a;
    int b;
    public Ticket(int a){
        this.a = a;
    }
    public void setB(int b){
        this.b = b;
    }
    @Override
    public int compareTo(Ticket ticket){
        if (a > ticket.a) return 1;
        if (a < ticket.a) return -1;
        return 0;
    }
}