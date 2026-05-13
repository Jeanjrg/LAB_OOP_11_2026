package H071251033.Tuprak4.Nomor2;

public class Smartphone extends Produk {
    double ukuranLayar;
    int storage;

    public Smartphone(String merek, String nomorSeri, double harga, double ukuranLayar, int storage) {
        super(merek, nomorSeri, harga);
        this.ukuranLayar = ukuranLayar;
        this.storage = storage;
    }

    public void tampil() {
        super.tampil();
        System.out.println("Ukuran Layar: " + ukuranLayar + " inch");
        System.out.println("Storage: " + storage + " GB");
    }
}