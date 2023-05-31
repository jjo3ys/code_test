package baekjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class studyWord1157 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] count = new int[alphabet.length()];
        for (String s:br.readLine().split("")){
            count[alphabet.indexOf(s.toUpperCase())] ++;
        }
        int max=0;
        int index=0;

        for (int i=0;i<count.length;i++) if(count[i]>max) {
            max=count[i];        
            index=i;
        }
        for (int i=index+1;i<alphabet.length();i++){
            if (count[i]==count[index]) {
                System.out.println("?");
                index = -1;
                break;
            }
        }
        if (index !=-1){
            System.out.println(alphabet.charAt(index));
        }

    }
}
