import java.util.ArrayList;
import java.util.Scanner;

public class MainSoal2 {
    Scanner np = new Scanner(System.in);
    ArrayList<Product> daftarProduk = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner np = new Scanner(System.in);
        MainSoal2 main = new MainSoal2();

        int pil = 0;

        while (pil != 4) { 
            System.out.println("Menu : \n1. Tambah Produk \n2. Tampilkan Semua Produk \n3. Beli Produk \n4. Keluar");
            System.out.print(">>> Pilih menu (1-4) : "); pil = np.nextInt();

            switch (pil) {
                case 1 ->
                    main.tambahProduk();
                case 2 ->
                    main.tampilkanProduk();
                case 3 ->
                    main.beliProduk();
                case 4 ->
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                default ->
                    System.out.println("Input tidak tersedia.\n");
            }
        }
    }

    public void tambahProduk() {
        np.nextLine();
        System.out.print("Masukkan nama produk : "); String namaProduk = np.nextLine();
        System.out.print("Masukkan nomor seri : "); int nomorSeri = np.nextInt();
        System.out.print("Masukkan harga : "); int harga = np.nextInt();

        System.out.println("Pilih tipe produk : \n1. Smartphone \n2. Camera \n3. Laptop");
        System.out.print("Pilih tipe produk (1-3) : "); int pil = np.nextInt();

        switch (pil) {
            case 1 -> {
                System.out.print("Masukkan ukuran layar (inci) : "); double ukuranLayar = np.nextDouble();
                System.out.print("Masukkan penyimpanan (GB) : "); int penyimpanan = np.nextInt();
                daftarProduk.add(new Smartphone(namaProduk, nomorSeri, harga, ukuranLayar, penyimpanan));
            } case 2 -> {
                System.out.print("Masukkan resolusi (MP) : "); int resolusi = np.nextInt(); np.nextLine();
                System.out.println(resolusi);
                System.out.print("Masukkan tipe lensa : "); String tipeLensa = np.nextLine();
                daftarProduk.add(new Camera(namaProduk, nomorSeri, harga, resolusi, tipeLensa));
            } case 3 -> {
                System.out.print("Masukkan RAM (GB) : "); int ram = np.nextInt(); np.nextLine();
                System.out.print("Masukkan prosesor : "); String prosesor = np.nextLine();
                daftarProduk.add(new Laptop(namaProduk, nomorSeri, harga, ram, prosesor));
            } default ->
                System.out.println("Input tidak tersedia.");
        }

        System.out.println();
    }

    public void tampilkanProduk() {
        System.out.println("Daftar Produk : \n");

        for (Product produk : daftarProduk) {
            produk.displayInfo();
            System.out.println();
        }
    }

    public void beliProduk() {
        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
        int cariNomorSeri = np.nextInt();
        boolean ditemukan = false;

        for (int i = 0; i < daftarProduk.size(); i++) {
            if (daftarProduk.get(i).nomorSeri == cariNomorSeri) {
                System.out.println("Anda telah membeli produk:");
                daftarProduk.get(i).displayInfo();
                ditemukan = true;

                System.out.println();
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.\n");
        }
    }
}