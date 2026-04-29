package TP5.Soal2;

abstract class PerangkatElektronik {
    protected String merk;
    protected int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    // Abstract method
    public abstract void cekFungsi();

    // Method konkrit
    public void infoPower() {
        System.out.println("Perangkat menyedot daya sebesar " + dayaListrik + " Watt");
    }
}