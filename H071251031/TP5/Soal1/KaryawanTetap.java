package TP5.Soal1;

class KaryawanTetap extends Karyawan {
    private double gajiPokok;
    private double tunjanganMakan;

    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
        super(nama, idKaryawan);

    if (gajiPokok < 0 || tunjanganMakan < 0) {
        throw new IllegalArgumentException("Gaji pokok dan tunjangan tidak boleh negatif!");
    }

        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
}

    // Override
    @Override
    public double hitungGaji() {
        return gajiPokok + (tunjanganMakan * getJumlahKehadiran());
}

    // Overloading
    public double hitungGaji(double bonusKinerja) {
        return hitungGaji() + bonusKinerja;
    }
}