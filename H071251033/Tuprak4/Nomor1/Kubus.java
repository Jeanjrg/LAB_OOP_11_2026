package H071251033.Tuprak4.Nomor1;

public class Kubus extends BangunRuang {
    double sisi;

    public Kubus(double sisi) {
        super("Kubus");
        this.sisi = sisi;
    }

    public double hitungVolume() {
        return sisi * sisi * sisi;
    }

    public double hitungLuasPermukaan() {
        return 6 * sisi * sisi;
    }
}