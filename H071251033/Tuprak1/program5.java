package H071251033.Tuprak1;

import java.util.Scanner;

public class program5 {
    public static void main(String[] args) {
        
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Scanner input = new Scanner(System.in);

        try { 
            System.out.println("Masukkan angka yang dicari: ");
            int cari = input.nextInt();
            
            boolean ditemukan = false;
            
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++){
                    if (nums[i][j] == cari) {
                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                        ditemukan = true;
                        break;
                    }
                }
                if (ditemukan) break;
            }

            if (!ditemukan) {
                System.out.println("Angka tidak ditemukan");
            }

        } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
        }
    
    }    
}
