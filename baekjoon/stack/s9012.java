package baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class s9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack;
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- >0){
            char[] s = sc.nextLine().toCharArray();
            stack = new Stack<>();
            boolean check = true;
            for (int i=0;i<s.length;i++){
                if (s[i] =='(') stack.push(1);
                else if (stack.isEmpty()) {
                    check = false;
                    break;
                } else stack.pop();
            }
            if (check && stack.size() ==0) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
