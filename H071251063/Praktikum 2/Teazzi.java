class Teazzi {
    String namaMinuman;
    int harga;
    Topping topping; // atribut objek

    // Constructor default
    Teazzi() {
        namaMinuman = "Teazzi Original";
        harga = 10000;
        topping = new Topping();
    }

    // Constructor parameter
    Teazzi(String namaMinuman, int harga, Topping topping) {
        this.namaMinuman = namaMinuman;
        this.harga = harga;
        this.topping = topping;
    }

    // Method 1
    void tampilInfo() {
        System.out.println("Minuman: " + namaMinuman);
        System.out.println("Harga: " + harga);
        topping.tampilTopping();
    }

    // Method 2 
    void bandingkan(Teazzi lain) {
        System.out.println("\nMembandingkan " + this.namaMinuman + " dengan " + lain.namaMinuman);

        int totalHarga1 = this.harga + this.topping.hargaTambahan;
        int totalHarga2 = lain.harga + lain.topping.hargaTambahan;

        if (totalHarga1 > totalHarga2) {
            System.out.println(this.namaMinuman + " lebih mahal");
        } else if (totalHarga1 < totalHarga2) {
            System.out.println(lain.namaMinuman + " lebih mahal");
        } else {
            System.out.println("Harga keduanya sama");
        }
    }
}