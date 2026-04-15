import java.util.Scanner;

public class Soal5 {

    public static void main(String[] args) {

        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Scanner input = new Scanner(System.in);

        try {

            System.out.print("Input: ");
            int cari = input.nextInt();

            boolean ketemu = false;

            int i = 0;

            while (i < nums.length && !ketemu) {

                int j = 0;

                while (j < nums[i].length) {

                    if (nums[i][j] == cari) {
                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                        ketemu = true;
                        break;
                    }

                    j++;
                }

                i++;
            }

            if (!ketemu) {
                System.out.println("Angka tidak ditemukan");
            }

        } catch (Exception e) {
            System.out.println("Input harus berupa angka");
        }
    }
}