package daily;

import java.util.Arrays;

public class d36 {
    public static void main(String[] args) {
        int[] arr = insertionSort(new int[]{1,2,43,100,21});
        System.out.println(Arrays.toString(arr));
    }
    public static int[] insertionSort(int[] arr) {
		// TODO:
		for (int i=1; i<arr.length; i++){
			int target = arr[i];
			int j = i-1;
			while(j>=0 && target<arr[j]){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = target;	
            	
		}
		return arr;
	}
    
}
