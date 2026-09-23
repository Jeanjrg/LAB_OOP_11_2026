public class Product {
    String namaProduk;
    int nomorSeri;
    double harga;

    public Product(String namaProduk, int nomorSeri, double harga) {
        this.namaProduk = namaProduk; this.nomorSeri = nomorSeri; this.harga = harga;
    }

    public void displayInfo() {
        System.out.println("Nama Produk : " + this.namaProduk);
        System.out.println("Nomor Seri : " + this.nomorSeri);
        System.out.println("Harga : $" + this.harga);
    }
}

class Smartphone extends Product {
    double ukuranLayar;
    int penyimpanan;

    public Smartphone(String namaProduk, int nomorSeri, double harga, double ukuranLayar, int penyimpanan) {
        super(namaProduk, nomorSeri, harga);
        this.ukuranLayar = ukuranLayar; this.penyimpanan = penyimpanan;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Ukuran Layar : " + this.ukuranLayar + " inches");
        System.out.println("Penyimpanan : " + this.penyimpanan + "GB");
    }
}

class Camera extends Product {
    int resolusi;
    String tipeLensa;

    public Camera(String namaProduk, int nomorSeri, double harga, int resolusi, String tipeLensa) {
        super(namaProduk, nomorSeri, harga);
        this.resolusi = resolusi; this.tipeLensa = tipeLensa;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Resolusi : " + this.resolusi + "MP");
        System.out.println("Tipe Lensa : " + this.tipeLensa);
    }
}

class Laptop extends Product {
    int ram;
    String prosesor;

    public Laptop(String namaProduk, int nomorSeri, double harga, int ram, String prosesor) {
        super(namaProduk, nomorSeri, harga);
        this.ram = ram; this.prosesor = prosesor;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("RAM : " + this.ram + "GB");
        System.out.println("Prosesor : " + this.prosesor);
    }
}