package TP5.Soal1;

public class Main {
    public static void main(String[] args) {

        // Karyawan Tetap
        KaryawanTetap kt = new KaryawanTetap("Ali", "KT01", 5000000, 20000);

        // Absen beberapa kali
        for (int i = 0; i < 22; i++) {
            kt.absen();
        }

        double gajiTetap = kt.hitungGaji(1000000); // dengan bonus
        System.out.println("Gaji Karyawan Tetap: Rp " + gajiTetap);

        // Karyawan Kontrak
        KaryawanKontrak kk = new KaryawanKontrak("Ilmi", "KK01", 150000);

        // Absen lebih dari 20 kali
        for (int i = 0; i < 25; i++) {
            kk.absen();
        }

        double gajiKontrak = kk.hitungGaji();
        System.out.println("Gaji Karyawan Kontrak: Rp " + gajiKontrak);
    }
}