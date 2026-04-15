class DompetDigital {
    protected int id;
    String username;
    private String pin;
    private double saldo;
    protected String phoneNumber;

    // public DompetDigital(double saldo) {
    //     this.saldo = 0;
    // }
    public DompetDigital(int id, String username, String pin, double saldo, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.pin = pin;
        this.saldo = 0;
        this.phoneNumber = phoneNumber;
    }

    private void logTransaksi(String pesan) {
        System.out.println("[Pesan] : " + pesan);
    }

    // get identitas
    public String getName() {
        return username;
    }

    // get Pin
    public String getPin() {
        return pin;
    }

    public double getSaldo() {
        return saldo;
    }

    // set pin dengan validasi
    public void setPin(String pinLama, String pinBaru) {
        if (this.pin.equals(pinLama)) {
            if (pinBaru.length() != 6) {
                logTransaksi("PIN harus tepat 6 digit");
            }else {
                this.pin = pinBaru;
                logTransaksi("PIN berhasil diubah");
            }
        }else {
            logTransaksi("PIN salah");
        }
    }

    // method setor tunai 
    private void setorTunai(double nominal) {
        if (nominal > 0){
            saldo += nominal;
            logTransaksi("Setor tunai berhasil sebesar " + nominal);
        }else {
            logTransaksi("Nominal Error");
        }
    }

    public void narikSetoran (double nominal){
        setorTunai(nominal);
    }

    // method tarik tunai dengan validasi pin dan mengecek apakah saldo cukup sebelum uang ditarik
    public void tarikTunai(String pin, double nominal) {
        if (pin.equals(this.pin)) {
            if (saldo >= nominal) {
                saldo -= nominal;
                logTransaksi("Tarik tunai berhasil sebesar " + nominal);
            }else {
                logTransaksi("Saldo tidak mencukupi");
            }
        }else {
            logTransaksi("PIN salah");
        }
    }
}