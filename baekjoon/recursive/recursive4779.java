package baekjoon.recursive;
import java.util.Scanner;
import java.lang.Math;

public class recursive4779 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                int n = sc.nextInt();
                String result = kan((int) Math.pow(3, n));
                System.out.println(result);
            } catch(Exception e){
                break;
            }
        }
    }
    public static String kan(int n){
        if (n==1) return "-";
        return kan(n/3) + " ".repeat(n/3) + kan(n/3);
    }
}
