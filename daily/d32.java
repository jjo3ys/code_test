package daily;
import java.util.Arrays;
import java.util.stream.IntStream;

public class d32{
    public int orderOfPresentation(int N, int[] K) {
		// TODO:
		int count = 0;
		boolean[] visited = new boolean[N+1];
		for (int i=1; i<=N; i++){
			int j = i-1;
			visited[K[j]] = true;
            long c = IntStream
            .range(1, K[j])
            .filter(v -> !visited[v])
            .count();
            
			count += c*factorial(N-i);
		}
		return count;
	}
	public int factorial(int x){
		int t = 1;
		for (int i=2; i<=x; i++){
			t *=i;
		}
		return t;
	}
}