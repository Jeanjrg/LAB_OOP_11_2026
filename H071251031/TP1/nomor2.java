package tuprak1;

import java.util.Scanner;

public class nomor2 {
    public static void main(String[] args) {
        Scanner y = new Scanner(System.in);

        System.out.println("Masukkan tanggal (dd-mm-yy): ");
        String tanggal = y.nextLine();

        String[] pisah = tanggal.split("-");
        
        try {
            int hari = Integer.parseInt(pisah[0]);
            int bulan = Integer.parseInt(pisah[1]);
            int tahun = Integer.parseInt(pisah[2]);
            int tahunRill;
             if (tahun >= 0 && tahun <= 25) {
            tahunRill = 2000 + tahun;
        } else {
            tahunRill = 1900 + tahun;
        }

        String namaBulan = "";

        switch (bulan) {
            case 1: 
                namaBulan = "Januari"; 
                break;
            case 2: 
                namaBulan = "Februari"; 
                break;
            case 3: 
                namaBulan = "Maret"; 
                break;
            case 4: 
                namaBulan = "April"; 
                break;
            case 5: 
                namaBulan = "Mei"; 
                break;
            case 6: 
                namaBulan = "Juni"; 
                break;
            case 7: 
                namaBulan = "Juli"; 
                break;
            case 8: 
                namaBulan = "Agustus"; 
                break;
            case 9: 
                namaBulan = "September"; 
                break;
            case 10: 
                namaBulan = "Oktober"; 
                break;
            case 11: 
                namaBulan = "November"; 
                break;
            case 12: 
                namaBulan = "Desember"; 
                break;
            default :
                namaBulan = "Bulan tidak valid";
        }

        System.out.println(hari + " " + namaBulan + " " + tahunRill);
        } catch (Exception e) {
            System.out.println("eror");
        }

    
       

        y.close();

    }
}
