package baekjoon.hashMap;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hashMap9375 {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n;i++){

            int m = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hm = new HashMap<>();
            for (int j=0; j<m;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                st.nextToken();
                String s = st.nextToken();

                hm.put(s, hm.get(s)+1);
            }

            int c = 1;
            /* 
            옷을 고르는 조합은 
            옷의 종류별로 '고르지 않음'을 포함하여 하나씩 고르는 것
            이후 경우의 수에서 '모두 고르지 않음'을 뺌
            */
            for (int x: hm.values()){
                c *=(x+1);
            }
            System.out.println(c-1);
        }
    }
}