package tuprak1;

import java.util.Scanner;

public class nomor5 {
    public static void main(String[] args) {
        Scanner b = new Scanner(System.in);
        
        int[][] nums = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};

        try {
            System.out.print("Input : ");
            int cari = b.nextInt();
            
            boolean ditemukan = false;

            pencarian: 
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == cari) {
                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                        ditemukan = true;
                        break pencarian;
                    }
                }
            }

            if (!ditemukan) {
                System.out.println("Angka " + cari + " tidak ditemukan.");
            }

        } catch (Exception e) {
            System.out.println("Error: Input harus berupa angka");
        } finally {
            b.close();
        }
    }
}