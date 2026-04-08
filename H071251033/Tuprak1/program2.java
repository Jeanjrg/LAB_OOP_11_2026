package H071251033.Tuprak1;

import java.util.Scanner;

public class program2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Tanggal (dd-mm-yy: ");
        String tgl = input.nextLine();

        String[] bagian = tgl.split("-");
        int hari = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        int tahun = Integer.parseInt(bagian[2]);

        String[] namaBulan = {
            "Januari", " Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        if (tahun >= 50) {
            tahun += 1900;
        } else {
            tahun += 2000;
        }

        System.out.println(hari + " " + namaBulan[bulan - 1] + " " + tahun);
    }
}
