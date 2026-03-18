import java.util.Scanner;

public class TP1_4 {

    public static int faktorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } 
        else {
            return n * faktorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int n = a.nextInt();

        int hasil = faktorial(n);

        System.out.println("Hasil faktorial dari " + n + " adalah: " + hasil);
        a.close();
    }
}

    
    
