package H071251033.Tuprak4.Nomor1;

public class Trapesium extends BangunDatar {
    double atas, bawah, miring1, miring2, tinggi;

    public Trapesium(double atas, double bawah, double miring1, double miring2, double tinggi) {
        super("Trapesium");
        this.atas = atas;
        this.bawah = bawah;
        this.miring1 = miring1;
        this.miring2 = miring2;
        this.tinggi = tinggi;
    }

    public double hitungLuas() {
        return 0.5 * (atas + bawah) * tinggi;
    }

    public double hitungKeliling() {
        return atas + bawah + miring1 + miring2;
    }
}