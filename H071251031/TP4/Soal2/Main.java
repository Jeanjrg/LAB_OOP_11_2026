package TP4.Soal2;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    // ===== VALIDASI INPUT =====
    static int inputInt(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                return Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Input harus angka!");
            }
        }
    }

    static double inputDouble(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                return Double.parseDouble(input.nextLine());
            } catch (Exception e) {
                System.out.println("Input harus angka!");
            }
        }
    }

    static String inputString(String pesan) {
        while (true) {
            System.out.print(pesan);
            String data = input.nextLine();
            if (!data.trim().isEmpty()) {
                return data;
            } else {
                System.out.println("Input tidak boleh kosong!");
            }
        }
    }

    public static void main(String[] args) {

        Produk[] daftarProduk = new Produk[100];
        int jumlahProduk = 0;
        int pilihan;

        do {
            System.out.println("\n=================================");
            System.out.println("     SISTEM TOKO ELEKTRONIK");
            System.out.println("=================================");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");

            pilihan = inputInt("Pilih menu: ");

            switch (pilihan) {

                case 1:
                    String merek = inputString("Merek        : ");
                    int nomorSeri = inputInt("Nomor Seri   : ");
                    double harga = inputDouble("Harga        : ");

                    System.out.println("\n=== Tambah Produk ===");
                    System.out.println("1. Smartphone");
                    System.out.println("2. Laptop");
                    System.out.println("3. Kamera");
                    int jenis = inputInt("Pilih tipe produk: ");


                    if (jumlahProduk >= daftarProduk.length) {
                        System.out.println("Stok penuh!");
                        break;
                    }

                    if (jenis == 1) {
                        double layar = inputDouble("Ukuran Layar : ");
                        int storage = inputInt("Storage      : ");

                        daftarProduk[jumlahProduk++] =
                                new Smartphone(merek, nomorSeri, harga, layar, storage);

                    } else if (jenis == 2) {
                        int ram = inputInt("RAM          : ");
                        String processor = inputString("Processor    : ");

                        daftarProduk[jumlahProduk++] =
                                new Laptop(merek, nomorSeri, harga, ram, processor);

                    } else if (jenis == 3) {
                        int resolusi = inputInt("Resolusi     : ");
                        String lensa = inputString("Tipe Lensa   : ");


                        daftarProduk[jumlahProduk++] =
                                new Kamera(merek, nomorSeri, harga, resolusi, lensa);

                    } else {
                        System.out.println("Jenis tidak valid!");
                        break;
                    }

                    System.out.println("Produk berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\n=== Daftar Produk ===");

                    if (jumlahProduk == 0) {
                        System.out.println("Tidak ada produk.");
                    } else {
                        for (int i = 0; i < jumlahProduk; i++) {
                            daftarProduk[i].tampilInfo();
                            System.out.println("---------------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n=== Beli Produk ===");
                    int cari = inputInt("Masukkan Nomor Seri: ");
                    boolean ditemukan = false;

                    for (int i = 0; i < jumlahProduk; i++) {
                        if (daftarProduk[i].getNomorSeri() == cari) {

                            System.out.println("\nProduk ditemukan:");
                            daftarProduk[i].tampilInfo();

                            // hapus (geser array)
                            for (int j = i; j < jumlahProduk - 1; j++) {
                                daftarProduk[j] = daftarProduk[j + 1];
                            }

                            jumlahProduk--;
                            System.out.println("Pembelian berhasil!");
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Produk tidak ditemukan!");
                    }
                    break;

                case 4:
                    System.out.println("\nTerima kasih telah menggunakan sistem!");
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }

        } while (pilihan != 4);
    }
}