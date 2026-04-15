import java.util.Scanner;

public class Soal2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Input tanggal (dd-mm-yy): ");
            String tgl = input.nextLine();

            String[] bagian = tgl.split("-");

            if (bagian.length != 3) {
                System.out.println("Format harus dd-mm-yy");
                return;
            }

            int hari = Integer.parseInt(bagian[0]);
            int bulan = Integer.parseInt(bagian[1]);
            int tahun = Integer.parseInt(bagian[2]);

            int tahunLengkap;

            if (tahun <= 49) {
                tahunLengkap = 2000 + tahun;
            } else {
                tahunLengkap = 1900 + tahun;
            }

            String namaBulan;

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
                default: namaBulan = "Tidak diketahui";
            }

            System.out.println(hari + " " + namaBulan + " " + tahunLengkap);

        } catch (Exception e) {
            System.out.println("Input tidak valid");
        }
    }
}