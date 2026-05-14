package H071251033.Tuprak4.Nomor1;

public class BangunRuang {
    protected String nama;

    public BangunRuang(String nama) {
        this.nama = nama;
    }

    public double hitungVolume() {
        return 0;
    }

    public double hitungLuasPermukaan() {
        return 0;
    }

    public void tampil() {
        System.out.println("\n" + nama);
        System.out.println("Volume: " + hitungVolume());
        System.out.println("Luas Permukaan: " + hitungLuasPermukaan());
    }
}