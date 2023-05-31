package baekjoon.stack;
import java.util.Scanner;
import java.util.Stack;
public class s10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int k = sc.nextInt();
        sc.nextLine();
        while (k-->0){
            int n = sc.nextInt();
            if (n==0) stack.pop();
            else stack.push(n);
        }
        System.out.println(stack.stream().reduce(0, Integer::sum));
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int k = sc.nextInt(), sum=0, index=-1, n;
        int[] stack = new int[k];
        
        while (k-->0){
            n = sc.nextInt();
            if (n==0) sum -=stack[index--];
            else {
                sum += n;
                stack[++index] = n;
            }
        }
        System.out.println(sum);
    }
}
