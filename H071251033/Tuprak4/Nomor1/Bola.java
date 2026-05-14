package H071251033.Tuprak4.Nomor1;

public class Bola extends BangunRuang {
    double r;

    public Bola(double r) {
        super("Bola");
        this.r = r;
    }

    public double hitungVolume() {
        return (4.0/3.0) * Math.PI * Math.pow(r, 3);
    }

    public double hitungLuasPermukaan() {
        return 4 * Math.PI * r * r;
    }
}