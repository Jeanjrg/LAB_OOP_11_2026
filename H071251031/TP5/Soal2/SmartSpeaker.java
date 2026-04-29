package TP5.Soal2;

class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Speaker memutar musik dan menerima perintah.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Speaker terhubung ke WiFi.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Memproses perintah: " + perintah);
    }
}