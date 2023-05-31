package baekjoon.hashMap;

import java.util.HashSet;
import java.util.Scanner;

public class hashMap11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder(sc.nextLine());
        HashSet<String> stringSet = new HashSet<>();
        
        for (int i=0; i<s.length(); i++){
            for (int j=i+1; j<s.length()+1;j++){
                String a = s.substring(i, j);
                System.out.println(a);
                stringSet.add(a);
            }
        }
        System.out.println(stringSet.size());
    }
}
