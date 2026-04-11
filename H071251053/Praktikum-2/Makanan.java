public class Makanan {
    String menu;
    int harga;

    public Makanan() {}

    public Makanan(String menu, int harga){
        this.menu = menu;
        this.harga = harga;
    }

    void tampilkanMakanan() {
        System.out.println("Menu\t: " + menu + " (Rp." + harga + ")");
    }
}
