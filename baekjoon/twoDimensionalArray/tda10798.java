package baekjoon.twoDimensionalArray;

import java.util.Arrays;
import java.io.*;
import java.util.StringTokenizer;

public class tda10798 {
    public static void main(String[] args) throws IOException {
        int[][] strArr = new int[100][100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for (int a=x;a<x+10;a++){
                for (int b=y;b<y+10;b++){
                    strArr[a][b] = 1;
                }
            }
        }
        System.out.println(Arrays.stream(strArr)
        .flatMapToInt(Arrays::stream)
        .filter(x->x==1)
        .count());
    }
}
