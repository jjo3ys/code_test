package coplit.mathematical;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
public class m7 {
  public static void main(String[] args) {
    System.out.println(
      boringBlackjack(new int[]{1,2,3,4, 5}));
  }
  public static boolean isPrime(int n){
    for (int i=2; i<((int) Math.sqrt(n))+1; i++){
      if (n%i==0) return false;
      }
      return true;
    }
    public static int boringBlackjack(int[] cards) {
    // TODO:
    ArrayList<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[cards.length];
    dfs(result, new int[3], visited, cards, 0, 3);
    int cnt = 0;
    for (int i=0; i<result.size(); i++){
      if (isPrime(result.get(i))) cnt++;
    }
    return cnt;
  } 
  public static void dfs(ArrayList<Integer> result, int[] arr, boolean[] visited, int[] cards, int start, int r){
    if (r == 0){
      int sum=0;
      for (int i: arr) sum +=i;
      result.add(sum);
      return;
    }
    for (int i=start; i<cards.length; i++){
        visited[i] = true;
        arr[3-r] = cards[i];
        dfs(result, arr, visited, cards,i+1, r-1);
        visited[i] = false;
    }
  }
}
