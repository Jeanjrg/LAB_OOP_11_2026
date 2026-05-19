class SmartCCTV extends AbstractPerangkatElektronik implements IInteraksiInternet {

    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }
    
    @Override
    public void cekFungsi() {
        System.out.println("Fungsi: Melakukan pengawasan keamanan.");
    }

    @Override
    public void hubungkanWifi() {
        System.out.println("Mengirim data ke server.");
    }
}
