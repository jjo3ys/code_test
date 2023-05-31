package coplit.mathematical;

import java.util.*;

public class m5 { 
	public static String[] rps = {"rock", "paper", "scissors"};

	public static void main(String[] args) {
    // TODO:
        int n = 1;
		ArrayList<String[]> result = new ArrayList<>();
		String[] arr = new String[n];
		// boolean[][] visited = new boolean[rounds][3];
        result = dfs(result, arr, 0, n);
		for (int i=0; i<result.size(); i++){
            System.out.println(Arrays.toString(result.get(i)));
        }
    }

	public static ArrayList<String[]> dfs(ArrayList<String[]> result, String[] arr, int i, int rounds) {
		if (i == rounds) {
			result.add(arr.clone());
			return result;
		}
		for (int y=0; y<3; y++){
            arr[i] = rps[y];           
            result = dfs(result, arr, i+1, rounds);
        }
		return result;
    }
}
