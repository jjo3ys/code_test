package baekjoon.twoDimensionalArray;

import java.util.Scanner;
import java.util.StringTokenizer;

public class tda2566 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 1;
        int y = 1;
        int max = 0;

        for (int i=1;i<=9;i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            for (int j=1;j<=9;j++){
                int t = Integer.parseInt(st.nextToken());
                if (t > max){
                    max = t;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max);
        System.out.println(x+" "+y);
    }
}
