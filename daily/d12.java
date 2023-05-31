package daily;
import java.util.Arrays;
public class d12 {
    public static void main(String[] args) {
        int[] output = reverseArr(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(output));
    }
    public static int[] reverseArr(int[] arr){
		// 금지된 문자열은 주석까지 확인합니다.
    // TODO:
		if (arr.length<=1) return arr;
		int[] answer = new int[arr.length];
		int[] subArr = new int[arr.length-1];
		System.arraycopy(arr, 0, subArr, 0, subArr.length);
		System.arraycopy(arr, arr.length-1, answer, 0, 1);
		System.arraycopy(reverseArr(subArr), 0, answer, 1, answer.length-1);
		return answer;
	} 
}
