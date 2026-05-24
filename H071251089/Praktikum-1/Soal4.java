import java.util.Scanner;

public class Soal4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int angka = input.nextInt();

            if (angka >= 0) {
                int hasil = factorial(angka);

                System.out.println(hasil);
            } else {
                System.out.println("Pastikan input angka >= 0");
            }
        } catch (Exception e) {
            System.out.println("Pastikan yang anda masukkan adalah angka");
        } finally {
            input.close();
        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}