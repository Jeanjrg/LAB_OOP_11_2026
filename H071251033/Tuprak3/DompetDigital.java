package H071251033.Tuprak3;

public class DompetDigital {

    private double saldo;
    private String pin;
    protected String idNasabah;

    String namaAplikasi = "E-WalletKu"; 

    public DompetDigital(String idNasabah, String pin) {
        this.idNasabah = idNasabah;
        this.pin = pin;
        this.saldo = 0;
    }

    public String getIdNasabah() {
        return idNasabah;
    }
    public double getSaldo() {
        return saldo;
    }

    public void ubahPin(String pinLama, String pinBaru) {
        if (!this.pin.equals(pinLama)) {
            System.out.println("Gagal: PIN lama salah!");
            logTransaksi("Gagal ubah PIN (PIN lama salah)");
        } else if (pinBaru.length() != 6) {
            System.out.println("Gagal: PIN baru harus 6 digit!");
            logTransaksi("Gagal ubah PIN (format salah)");
        } else {
            this.pin = pinBaru;
            System.out.println("PIN berhasil diubah.");
            logTransaksi("Berhasil ubah PIN");
        }
    }

    public void setor(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Gagal: Nominal tidak valid!");
            logTransaksi("Gagal setor");
        } else {
            saldo += jumlah;
            System.out.println("Setor berhasil: " + jumlah);
            logTransaksi("Berhasil setor");
        }
    }

    public void tarik(double jumlah, String pinInput) {
        if (!this.pin.equals(pinInput)) {
            System.out.println("Gagal: PIN salah!");
            logTransaksi("Gagal tarik (PIN salah)");
        } else if (jumlah > saldo) {
            System.out.println("Gagal: Saldo tidak cukup!");
            logTransaksi("Gagal tarik (saldo kurang)");
        } else if (jumlah <= 0) {
            System.out.println("Gagal: Nominal tidak valid!");
            logTransaksi("Gagal tarik (nominal salah)");
        } else {
            saldo -= jumlah;
            System.out.println("Tarik berhasil: " + jumlah);
            logTransaksi("Berhasil tarik");
        }
    }

    private void logTransaksi(String pesan) {
        System.out.println("[LOG] " + pesan);
    }
}