package daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class d28 {
    public static void main(String[] args) {
        boolean output = balancedBrackets("");
        System.out.println(output);
    }
    public static boolean balancedBrackets(String str) {
    // TODO:
    HashMap<String, String> hashMap = new HashMap<>();
    hashMap.put(")", "(");
    hashMap.put("}", "{");
    hashMap.put("]", "[");

    String[] strArr = str.split("");
    Stack<String> stack = new Stack<>();
    if (strArr.length==0) return true;
    if (strArr.length%2==1) return false;

    for (int i=0; i<strArr.length;i++){
      String s = strArr[i];
      if (!hashMap.containsKey(s)) stack.add(s);
      else if(stack.isEmpty()) return false;
      else {
        String target = stack.pop();
        if (!hashMap.get(s).equals(target)) return false;
      }
    }
    System.out.println(stack.size());
    if (stack.isEmpty()) return true;
    return false;
	} 
    
}
