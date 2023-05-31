package baekjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ox8959 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N;i++){
            String s[] = br.readLine().split("");
            int score = 0;
            int acc = 0;
            for (int j=0; j<s.length; j++){
                if (s[j].equals("O")){
                    score += 1+acc;
                    acc ++;
                }
                else acc=0;
            }
            System.out.println(score);
        }
    }
    
}
