package H071251033.Tuprak4.Nomor1;

public class BangunDatar {
    protected String nama;

    public BangunDatar(String nama) {
        this.nama = nama;
    }

    public double hitungLuas() {
        return 0;
    }

    public double hitungKeliling() {
        return 0;
    }

    public void tampil() {
        System.out.println("\n" + nama);
        System.out.println("Luas: " + hitungLuas());
        System.out.println("Keliling: " + hitungKeliling());
    }
}