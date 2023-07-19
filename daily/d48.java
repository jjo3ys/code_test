package daily;
import java.util.*;

public class d48{
    public static void main(String[] args) {
        int output = subsetSum(new int[]{1, 2, 3, 4, 5}, 12);
        System.out.println(output);
    }
    public static int subsetSum(int[] set, int bound) {

		Arrays.sort(set);
		if (set[0] > bound) return 0;
		int sum = 0;
		for (int i=0; i<set.length; i++){
			if (set[i] <bound){
                System.out.println("f: "+set[i]);

                int t = dfs(set, 0, i,  new boolean[set.length], bound);
                System.out.println("t: "+t);
				sum = Math.max(t, sum);
			}
		}
		return sum;
	}
	public static int dfs(int[] set, int sum, int index, boolean[] visited, int bound){
		if (index>=set.length || set[index]+sum > bound) return sum;
        int max = 0;
		for (int i=index; i<set.length; i++){
			if (!visited[i] && set[i]+sum<=bound){
				visited[i] = true;
				max = Math.max(dfs(set, sum+set[i], i+1, visited, bound), max);
				visited[i] = false;
			}
		}
		return max;
	}
}