package daily;

import java.util.Arrays;

public class d35 {
    public static void main(String[] args) {
        int[] out = quickSort(new int[]{3,1,21, 14, 15, 10, 9, 100, 120, 123, 111, 1090, 124});
        System.out.println(Arrays.toString(out));
    }
    public static int[] quickSort(int[] arr) {
        return quick2(arr, 0, arr.length-1);
        
	}
    public static int[] quick(int[] arr, int s, int e){//느림
        if (s>=e) return arr;
        int pivot = arr[s];
        
        for(int i=s+1; i<=e; i++){
            int temp = arr[i];
            if (temp<pivot){
                arr[i] = pivot;
                arr[s++] = temp;
            }
        }
        arr = quick(arr, 0, s);
        arr = quick(arr, s+1, e);
        return arr;
    }

    public static int[] quick2(int[] arr, int s, int e){
        if (s>=e) return arr;
        int m = getM(arr, s, e);
        if(s<m-1) arr = quick2(arr, s, m-1);
        if(e>m) arr = quick2(arr, m, e);
        return arr;
    }

    public static int getM(int[]arr, int l, int r){
        int pivot = arr[(l+r)/2];
        while(l <= r){
            while (arr[l]<pivot) l++;
            while (arr[r]>pivot) r--;
            if (l <= r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
        return l;
    }
}
