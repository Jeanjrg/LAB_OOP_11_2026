package H071251033.Tuprak4.Nomor2;

public class Produk {
    protected String merek;
    protected String nomorSeri;
    protected double harga;

    public Produk(String merek, String nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    public String getNomorSeri() {
        return nomorSeri;
    }

    public void tampil() {
        System.out.println("Merek: " + merek);
        System.out.println("No Seri: " + nomorSeri);
        System.out.println("Harga: " + harga);
    }
}