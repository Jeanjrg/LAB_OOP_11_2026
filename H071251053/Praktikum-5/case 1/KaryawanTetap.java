class KaryawanTetap extends Karyawan {
    double gajiPokok;
    double tunjanganMakan;

    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    public double hitungGaji() {
        double totalGaji = gajiPokok + (tunjanganMakan * getJumlahKehadiran());
        return totalGaji;
    }

    public double hitungGaji(double bonusKinerja) {
        return this.hitungGaji() + bonusKinerja;
    }
}
