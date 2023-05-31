package baekjoon.stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class s1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int next = 0;
        sc.nextLine();

        while (n-- >0){
            int t = sc.nextInt();
            if (next < t){
                for (int i=next+1; i<=t;i++){
                    stack.push(i);
                    sb.append("+\n");
                }
                next = t;
                stack.pop();
                sb.append("-\n");
            } else {          
                if (stack.isEmpty()|| stack.peek()<t) {
                    sb = new StringBuilder("NO");
                    break;
                }
                while (!stack.isEmpty() && stack.peek()>=t){
                    stack.pop();
                    sb.append("-\n");
                }    
            }   
        }
        System.out.println(sb);  
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(sc.nextLine());
        int curNum = 1;
        for (int i = 0; i < n; i++) {
            int findNum = Integer.parseInt(sc.nextLine());

            while (curNum <= findNum) {
                stack.push(curNum);
                curNum++;
                sb.append("+\n");
            }

            if (findNum == stack.peek()) {
                stack.pop();
                sb.append("-\n");
            }
        }

        System.out.print(stack.size() == 0 ? sb : "NO");
    }
}
