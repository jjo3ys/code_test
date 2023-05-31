package coplit.mathematical;
import java.util.ArrayList;

public class m8 {
    public static void main(String[] args) {
        divideChocolateStick(8, 10);
    }
    public static ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        // TODO:
        ArrayList<Integer[]> result = new ArrayList<>();
        long GCD = gcd(M, N);
        System.out.println(GCD);
        for (int i=1; i<=GCD; i++){
          if (GCD%i == 0){
            System.out.println("i: "+i+" m: "+M/i+" n:"+N/i);
            result.add(new Integer[]{i, M/i, N/i});
          }
        }
        return result;
        } 
    public static long gcd(int m, int n){
        while (n >0){
          int tmp = m;
          m = n;
          n = tmp%n;
        }
        return m;
    }
}
