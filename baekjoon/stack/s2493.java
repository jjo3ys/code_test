package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class s2493 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stack = new Stack<>();
        int target;
        int count;
        
        for(int i=0;i<n;i++){
            target = Integer.parseInt(st.nextToken());
            count = 0;
            while(!stack.isEmpty()&&stack.peek()<=target){
                stack.pop();
                count++;
            }
            if (stack.isEmpty()) System.out.print("0 ");
            else System.out.print(i-count+" ");
            stack.push(target);       
        }
    }
}
