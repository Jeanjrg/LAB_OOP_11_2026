abstract class AbstractPerangkatElektronik {
    String merk;
    int dayaListrik;

    public AbstractPerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    public abstract void cekFungsi();

    public void infoPower() {
        System.out.println("Perangkat merk " + merk + " sedang mengisi daya sebesar " + dayaListrik + "Watt.");
    }
}