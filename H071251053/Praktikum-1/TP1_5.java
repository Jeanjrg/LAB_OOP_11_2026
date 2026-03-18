import java.util.Scanner;

public class TP1_5 {
    
    public static void main(String[] args) {
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Scanner a = new Scanner(System.in);

        try {
            System.out.print("Masukkan angka: ");
            int angka = a.nextInt();

            boolean ketemu = false;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    
                    if (nums[i][j] == angka) {
                        System.out.println("Found " + angka + " at [" + i + "][" + j + "]");
                        ketemu = true;
                        break; 
                    }
                }
                if (ketemu) {
                    break; 
                }
            }

            if (!ketemu) {
                System.out.println("Angka tidak ditemukan");
            }

        } catch (Exception e) {
            System.out.println("Inputan harus berupa angka!");
        }
        a.close();
    }
}


