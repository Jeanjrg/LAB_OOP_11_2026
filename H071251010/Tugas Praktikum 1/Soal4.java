import java.util.Scanner;
import java.math.BigInteger;

public class Soal4 {

    public static BigInteger faktorial(BigInteger n) {

        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }

        return n.multiply(faktorial(n.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Input: ");
            int angka = input.nextInt();

            if (angka < 0) {
                System.out.println("Tidak boleh bilangan negatif");
                return;
            }

            BigInteger n = BigInteger.valueOf(angka);

            BigInteger hasil = faktorial(n);

            System.out.println("Output: " + hasil);

        } catch (Exception e) {
            System.out.println("Input harus berupa angka");
        }
    }
}