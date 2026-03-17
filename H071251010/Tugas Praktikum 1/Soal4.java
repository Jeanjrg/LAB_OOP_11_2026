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

        System.out.print("Input: ");
        int angka = input.nextInt();

        BigInteger n = BigInteger.valueOf(angka);

        BigInteger hasil = faktorial(n);

        System.out.println("Output: " + hasil);
    }
}