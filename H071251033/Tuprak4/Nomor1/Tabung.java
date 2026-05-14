package H071251033.Tuprak4.Nomor1;

public class Tabung extends BangunRuang {
    double r, t;

    public Tabung(double r, double t) {
        super("Tabung");
        this.r = r;
        this.t = t;
    }

    public double hitungVolume() {
        return Math.PI * r * r * t;
    }

    public double hitungLuasPermukaan() {
        return 2 * Math.PI * r * (r + t);
    }
}