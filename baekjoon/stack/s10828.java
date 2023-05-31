package baekjoon.stack;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i=0;i<n;i++){
            String command =br.readLine();  
            if (command.equals("top")){
                if (stack.isEmpty()) sb.append(-1+"\n");
                else sb.append(stack.peek()+"\n");
            }
            else if (command.equals("size")){
                sb.append(stack.size()+"\n");
            }
            else if (command.equals("empty")){
                if (stack.isEmpty()) sb.append(1+"\n");
                else sb.append(0+"\n");
            }
            else if (command.equals("pop")){
                if (stack.isEmpty()) sb.append(-1+"\n");
                else sb.append(stack.pop()+"\n");
            }
            else {
                stack.push(Integer.parseInt(command.split(" ")[1]));
            }
        }
        System.out.println(sb);
    }
}
