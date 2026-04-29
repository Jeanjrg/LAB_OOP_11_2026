package TP5.Soal1;

abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran;

    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    public void absen() {
        jumlahKehadiran++;
    }

    // Getter
    public int getJumlahKehadiran() {
        return jumlahKehadiran;
    }

    public String getNama() {
        return nama;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public abstract double hitungGaji();
}