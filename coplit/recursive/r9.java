package coplit.recursive;

import java.util.Arrays;

public class r9 {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString({1, 2}));
    }
    // static public int[] take(int num, int[] arr){
    //     if (num==0 || arr.length == 0) return new int[]{};
    //     if (num >= arr.length) return arr;
    //     return take(num, Arrays.copyOfRange(arr, 0, arr.length-1));
    //   } 

    static public int[] take2(int num, int[] arr){
        System.out.println("arr : " + Arrays.toString(arr));
        if (num==0 || arr.length == 0) return new int[]{};
        if (num >= 4) return arr;

        int[] temp = take2(num-1, Arrays.copyOfRange(arr, 1, arr.length));
        System.out.println("num : " + num + " temp : " + Arrays.toString(temp));
        int[] takedArr = new int[temp.length+1];
        System.arraycopy(temp, 0, takedArr, 1, temp.length);
        takedArr[0] = 1;
        System.out.println("takedArr : "+ Arrays.toString(takedArr));
        return takedArr;
      } 
}
