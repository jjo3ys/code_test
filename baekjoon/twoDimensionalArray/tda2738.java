package baekjoon.twoDimensionalArray;
import java.util.*;

public class tda2738 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int x=0; x<2; x++){
            for (int i = 0; i<n;i++){
                StringTokenizer st2 = new StringTokenizer(sc.nextLine());
                for(int j = 0; j<m;j++){
                    arr[i][j] += Integer.parseInt(st2.nextToken());
                }
            }
        }
        for (int i = 0; i<n;i++){
            for (int j = 0; j<m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}