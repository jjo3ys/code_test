package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class d31{
    public static void main(String[] args) {
        ArrayList<String> output = powerSet("jump");
        System.out.println(Arrays.toString(output.toArray(new String[0])));
    }
    public static ArrayList<String> powerSet(String str) {
		// 필드 변수를 사용하면 테스트가 정상적으로 작동하지 않습니다.
		// 메서드 내부에서 값을 저장하고 활용해주세요.
		// TODO:
    String[] arr = str.split("");
    Set<String> arrSet = new HashSet<String>(Arrays.asList(arr));
    arr = arrSet.toArray(new String[0]);
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));

    ArrayList<String> result = new ArrayList<>();
    ArrayList<String> visited = new ArrayList<>();
    for (int i=0; i<=arr.length; i++){
      result = reculsion(visited, arr, result, "", 0, arr.length, i);
      
    }
    
    Collections.sort(result);
    
    return result;
	}

    public static ArrayList<String> reculsion(ArrayList<String> visited, String[] arr, ArrayList<String> result, String t, int index, int n, int r){
        if (r==0){
            result.add(t);
            return result;
        }
        for (int i=index; i<n; i++){
            String temp = t;
            t += arr[i];
            result = reculsion(visited, arr, result, t, i+1, n, r-1);
            t = temp;
        }
        return result;
    }
}