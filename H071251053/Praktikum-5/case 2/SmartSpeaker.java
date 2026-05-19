class SmartSpeaker extends AbstractPerangkatElektronik implements IInteraksiInternet, IKontrolSuara {

    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Fungsi: Memutar musik dan asisten digital.");
    }

    @Override
    public void hubungkanWifi() {
        System.out.println("SmartSpeaker terhubung ke cloud musik.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("SmartSpeaker memproses: " + perintah);
    }
}
