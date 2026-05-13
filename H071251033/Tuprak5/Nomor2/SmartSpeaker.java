package H071251033.Tuprak5.Nomor2;

public class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, double dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Fungsi SmartSpeaker: Asisten suara dan pemutar musik.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Smart Speaker mencari koneksi...");
        System.out.println("Berhasil terhubung ke WiFi.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Memproses perintah suara: " + perintah);
    }
}