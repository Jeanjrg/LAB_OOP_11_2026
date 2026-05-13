package H071251033.Tuprak4.Nomor2;

public class Laptop extends Produk {
    int ram;
    String processor;

    public Laptop(String merek, String nomorSeri, double harga, int ram, String processor) {
        super(merek, nomorSeri, harga);
        this.ram = ram;
        this.processor = processor;
    }

    public void tampil() {
        super.tampil();
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Processor: " + processor);
    }
}