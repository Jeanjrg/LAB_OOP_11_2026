class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {
    public SmartSpeaker(String merk, int daya) {
        super(merk, daya);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Mengecek kualitas audio...");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println(merk + " terhubung ke jaringan.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Memproses perintah suara: " + perintah);
    }
}