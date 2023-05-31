package coplit.stack;
import java.util.*;

public class s3 {
    public static void main(String[] args) {
        browserStack(new String[]{"B", "-1", "B", "A", "C", "-1", "-1", "D", "-1", "1", "E", "-1", "-1", "1"}, "A");
    }
    public static void browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();
        
        current.push(start);

        for (String s:actions){
          if (s.equals("-1")){
            if (prevStack.isEmpty()) continue;
            if (!current.isEmpty()) nextStack.push(current.pop());
            current.push(prevStack.pop());
          }
          else if (s.equals("1")){
            if (nextStack.isEmpty()) continue;
            if (!current.isEmpty()) prevStack.push(current.pop());
            current.push(nextStack.pop());
          }
          else {
            if (!current.isEmpty()) prevStack.push(current.pop());
            current.push(s);
            nextStack.clear();
          }
        }
        result.add(prevStack);
        result.add(current);
        result.add(nextStack);
        
        System.out.println(result.toString());
        } 
}
