package daily;

import java.util.HashMap;

public class d1 {
    public HashMap<String, String> transformFirstAndLast(String[] arr) {
        // TODO:
        HashMap<String, String> answer = new HashMap<String, String>();
        answer.put(arr[0], arr[arr.length-1]);
        return answer;
        } 
}
