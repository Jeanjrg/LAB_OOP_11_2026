public class Main {
    public static void main(String[] args) {
        // Menggunakan constructor default
        KantongAjaib kantongDoraemon = new KantongAjaib();
        
        // Menggunakan constructor dengan parameter
        AlatAjaib pintuKeManaSaja = new AlatAjaib("Pintu Ke Mana Saja", 80);
        KantongAjaib kantongDorami = new KantongAjaib("Dorami", 50, pintuKeManaSaja);

        kantongDoraemon.cekIsiKantong();
        kantongDorami.cekIsiKantong();

        kantongDorami.memberiEnergi(kantongDoraemon); // Interaksi antar objek
        kantongDoraemon.memberiEnergi(kantongDorami);        
    }
}