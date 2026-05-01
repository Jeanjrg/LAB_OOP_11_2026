public class MainPenggajian {
    public static void main(String[] args) {
        
        KaryawanTetap ttp = new KaryawanTetap("Tanto", "H071251010", 10500000, 100000);
        ttp.absen(); 
        ttp.absen();
        
        System.out.println("Karyawan: " + ttp.getNama() + " [" + ttp.getIdKaryawan() + "]");
        System.out.println("Gaji Tetap: " + ttp.hitungGaji(2000000)); 
        System.out.println();

        KaryawanKontrak ktr = new KaryawanKontrak("Kak Jean", "H071241010", 550000);
        for(int i = 0; i < 21; i++) { ktr.absen(); }
        
        System.out.println("Karyawan: " + ktr.getNama() + " [" + ktr.getIdKaryawan() + "]");
        System.out.println("Gaji Kontrak: " + ktr.hitungGaji());
    }
}