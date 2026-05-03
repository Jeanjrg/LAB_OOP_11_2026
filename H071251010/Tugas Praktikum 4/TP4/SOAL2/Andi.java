import java.util.ArrayList;
import java.util.Scanner;

//superclass produk
class Product {
    String brand;
    int seriesNumber;
    double price;

    public Product(String brand, int seriesNumber, double price) {
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Serial Number: " + seriesNumber);
        System.out.println("Price: $" + price);
    }
}

//subclass produk (smartphone, laptop, camera)
class Smartphone extends Product {
    double screenSize;
    int storageCapacity;

    public Smartphone(String brand, int seriesNumber, double price, double screenSize, int storageCapacity) {
        super(brand, seriesNumber, price); 
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Screen Size: " + screenSize + " inches");
        System.out.println("Storage Capacity: " + storageCapacity + "GB");
    }
}

class Laptop extends Product {
    int ramSize;
    String processorType;

    public Laptop(String brand, int seriesNumber, double price, int ramSize, String processorType) {
        super(brand, seriesNumber, price);
        this.ramSize = ramSize;
        this.processorType = processorType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Processor Type: " + processorType);
        System.out.println("RAM Size: " + ramSize + "GB");
    }
}

class Camera extends Product {
    int resolution;
    String lensType;

    public Camera(String brand, int seriesNumber, double price, int resolution, String lensType) {
        super(brand, seriesNumber, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Resolution: " + resolution + "MP");
        System.out.println("Lens Type: " + lensType);
    }
}

//main class
public class Andi {
    public static void main(String[] args) {
        ArrayList daftarStok = new ArrayList(); 
        Scanner input = new Scanner(System.in);
        int menuPilihan = 0;

        while (menuPilihan != 4) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("\n>>> Pilih menu (1-4): ");

            if (!input.hasNextInt()) {
                System.out.println("Error: Tolong masukkan angka saja!");
                input.next();
                continue;
            }

            menuPilihan = input.nextInt();
            input.nextLine(); 

            switch (menuPilihan) {
                case 1:
                    System.out.print("Masukkan nama produk: ");
                    String brand = input.nextLine();

                    System.out.print("Masukkan nomor seri: ");
                    int seriesNumber = input.nextInt();

                    System.out.print("Masukkan harga: ");
                    double price = input.nextDouble();

                    System.out.println("\nPilih tipe produk:");
                    System.out.println("1. Smartphone\n2. Laptop\n3. Camera");
                    System.out.print("Pilih tipe produk (1-3): ");
                    int tipePilihan = input.nextInt();
                    input.nextLine(); 

                    if (tipePilihan == 1) {
                        System.out.print("Masukkan ukuran layar (inci): ");
                        double screenSize = input.nextDouble();
                        System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                        int storageCapacity = input.nextInt();
                        
                        daftarStok.add(new Smartphone(brand, seriesNumber, price, screenSize, storageCapacity));

                    } else if (tipePilihan == 2) {
                        System.out.print("Masukkan ukuran RAM (GB): ");
                        int ramSize = input.nextInt();
                        input.nextLine();
                        System.out.print("Masukkan tipe prosesor: ");
                        String processorType = input.nextLine();
                        
                        daftarStok.add(new Laptop(brand, seriesNumber, price, ramSize, processorType));

                    } else if (tipePilihan == 3) {
                        System.out.print("Masukkan resolusi kamera (MP): ");
                        int resolution = input.nextInt();
                        input.nextLine();
                        System.out.print("Masukkan tipe lensa: ");
                        String lensType = input.nextLine();
                        
                        daftarStok.add(new Camera(brand, seriesNumber, price, resolution, lensType));
                    }
                    break;

                case 2:
                    System.out.println("\nDaftar Produk:");
                    if (daftarStok.isEmpty()) {
                        System.out.println("Stok kosong.");
                    } else {
                        for (int i = 0; i < daftarStok.size(); i++) {
                            Product p = (Product) daftarStok.get(i); 
                            p.displayInfo();
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
                    if (!input.hasNextInt()) {
                        System.out.println("Nomor seri harus angka!");
                        input.next();
                    } else {
                        int cari = input.nextInt();
                        boolean ditemukan = false;
                        for (int i = 0; i < daftarStok.size(); i++) {
                            Product p = (Product) daftarStok.get(i); 
                            if (p.seriesNumber == cari) {
                                System.out.println("Anda telah membeli produk:");
                                p.displayInfo();
                                daftarStok.remove(i);
                                ditemukan = true;
                                break;
                            }
                        }
                        if (!ditemukan) System.out.println("Produk tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    break;
            }
        }
        input.close();
    }
}