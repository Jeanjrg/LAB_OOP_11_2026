class Topping {
    String namaTopping;
    int hargaTambahan;

    // Constructor default
    Topping() {
        namaTopping = "Original";
        hargaTambahan = 0;
    }

    // Constructor parameter
    Topping(String namaTopping, int hargaTambahan) {
        this.namaTopping = namaTopping;
        this.hargaTambahan = hargaTambahan;
    }

    void tampilTopping() {
        System.out.println("Topping: " + namaTopping + " (+" + hargaTambahan + ")");
    }
}
    
