class DompetDigital {

    private String pin;
    private double saldo;

    protected String idNasabah;

    String jenisAkun;

    public DompetDigital(String idNasabah, String pinAwal) {
        this.idNasabah = idNasabah;
        this.pin = pinAwal;
        this.saldo = 0;
        this.jenisAkun = "Prioritas";
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    public double getSaldo() {
        return saldo;
    }

    public void transfer(double jumlah) {
        setor(jumlah);
    }

    public void ubahPin(String pinLama, String pinBaru) {

        if (!this.pin.equals(pinLama)) {
            System.out.println("Perubahan PIN gagal: PIN lama tidak sesuai.");
        } 
        else if (pinBaru.length() != 6) {
            System.out.println("Perubahan PIN gagal: PIN harus terdiri dari 6 digit.");
        } 
        else {
            this.pin = pinBaru;
            System.out.println("PIN berhasil diperbarui.");
        }
    }

    

    private void setor(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Setor gagal: jumlah tidak valid.");
            tampilPesan("SETOR", "GAGAL", "Jumlah tidak valid");
        } else {
            saldo += jumlah;
            System.out.println("Setor berhasil: Rp" + (int) jumlah);
            tampilPesan("SETOR", "BERHASIL", "Rp" + (int) jumlah);
        }
    }

    public void tarik(double jumlah, String inputPin) {

        if (!this.pin.equals(inputPin)) {
            System.out.println("Tarik tunai gagal: PIN tidak sesuai.");
            tampilPesan("TARIK", "GAGAL", "PIN salah");
        } 
        else if (jumlah > saldo) {
            System.out.println("Tarik tunai gagal: saldo tidak mencukupi.");
            tampilPesan("TARIK", "GAGAL", "Saldo tidak cukup");
        } 
        else {
            saldo -= jumlah;
            System.out.println("Tarik tunai berhasil: Rp" + (int) jumlah);
            tampilPesan("TARIK", "BERHASIL", "Rp" + (int) jumlah);
        }
    }

    private void tampilPesan(String jenis, String status, String keterangan) {
        System.out.println("[" + jenis + "] " + status + " - " + keterangan);
    }
}