package baekjoon.hashMap;
import java.util.*;
public class hashMap11652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Long,Integer> hm = new HashMap<>();
        int max = 0;
        long answer = (long) Math.pow(2, 62);
        for (int i=0;i<n;i++){
            long key = sc.nextLong();
            hm.put(key, hm.getOrDefault(key, 0)+1);
            if (hm.get(key)>max) {
                max=hm.get(key);
                answer = key;
            } else if (hm.get(key)==max){
                answer = Math.min(answer, key);
            }
        }
        System.out.println(answer);
    }
}
