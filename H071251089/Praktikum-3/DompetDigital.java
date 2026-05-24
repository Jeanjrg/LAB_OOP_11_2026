public class DompetDigital {
    private String pin;
    private double saldo;
    protected String idNasabah;
    String namaAplikasi;

    public DompetDigital(String pin, String idNasabah) {
        this.pin = pin;
        this.saldo = 0;
        this.idNasabah = idNasabah;
        this.namaAplikasi = "Fintech Rayyan E- Wallet ";
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    public double getSisaSaldo() {
        return saldo;
    }

    public void setPinBaru(String masukkanPin,String pinBaru) {
        if (masukkanPin.length() != 6) {
            logSistem("Gagal : (Panjang PIN harus tepat 6 karakter).");
        } else if (this.pin.equals(masukkanPin)) {
            this.pin = pinBaru;
            logSistem("Berhasil : PIN telah diubah.");
        } else {
            logSistem("Gagal  : Verifikasi PIN salah untuk diubah.");
        }
    }

    public void setorTunai(double setorTunai) {
        if (setorTunai >= 0) {
            this.saldo += setorTunai;
            logSistem("Berhasil : Setor Tunai sebesar Rp" + setorTunai);
        } else {
            logSistem("Gagal : Nilai Tunai tidak valid.");
        }
    }
    
    public void tarikTunai(String masukkanPin, double tarikTunai) {
        if (!this.pin.equals(masukkanPin)) {
            logSistem("Gagal  : PIN salah untuk Tarik Tunai.");
        } else if (saldo < tarikTunai) {
            logSistem("Gagal : Saldo tidak cukup untuk Tarik Tunai.");
        } else {
            this.saldo -= tarikTunai;
            logSistem("Berhasil : Tarik Tunai sebesar Rp" + tarikTunai);
        }
    }

    private void logSistem(String pesan) {
        System.out.println("[LOG SISTEM] " + pesan);
    }
}