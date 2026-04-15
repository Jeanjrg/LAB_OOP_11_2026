
import java.util.Scanner;

public class no4 {
    public static int faktorial(int n) {
        if (n==1) return 1;
        return n * faktorial(n-1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("input: ");
        int n = input.nextInt();
        System.out.println("output: " + faktorial(n));
    }
}
