package H071251033.Tuprak5.Nomor1;

public class MainPenggajian {
    public static void main(String[] args) {
        // 1. Simulasi Karyawan Tetap
        KaryawanTetap kt = new KaryawanTetap("Andi", "T-001", 5000000, 50000);
        kt.absen();
        kt.absen();
        kt.absen();
        kt.absen();
        kt.absen();

        System.out.println("--- Data Karyawan Tetap ---");
        System.out.println("Nama: " + kt.getNama());
        System.out.println("Total Gaji (inc. bonus): Rp" + kt.hitungGaji(1000000));
        System.out.println();

        // 2. Simulasi Karyawan Kontrak
        KaryawanKontrak kk = new KaryawanKontrak("Budi", "K-002", 150000);
        // Melakukan absen lebih dari 20 kali (misal 22 kali)
        for (int i = 0; i < 22; i++) {
            kk.absen();
        }

        System.out.println("--- Data Karyawan Kontrak ---");
        System.out.println("Nama: " + kk.getNama());
        System.out.println("Kehadiran: " + 22 + " hari");
        System.out.println("Total Gaji: Rp" + kk.hitungGaji());
    }
}