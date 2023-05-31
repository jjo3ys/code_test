import java.util.*;
public class d7 {
    public HashMap<String, String> convertListToHashMap(String[][] arr) {
        // TODO:
        HashMap<String, String> hasMap = new HashMap<>();
		if (arr.length==0 || arr[0].length==0) return hasMap;
		for (String[] array:arr){
			if (!hasMap.containsKey(array[0])) hasMap.put(array[0], array[1]);
		}
		return hasMap;
    } 
    public static ArrayList<Integer> dfs(int[][] array, boolean[] visited, int src, ArrayList<Integer> result) {
        // 이미 방문했다면
        if (visited[src] == true) {
               // 방문한 정점을 저장
            return result;      // 저장한 데이터를 반환하며, 재귀호출을 종료
        }

            // 아직 방문하지 않았다면
        result.add(src); 
        visited[src] = true;           // 방문한 정점을 표기

            // 현재 정점에서 이동할 수 있는 정점을 순회하며 재귀 호출
        for (int index = 0; index < array.length; index++) {
            if (array[src][index] == 1) {
                                // 재귀 호출을 통해, 방문 여부를 담은 데이터를 반환과 동시에 할당
                result = dfs(array, visited, index, result);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] array = {
            {0, 1, 0, 0, 0, 1, 1},
            {0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        ArrayList<Integer> arr;
        arr = dfs(array, new boolean[array.length], 0, new ArrayList<Integer>());
        System.out.println(Arrays.toString(arr.toArray()));
    }
}
