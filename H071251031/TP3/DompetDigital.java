package TP3;

public class DompetDigital {

    // ==================== ATRIBUT ====================
    private double saldo;
    private String pin;
    protected String idNasabah;
    String statusAkun;

    // ==================== CONSTRUCTOR ====================
    public DompetDigital(String idNasabah, String pinAwal) {
        this.idNasabah  = idNasabah;
        this.pin        = pinAwal;
        this.saldo      = 0;
        this.statusAkun = "AKTIF";
        catatLog("INFO", "Akun baru dibuat untuk ID: " + idNasabah);
    }

    // ==================== GETTER ====================
    public String getIdNasabah() { 
        return idNasabah; 
    }
    public double getSaldo() { 
        return saldo; 
    }
    public String getStatusAkun() { 
        return statusAkun; 
    }

    // ==================== SETTER ====================
    public void setPinBaru(String pinLama, String pinBaru) {
        if (!pinLama.equals(this.pin)) {
            System.out.println("[GAGAL] PIN lama yang dimasukkan salah.");
            catatLog("GAGAL", "Percobaan ubah PIN dengan PIN lama yang salah.");
            return;
        }
        if (pinBaru.length() != 6) {
            System.out.println("[GAGAL] PIN baru harus tepat 6 karakter.");
            catatLog("GAGAL", "PIN baru tidak memenuhi syarat panjang 6 karakter.");
            return;
        }
        this.pin = pinBaru;
        System.out.println("[BERHASIL] PIN berhasil diubah.");
        catatLog("INFO", "PIN berhasil diperbarui.");
    }

    // ==================== METODE TRANSAKSI ====================
    private void setorTunai(double nominal) {
        if (nominal <= 0) {
            System.out.println("[GAGAL] Nominal tidak boleh nol atau negatif.");
            catatLog("GAGAL", "Setor tunai nominal ilegal: " + nominal);
            return;
        }
        saldo += nominal;
        System.out.printf("[BERHASIL] Setor Rp%.0f berhasil. Saldo: Rp%.0f%n", nominal, saldo);
        catatLog("BERHASIL", "Setor Rp" + nominal + ". Saldo: Rp" + saldo);
    }

    public void tarikTunai(double nominal, String pinMasukan) {
        if (!pinMasukan.equals(this.pin)) {
            System.out.println("[GAGAL] PIN yang dimasukkan salah.");
            catatLog("GAGAL", "Tarik tunai dengan PIN salah.");
            return;
        }
        if (nominal <= 0) {
            System.out.println("[GAGAL] Nominal tidak boleh nol atau negatif.");
            catatLog("GAGAL", "Nominal tarik tidak valid: " + nominal);
            return;
        }
        if (nominal > saldo) {
            System.out.printf("[GAGAL] Saldo tidak mencukupi. Saldo Anda: Rp%.0f%n", saldo);
            catatLog("GAGAL", "Saldo tidak cukup untuk tarik Rp" + nominal);
            return;
        }
        saldo -= nominal;
        System.out.printf("[BERHASIL] Tarik Rp%.0f berhasil. Sisa saldo: Rp%.0f%n", nominal, saldo);
        catatLog("BERHASIL", "Tarik Rp" + nominal + ". Sisa saldo: Rp" + saldo);
    }

    // ==================== METODE INTERNAL ====================
    private void catatLog(String status, String pesan) {
        System.out.println("  [LOG - " + status + "] " + pesan);
    }

    public void setoran(double nominal){
        setorTunai(nominal);
    }
}

