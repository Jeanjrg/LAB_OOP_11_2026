import java.util.Scanner;

public class nomor4 {

    static int faktorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // kondisi dasar
        } else {
            return n * faktorial(n - 1); // rekursi
        }
    }
    

    public static void main(String[] args) {
        Scanner dezz = new Scanner(System.in);

        System.out.print("Input : ");
        int n = dezz.nextInt();

        int hasil = faktorial(n);

        System.out.println("Output : " + hasil);
    }
}