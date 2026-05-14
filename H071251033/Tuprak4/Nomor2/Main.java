package H071251033.Tuprak4.Nomor2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Toko toko = new Toko();
        int pilihan;

        do {
            System.out.println("\n=== MENU TOKO ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n1. Smartphone\n2. Laptop\n3. Kamera");
                    System.out.print("Pilih jenis: ");
                    int jenis = input.nextInt();
                    input.nextLine();

                    System.out.print("Merek: ");
                    String merek = input.nextLine();
                    System.out.print("No Seri: ");
                    String noSeri = input.nextLine();
                    System.out.print("Harga: ");
                    double harga = input.nextDouble();

                    if (jenis == 1) {
                        System.out.print("Ukuran layar: ");
                        double layar = input.nextDouble();
                        System.out.print("Storage: ");
                        int storage = input.nextInt();
                        toko.tambahProduk(new Smartphone(merek, noSeri, harga, layar, storage));

                    } else if (jenis == 2) {
                        System.out.print("RAM: ");
                        int ram = input.nextInt();
                        input.nextLine();
                        System.out.print("Processor: ");
                        String proc = input.nextLine();
                        toko.tambahProduk(new Laptop(merek, noSeri, harga, ram, proc));

                    } else if (jenis == 3) {
                        System.out.print("Resolusi: ");
                        int res = input.nextInt();
                        input.nextLine();
                        System.out.print("Tipe: ");
                        String tipe = input.nextLine();
                        toko.tambahProduk(new Kamera(merek, noSeri, harga, res, tipe));
                    }
                    break;

                case 2:
                    toko.tampilkanSemua();
                    break;

                case 3:
                    System.out.print("Masukkan nomor seri: ");
                    String cari = input.nextLine();
                    toko.beliProduk(cari);
                    break;

                case 4:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 4);

        input.close();
    }
}