public class Main {
    
    public static void main(String[] args) {
        KaryawanTetap tetap = new KaryawanTetap("Andi", "Kar001", 3000000, 50000);

        tetap.absen();
        tetap.absen();
        tetap.absen();
        tetap.absen();
        tetap.absen();

        System.out.println("\n=== DATA KARYAWAN TETAP ===");
        System.out.println("Nama\t\t\t: " + tetap.getNama());
        System.out.println("Total Kehadiran\t\t: " + tetap.getJumlahKehadiran() + " hari.");
        System.out.println("Total Gaji (+ Bonus)\t: Rp." + tetap.hitungGaji(1000000));

        KaryawanKontrak kontrak = new KaryawanKontrak("Lana", "KKar033", 1500000);

        kontrak.absen(); kontrak.absen(); kontrak.absen(); kontrak.absen(); kontrak.absen();
        kontrak.absen(); kontrak.absen(); kontrak.absen(); kontrak.absen(); kontrak.absen();
        kontrak.absen(); kontrak.absen(); kontrak.absen(); kontrak.absen(); kontrak.absen();
        kontrak.absen(); kontrak.absen(); kontrak.absen(); kontrak.absen(); kontrak.absen();
        kontrak.absen(); kontrak.absen();

        System.out.println("\n=== DATA KARYAWAN KONTRAK ===");
        System.out.println("Nama\t\t: " + kontrak.getNama());
        System.out.println("Total Kehadiran\t: " + kontrak.getJumlahKehadiran() + " hari.");
        System.out.println("Total Gaji\t: Rp." + kontrak.hitungGaji());
    }
}
