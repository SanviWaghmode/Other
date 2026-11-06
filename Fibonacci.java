import java.util.*;

public class Fibonacci{
    static int fibonacciRec(int n ){
        if(n<=1){
            return n;
        }

        return fibonacciRec(n-1) + fibonacciRec(n-2);
    }

    static int fibonacciIter(int n){
        if(n<=1){
            return n;
        }

        int a =0; 
        int b = 1;
        int c;

        for(int i = 2; i<=n ;i++){
            c= a+b;
            a= b;
            b=c;

        }
        return b;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci of " + n + " is: " + fibonacciRec(n));
        System.out.println("Fibonacci of " + n + " is: " + fibonacciIter(n));
    }
    
}