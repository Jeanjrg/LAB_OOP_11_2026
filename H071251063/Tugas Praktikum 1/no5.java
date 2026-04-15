import java.util.Scanner;

public class no5 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };

            System.out.print("input: ");
            int cari = input.nextInt();

            boolean found = false;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {

                    if (nums[i][j] == cari) {
                        System.out.println("found " + cari + " at [" + i + "][" + j + "]");
                        found = true;
                        break; 
                    }
                }
                if (found) {
                    break; 
                }
            }

            if (!found) {
                System.out.println("angka tidak ditemukan");
            }

        } catch (Exception e) {
            System.out.println("input harus berupa angka!");
        }
    }
}