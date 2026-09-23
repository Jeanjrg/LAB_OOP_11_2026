class SmartLamp extends AbstractPerangkatElektronik implements IKontrolSuara {

    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Fungsi: Memberikan pencahayaan pintar.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("Nyala")) {
            System.out.println("Lampu berpijar!");
        } else {
            System.out.println("Perintah suara tidak dikenali.");
        }
    }
}
