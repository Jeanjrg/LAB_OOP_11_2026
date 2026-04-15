import java.util.Scanner;

public class nomor2 {
    public static void main(String[] args) {
        Scanner dezz = new Scanner(System.in);

        System.out.println("Masukkan tanggal(dd-mm-yy): ");
        String tanggal = dezz.nextLine();

        String[] bagian = tanggal.split("-");

        int hari = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        int tahun = Integer.parseInt(bagian[2]);
        
        if (tahun >= 0 && tahun <= 27) {
            tahun += 2000;
        }else {
            tahun += 1900;
        }

        String namaBulan = "";
        switch (bulan) {
            case 1: namaBulan = "Januari"; break;
            case 2: namaBulan = "Februari"; break;
            case 3: namaBulan = "Maret"; break;
            case 4: namaBulan = "April"; break;
            case 5: namaBulan = "Mei"; break;
            case 6: namaBulan = "Juni"; break;
            case 7: namaBulan = "Juli"; break;
            case 8: namaBulan = "Agustus"; break;
            case 9: namaBulan = "September"; break;
            case 10: namaBulan = "Oktober"; break;
            case 11: namaBulan = "November"; break;
            case 12: namaBulan = "Desember"; break;
            default: namaBulan = "Tidak Valid"; break;
        }

        System.out.println(hari + " " + namaBulan + " " + tahun);
    }
}