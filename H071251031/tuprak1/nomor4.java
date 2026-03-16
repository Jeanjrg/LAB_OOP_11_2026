package tuprak1;

import java.util.Scanner;

public class nomor4 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        System.out.print("Input : ");
        int n = a.nextInt();

        int hasil = hitungFaktorial(n);
        System.out.println("Output : " + hasil);

        a.close();
    }

    public static int hitungFaktorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }else if (n < 0) {
            return 0;
        } else {
            return n * hitungFaktorial(n - 1);
        }
    }
}
