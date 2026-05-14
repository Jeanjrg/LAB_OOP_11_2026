package H071251033.Tuprak4.Nomor2;

import java.util.ArrayList;

public class Toko {
    private ArrayList<Produk> daftarProduk = new ArrayList<>();

    public void tambahProduk(Produk p) {
        daftarProduk.add(p);
        System.out.println("Produk berhasil ditambahkan!");
    }

    public void tampilkanSemua() {
        if (daftarProduk.isEmpty()) {
            System.out.println("Tidak ada produk.");
            return;
        }

        for (Produk p : daftarProduk) {
            System.out.println("\n-------------------");
            p.tampil();
        }
    }

    public void beliProduk(String nomorSeri) {
        for (Produk p : daftarProduk) {
            if (p.getNomorSeri().equalsIgnoreCase(nomorSeri)) {
                System.out.println("\nProduk ditemukan:");
                p.tampil();
                System.out.println("Pembelian berhasil!");
                return;
            }
        }
        System.out.println("Produk tidak ditemukan!");
    }
}