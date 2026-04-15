public class DompetDigital{
    private String pin;    
    private double saldo;  // atribut private

    protected String idNasabah;  // atribut protected

    String mataUang = "IDR";  // atribut default

    public DompetDigital(String idNasabah, String pin) { // constructor 
        this.idNasabah = idNasabah;
        this.pin = pin;
        this.saldo = 0;
        catatanLog("Akun berhasil dibuat.");
    }

    // method getter
    public String getIdNasabah() {
        return idNasabah;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getMataUang() {
        return mataUang;
    }

    // method setter
    public boolean setPin(String pinLama, String pinBaru) {
        if (!this.pin.equals(pinLama)) {
            catatanLog("Gagal mengubah PIN.");
            System.out.println("PIN lama salah!");
            return false;
        }

        if (pinBaru.length() != 6) {
            catatanLog("Gagal mengubah PIN.");
            System.out.println("Panjang pin harus terdiri dari 6 digit!");
            return false;
        }

        this.pin = pinBaru;
        catatanLog("PIN berhasil diubah.");
        return true;
    }

    // method transaksi
    private void setorTunai(double jumlah) {
        if (jumlah <= 0) {
            catatanLog("Setor tunai gagal.");
            System.out.println("Nominal tidak valid!");
            return;
        }

        saldo += jumlah;
        catatanLog("Setor tunai sebesar Rp." + jumlah);
        System.out.println("Setor tunai berhasil!");
    }

    public void getSetorTunai(double jumlah) {
        setorTunai(jumlah);
    }

    // method transaksi
    public void tarikTunai(double jumlah, String pinInput) {
        if (!this.pin.equals(pinInput)) {
            catatanLog("Tarik tunai gagal.");
            System.out.println("PIN salah!");
            return;
        }

        if (jumlah <= 0) {
            catatanLog("Tarik tunai gagal.");
            System.out.println("Nominal tidak valid!");
            return;
        }

        if (jumlah > saldo) {
            catatanLog("Tarik tunai gagal.");
            System.out.println("Saldo tidak mencukupi!");
            return;
        }

        saldo -= jumlah;
        catatanLog("Tarik tunai sebesar Rp." + jumlah);
        System.out.println("Tarik tunai berhasil!");
    }

    // method internal
    private void catatanLog(String pesan) {
        System.out.println("LOG: " + pesan);
    }
}