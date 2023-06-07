package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top{
    int index;
    int height;
    Top(int index, int height){
        this.index = index;
        this.height = height;
    }
}

public class s2493 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Top> stack = new Stack<>();
        int target;
        
        for(int i=0;i<n;i++){
            target = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()&&stack.peek().height<target){
                stack.pop();
            }
            if (stack.isEmpty()) System.out.print("0 ");
            else System.out.print(stack.peek().index+" ");
            stack.push(new Top(i+1, target));       
        }
    }
}
