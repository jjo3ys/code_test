package daily;

import java.util.Arrays;

public class d34 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6}};
        int[][] matrix = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        arr = rotateMatrix(arr, 3);
        for (int[] ar:arr){
            System.out.println(Arrays.toString(ar));
        }
    }
    public static int[][] rotateMatrix(int[][] matrix, int K) {
		// 필드 변수를 사용하면 테스트가 정상적으로 작동하지 않습니다.
		// 메서드 내부에서 값을 저장하고 활용해주세요.
		// TODO:
		if (matrix == null) return null;
		int N = matrix.length; 
		int M = matrix[0].length; 
        int[][] ans;
        
        if (K%2==0) ans = new int[N][M];
		else ans = new int[M][N];

        a: for (int i=0; i<ans.length; i++){
            for (int j=0; j<ans[0].length; j++){
                if (K%4==0) break a;
                else if (K%4==1) ans[i][j] = matrix[N-j-1][i];
                else if (K%4==2) ans[i][j] = matrix[N-i-1][M-j-1];
                else if (K%4==3) ans[i][j] = matrix[j][M-i-1];
            }
        }

		return ans;
  }
}
