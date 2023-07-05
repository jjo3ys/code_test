package daily;

import java.util.Arrays;

public class d38 {
    public static void main(String[] args) {
        int[] output = mergeSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output));
    }
    public static int[] mergeSort(int[] arr) {
		// TODO :
		if (arr.length <2) return arr;
		int m = arr.length/2;
		int rightlen = arr.length%2==0 ? m:m+1;
		int[] left = new int[m];
		int[] right = new int[rightlen];
		System.arraycopy(arr, 0, left, 0, m);
		System.arraycopy(arr, m, right, 0, rightlen);
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);
	}

	public static int[] merge(int[] left, int[] right){
		int[] sorted = new int[left.length+right.length];
		int i=0, l=0, r=0;
		while(l<left.length && r<right.length){
			if (left[l] < right[r]) sorted[i++] = left[l++];
			else sorted[i++] = right[r++];
		}
		while(r<right.length) sorted[i++] = right[r++];
		while(l<left.length) sorted[i++] = left[l++];
	
		return sorted;
	}
    
}
