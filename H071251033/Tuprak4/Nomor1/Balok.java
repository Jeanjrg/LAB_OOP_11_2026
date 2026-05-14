package H071251033.Tuprak4.Nomor1;

public class Balok extends BangunRuang {
    double p, l, t;

    public Balok(double p, double l, double t) {
        super("Balok");
        this.p = p;
        this.l = l;
        this.t = t;
    }

    public double hitungVolume() {
        return p * l * t;
    }

    public double hitungLuasPermukaan() {
        return 2 * (p*l + p*t + l*t);
    }
}