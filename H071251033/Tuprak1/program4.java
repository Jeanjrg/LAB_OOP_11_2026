package H071251033.Tuprak1;

import java.util.Scanner;

public class program4 {
    public static int faktorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * faktorial(n - 1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan angka: ");
        int n = input.nextInt();

        System.out.println("Hasil: " + faktorial(n));
    }
}
