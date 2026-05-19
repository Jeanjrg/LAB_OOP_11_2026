import java.util.Scanner;

public class MainCase2 {
    
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        Smartphone[] stokHP = new Smartphone[50];
        Laptop[] stokLaptop = new Laptop[50];
        Camera[] stokKamera = new Camera[50];
        
        int jumlahHP = 0;
        int jumlahLaptop = 0;
        int jumlahKamera = 0;
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("\n>>> Pilih menu (1-4): ");
            pilihan = a.nextInt();
            a.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Produk: ");
                    String brand = a.nextLine();
                    System.out.print("Masukkan Nomor Seri: ");
                    int sn = a.nextInt();
                    System.out.print("Masukkan Harga: ");
                    double harga = a.nextDouble();
                    System.out.println("\nPilih Tipe Produk: 1. Smartphone, 2. Laptop, 3. Camera");
                    int tipe = a.nextInt();

                    if (tipe == 1) {
                        System.out.print("\nMasukkan Ukuran Layar (inci): "); double screen = a.nextDouble();
                        System.out.print("Masukkan Kapasitas Penyimpanan (GB): "); int storage = a.nextInt();
                        stokHP[jumlahHP++] = new Smartphone(brand, sn, harga, screen, storage);
                    } else if (tipe == 2) {
                        System.out.print("\nMasukkan RAM: "); int ram = a.nextInt(); a.nextLine();
                        System.out.print("Masukkan Prosesor: "); String proc = a.nextLine();
                        stokLaptop[jumlahLaptop++] = new Laptop(brand, sn, harga, ram, proc);
                    } else if (tipe == 3) {
                        System.out.print("\nMasukkan Resolusi (MP): "); int res = a.nextInt(); a.nextLine();
                        System.out.print("Masukkan Tipe Lensa: "); String lens = a.nextLine();
                        stokKamera[jumlahKamera++] = new Camera(brand, sn, harga, res, lens);
                    }
                    break;

                case 2:
                    System.out.println("\n--- DAFTAR PRODUK ---");
                    for(int i=0; i<jumlahHP; i++) {
                        stokHP[i].displayInfoSmartphone();
                    }

                    for(int i=0; i<jumlahLaptop; i++) {
                        stokLaptop[i].displayInfoLaptop();
                    }
                    
                    for(int i=0; i<jumlahKamera; i++) {
                        stokKamera[i].displayInfoCamera();
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nomor seri yang ingin dibeli: ");
                    int cariSN = a.nextInt();
                    boolean ketemu = false;
                    
                    for (int i = 0; i < jumlahHP; i++) {
                        if (stokHP[i].seriesNumber == cariSN) {
                            stokHP[i].displayInfoSmartphone();
                            System.out.println("Berhasil dibeli!");
                            ketemu = true;
                        }
                    }

                    for (int i = 0; i < jumlahLaptop; i++) {
                        if (stokLaptop[i].seriesNumber == cariSN) {
                            stokLaptop[i].displayInfoLaptop();
                            System.out.println("Berhasil dibeli!");
                            ketemu = true;
                        }
                    }

                    for (int i = 0; i < jumlahKamera; i++) {
                        if (stokKamera[i].seriesNumber == cariSN) {
                            stokKamera[i].displayInfoCamera();
                            System.out.println("Berhasil dibeli!");
                            ketemu = true;
                        }
                    }

                    if(!ketemu) System.out.println("Produk tidak ditemukan.");
                    break;

                default:
                    System.out.println("Inputan tidak valid");
            }
        } while (pilihan != 4);
        System.out.println( "Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
        a.close();
    }
}
