package H071251033.Tuprak5.Nomor2;

public abstract class PerangkatElektronik {
    protected String merk;
    protected double dayaListrik;

    public PerangkatElektronik(String merk, double dayaListrik) {
        this.merk = merk; 
        this.dayaListrik = dayaListrik; 
    }

    public abstract void cekFungsi();

    public void infoPower() {
        System.out.println(merk + " sedang menyedot daya sebesar " + dayaListrik + " Watt.");
    }
}