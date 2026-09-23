public abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran;

    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    public void absen() {
        this.jumlahKehadiran++;
    }

    public int getJumlahKehadiran() {
        return this.jumlahKehadiran;
    }

    public String getNama() {
        return this.nama;
    }

    public abstract double hitungGaji(double bonusKinerja);
}

class KaryawanTetap extends Karyawan {
    private double gajiPokok;
    private double tunjanganMakan;

    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    public double hitungGaji(double bonusKinerja) {
        double totalGaji = gajiPokok + (tunjanganMakan * super.getJumlahKehadiran());
        return totalGaji + bonusKinerja;
    }
}

class KaryawanKontrak extends Karyawan {
    private double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    public double hitungGaji(double bonusKinerja) {
        double totalGaji = upahPerHari * super.getJumlahKehadiran();

        if (super.getJumlahKehadiran() > 20) {
            totalGaji += bonusKinerja;
        }

        return totalGaji;
    }
}