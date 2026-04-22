package TP4.Soal2;

public class Produk {
    protected String merek;
    protected int nomorSeri;
    protected double harga;

    public Produk(String merek, int nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    public int getNomorSeri() {
        return nomorSeri;
    }
    public void tampilInfo() {
        System.out.println("Merek        : " + merek);
        System.out.println("Nomor Seri   : " + nomorSeri);
        System.out.println("Harga        : Rp " + harga);
    }
}

class Smartphone extends Produk {
    private double ukuranLayar;
    private int storage;

    public Smartphone(String merek, int nomorSeri, double harga,
                      double ukuranLayar, int storage) {
        super(merek, nomorSeri, harga);
        this.ukuranLayar = ukuranLayar;
        this.storage = storage;
    }

    @Override
    public void tampilInfo() {
        System.out.println("\n=== Smartphone ===");
        super.tampilInfo();
        System.out.println("Ukuran Layar : " + ukuranLayar + " Inch");
        System.out.println("Storage      : " + storage + "GB");
    }
}

class Laptop extends Produk {
    private int ram;
    private String processor;

    public Laptop(String merek, int nomorSeri, double harga,
                  int ram, String processor) {
        super(merek, nomorSeri, harga);
        this.ram = ram;
        this.processor = processor;
    }

    @Override
    public void tampilInfo() {
        System.out.println("\n=== Laptop ===");
        super.tampilInfo();
        System.out.println("RAM          : " + ram + "GB");
        System.out.println("Processor    : " + processor);
    }
}

class Kamera extends Produk {
    private int resolusi;
    private String lensa;

    public Kamera(String merek, int nomorSeri, double harga,
                  int resolusi, String lensa) {
        super(merek, nomorSeri, harga);
        this.resolusi = resolusi;
        this.lensa = lensa;
    }

    @Override
    public void tampilInfo() {
        System.out.println("\n=== Kamera ===");
        super.tampilInfo();
        System.out.println("Resolusi     : " + resolusi + "MP");
        System.out.println("Tipe Lensa   : " + lensa);
    }
}