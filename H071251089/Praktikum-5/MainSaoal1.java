import java.util.Scanner;

public class MainSaoal1 {
    public static void main(String[] args) {
        Scanner np = new Scanner(System.in);

        KaryawanTetap kTetap1 = new KaryawanTetap("Galang", "9080", 5000000, 100000);
        KaryawanKontrak kKontrak1 = new KaryawanKontrak("Faisal", "1122", 150000);

        System.out.print("Jumlah Kehadiran " + kTetap1.getNama() + " (Karyawan Tetap) : "); int absenKTetap1 = np.nextInt();
        // untuk karyawan tetap
        for (int i = 1; i <= absenKTetap1; i++) {
            kTetap1.absen();
        }

        double gajiKTetap1 = kTetap1.hitungGaji(300000);
        System.out.println("Gaji Bersih Karyawan Tetap : Rp" + gajiKTetap1);


        System.out.println("----------------------------");


        System.out.print("Jumlah Kehadiran " + kKontrak1.getNama() + " (Karyawan Kontrak) : "); int absenKKontrak1 = np.nextInt();
        // untuk karyawan kontrak
        for (int i = 1; i <= absenKKontrak1; i++) {
            kKontrak1.absen();
        }

        double gajiKKontrak1= kKontrak1.hitungGaji(500000);
        System.out.println("Gaji Bersih Karyawan Kontrak : Rp" + gajiKKontrak1);
    }
}