package H071251033.Tuprak4.Nomor1;

public class Lingkaran extends BangunDatar {
    double r;

    public Lingkaran(double r) {
        super("Lingkaran");
        this.r = r;
    }

    public double hitungLuas() {
        return Math.PI * r * r;
    }

    public double hitungKeliling() {
        return 2 * Math.PI * r;
    }
}