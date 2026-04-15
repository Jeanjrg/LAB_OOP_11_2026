package tuprak1;

import java.util.Scanner;

public class nomor1 {

    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);
    
        System.out.println("Masukkan judul film: ");
        String judul = x.nextLine();

        String[] kata = judul.split(" ");

        String hasil = "";

        x.close();

        for (int i = 0; i < kata.length; i++) {
        String pertama = kata[i].substring(0,1).toUpperCase();
        String sisa = kata[i].substring(1).toLowerCase();
        hasil += pertama + sisa + " ";
        }
        
        System.out.println(hasil.trim());

    }
}
