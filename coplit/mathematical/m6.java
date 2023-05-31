package coplit.mathematical;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class m6 {
    static ArrayList<Integer> basket;
    public static void main(String[] args) {
        ArrayList<Integer[]> result = newChickenRecipe(new int[]{11, 1, 10, 1111111111, 10000}, 4);
        for (int i=0; i<result.size(); i++){
            System.out.println(Arrays.toString(result.get(i)));
        }
    }

    public static boolean checkStuff(String stuff){
		int cnt =0;
		for (int i=0; i<stuff.length();i++){
			if (stuff.charAt(i)=='0') cnt++;
		}
		if (cnt>=3) return false;
		return true;
	}
	public static ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
    // TODO:
		basket = new ArrayList<>();
		ArrayList<Integer[]> result = new ArrayList<>();
		for (int stuff:stuffArr){
			String s = String.valueOf(stuff);
			if (checkStuff(s)) basket.add(stuff);
		}
        boolean[] visited = new boolean[basket.size()];
        Collections.sort(basket);
		return dfs(result, new Integer[choiceNum], choiceNum, 0, visited);
	} 

	public static ArrayList<Integer[]> dfs(ArrayList<Integer[]> result, Integer[] arr, int choiceNum, int n, boolean[] visited){
		if (n == choiceNum){
			result.add(arr.clone());
			return result;
		}
		for (int i=0; i<basket.size();i++){
            if (!visited[i]){
                visited[i] = true;
                arr[n] = basket.get(i);
			    result = dfs(result, arr, choiceNum, n+1, visited);
                visited[i] = false;
            }
			
		}
		return result;
	}
}
