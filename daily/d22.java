package daily;

import java.util.Arrays;

public class d22{
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3,10,5,4,1,2,4,5,19, 100, 200};
        for (int i=1; i<arr.length; i++){
            for (int j=0; j<arr.length-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        } 
        System.out.println(Arrays.toString(arr));
    }
}