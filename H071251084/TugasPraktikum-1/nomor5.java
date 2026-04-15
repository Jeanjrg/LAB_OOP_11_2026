import java.util.Scanner;

public class nomor5 {
    public static void main(String[] args) {
        Scanner dezz = new Scanner(System.in);

        int[][] number = {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };

        try {
            System.out.println("Input angka: ");
            int dicari = dezz.nextInt();

            boolean ditemukan = false;

            for (int i = 0; i < number.length; i++) {
                for (int j = 0; j < number[i].length; j++) {
                    if (number[i][j] == dicari) {
                        System.out.println("Found " + dicari + " at [" + i + "][" + j + "]");
                        ditemukan = true;
                        break;
                    }
                }
                if (ditemukan) {
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("Angka " + dicari + " tidak ditemukan didalam array");
            }

        } catch (Exception e) {
            System.out.println("Input tidak valid, harap masukkan input berupa angka!");
        }
    }
}