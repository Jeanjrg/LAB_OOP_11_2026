import java.util.Scanner;

public class Soal5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        try {
            int num = input.nextInt();

            boolean diTemukan = false;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (num == nums[i][j]) {
                        System.out.println("Found " + num + " at [" + i + "][" + j + "]");
                        diTemukan = true;
                        break;
                    }
                }

                if (diTemukan) {
                    break;
                }
            }

            if (!diTemukan) {
                System.out.println(num + " Tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Pastikan yang anda masukkan adalah angka");
        } finally {
            input.close();
        }
    }
}