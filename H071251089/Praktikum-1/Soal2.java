import java.util.Scanner;

public class Soal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            String tanggal = input.nextLine();

            String[] konvers = tanggal.split("-");
            int hari = Integer.parseInt(konvers[0]);
            int bulan = Integer.parseInt(konvers[1]);
            int tahun = Integer.parseInt(konvers[2]);

            if ((hari <= 0 || hari > 32) || (bulan <= 0 || bulan > 12)) {
                System.out.println("Hari dan/atau bulan tidak diketahui.");
            } else {
                String[] namaBulan = {
                    "Januari", "Februari", "Maret", "April",
                    "Mei", "Juni", "Juli", "Agustus",
                    "September", "Oktober", "November", "Desember"
                };

                if (tahun <= 50) {
                    tahun += 2000;
                } else {
                    tahun += 1900;
                }

                System.out.println(hari + " " + namaBulan[bulan - 1] + " " + tahun);
            }
        } catch (Exception e) {
            System.out.println("Pastikan input sebuah angka dan sesuai format inputan (DD-MM-YY)");
        } finally {
            input.close();
        }
    }
}