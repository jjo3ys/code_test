import java.util.Arrays;
public class d11 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeExtremes(new String[]{"where", "is", "the", "longest", "word"})));
    }
    public static String[] removeExtremes(String[] arr) {
        // TODO:
    int min = 0;
    int max = 0;
    for (int i=0; i<arr.length;i++){
        if(arr[i].length()<=arr[min].length()){
            min = i;
        }
        else if(arr[i].length()>=arr[max].length()){
            max = i;
        }
    }
    String[] result = new String[arr.length-2];
    int id = 0;
	for (int i=0; i<arr.length; i++){
		if (i != min && i != max){
			result[id] = arr[i];
            id ++;
		}
	}
	return result;
    } 
}
