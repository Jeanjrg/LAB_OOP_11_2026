package H071251033.Tuprak4.Nomor2;

public class Kamera extends Produk {
    int resolusi;
    String tipe;

    public Kamera(String merek, String nomorSeri, double harga, int resolusi, String tipe) {
        super(merek, nomorSeri, harga);
        this.resolusi = resolusi;
        this.tipe = tipe;
    }

    public void tampil() {
        super.tampil();
        System.out.println("Resolusi: " + resolusi + " MP");
        System.out.println("Tipe: " + tipe);
    }
}