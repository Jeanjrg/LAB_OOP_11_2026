public class main {
    public static void main(String[] args) {
        // Objek mobil
        MobilGoKart mobilMario = new MobilGoKart("B Dasher", 80);
        MobilGoKart mobilBowser = new MobilGoKart("Badwagon", 75);

        // Objek pembalap
        PembalapGoKart p1 = new  PembalapGoKart("Mario", 100, mobilMario);
        PembalapGoKart p2 = new  PembalapGoKart("Bowser", 100, mobilBowser);

        // Eksekusi
        p1.tampilkanStatus();
        p2.tampilkanStatus();

        p1.salipLawan(p2);
        p1.balapanLawan(p2);
        p2.tuneUpMobil(20); 
        
        p1.tampilkanStatus();
        p2.tampilkanStatus();

        p2.salipLawan(p1);
        p1.balapanLawan(p2);
        
    }
}