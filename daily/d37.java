package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class d37 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(radixSort(new int[]{1,2,43,100,21})));
    }
    public static int[] radixSort(int[] arr) {
		// TODO:
		int max = arr[0];
		int n = 1;
		for (int i=1; i<arr.length; i++){
			if(arr[i]>max) max = arr[i];
		}
		int len = String.format("%d", max).length();
		for (int l=1; l<=len; l++){
			ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
            for (int i=0; i<10; i++) arrList.add(new ArrayList<>());
			for (int i=0; i<arr.length; i++){
				int t = (arr[i]/n)%10;
				arrList.get(t).add(arr[i]);
			}
			arr = arrList.stream()
                        .flatMap(a -> a.stream())
                        .collect(Collectors.toList())
                        .stream()
                            .mapToInt(i->i)
                            .toArray();
            n*=10;
		}
		return arr;
	} 
}
