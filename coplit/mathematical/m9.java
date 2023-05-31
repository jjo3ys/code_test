package coplit.mathematical;
import java.util.*;

public class m9 {
    public static void main(String[] args) {
        missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup"});
    }
    public static ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        // TODO:
        ArrayList<String[]> result = new ArrayList<>();
        boolean visited[] = new boolean[sideDishes.length];
        result.add(new String[]{});
        Arrays.sort(sideDishes);
        for (int i = sideDishes.length; i>0; i--){
            comb(result, visited, sideDishes, i, 0);
        }
        result.sort((o1, o2) -> Arrays.toString(o1).compareTo(Arrays.toString(o2)));
        for (int i=0; i<result.size(); i++){
            System.out.println(Arrays.toString(result.get(i)));
        }
        return result;
        } 
      public static void comb(ArrayList<String[]> result, boolean[] visited, String[] sideDishes, int r, int start){
        if (r==0){
          ArrayList<String> tmp = new ArrayList<>();
          for (int i=0; i<sideDishes.length; i++){
            if (visited[i]) tmp.add(sideDishes[i]);
          }
          result.add(tmp.toArray(new String[0]));
          return;
        }
        for (int i=start; i<sideDishes.length; i++){
          visited[i] = true;
          comb(result, visited, sideDishes, r-1, i+1);
          visited[i] = false;
        }
      }
}
