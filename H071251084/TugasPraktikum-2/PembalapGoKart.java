public class PembalapGoKart {
    String nama;
    int stamina;
    MobilGoKart kendaraan;

    // Constructor yang default
    public PembalapGoKart() {
        this.nama = "Rookie";
        this.stamina = 100;
        this.kendaraan = new MobilGoKart("Standard Kart", 60);
    }
    // yang dengan parameter
    public PembalapGoKart(String nama, int stamina, MobilGoKart kendaraan) {
        this.nama = nama;
        this.stamina = stamina;
        this.kendaraan = kendaraan;
    }
    // berinteraksi dengan atribut objek sendiri
    public void tuneUpMobil(int tambahanSpeed) {
        System.out.println(nama + " memodifikasi mesin mobilnya untuk balapan berikutnya.");
        this.kendaraan.kecepatanMaksimal += tambahanSpeed; 
        this.stamina -= 10; // Modifikasi mesin butuh stamina
        System.out.println(nama + " berhasil memodifikasi mesin! Kecepatan naik menjadi " + this.kendaraan.kecepatanMaksimal);
    }
    // berinteraksi antar objek dari class yang sama
    public void salipLawan(PembalapGoKart lawan) {
        System.out.println(this.nama + " mencoba menyalip " + lawan.nama + "!");
        
        if (this.kendaraan.kecepatanMaksimal > lawan.kendaraan.kecepatanMaksimal) {
            System.out.println("Hasil: " + this.nama + " berhasil memimpin!");
            lawan.stamina -= 20; // Stamina lawan turun karena tertekan
        } else {
            System.out.println("Hasil: " + lawan.nama + " terlalu cepat untuk disalip!");
            this.stamina -= 15;
        }
    }

    // Method untuk menentukan pemenang balapan
    public void balapanLawan(PembalapGoKart lawan) {
        System.out.println("\n=== " + this.nama + " VS " + lawan.nama + " ===");
        
        int skorSaya = this.kendaraan.kecepatanMaksimal + 20;
        int skorLawan = lawan.kendaraan.kecepatanMaksimal + 20;

        if (skorSaya > skorLawan) {
            System.out.println("HASIL: " + this.nama + " MENANG! (Skor: " + skorSaya + " vs " + skorLawan + ")");
        } else if (skorLawan > skorSaya) {
            System.out.println("HASIL: " + lawan.nama + " MENANG! (Skor: " + skorLawan + " vs " + skorSaya + ")");
        } else {
            System.out.println("HASIL: Balapan Seri! Skor sama-sama " + skorSaya);
        }
        System.out.println("==============================================");
    }

    public void tampilkanStatus() {
        System.out.println("--- Status Pembalap ---");
        System.out.println("Nama    : " + nama);
        System.out.println("Stamina : " + stamina);
        kendaraan.tampilkanInfoMobil();
        System.out.println("-----------------------");
    }
}