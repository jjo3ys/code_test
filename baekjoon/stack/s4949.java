package baekjoon.stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class s4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character>stack;
        char[] ca;
        String s;
        boolean a;

        while (!(s = sc.nextLine()).equals(".")){
            stack = new Stack<>();
            ca = s.toCharArray();
            a = true;
            for (char c:ca){
                if (c =='(' || c=='[') stack.push(c);

                else if (c==')' || c==']'){
                    if (stack.isEmpty()){
                        a = false;
                        break;
                    }
                    else if (c ==')' && stack.peek()=='(') stack.pop();
                    else if (c==']' && stack.peek()=='[') stack.pop();
                    else {
                        a = false;
                        break;
                    }
                }
            }
            if (a && stack.size()==0) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
