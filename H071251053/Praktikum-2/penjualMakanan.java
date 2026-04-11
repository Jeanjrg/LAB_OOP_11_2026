public class penjualMakanan {
    String nama;
    int uang = 0;
    Makanan makanan = new Makanan();
    int jumlah;

    public penjualMakanan() {
        this.nama = "Tidak ada";
        this.uang = 0;
        this.jumlah = 0;
    }

    public penjualMakanan(String nama, String menuMakanan, int harga, int jumlah) {
        this.nama = nama;
        this.makanan.menu = menuMakanan;
        this.makanan.harga = harga;
        this.jumlah = jumlah; 
    }

    public void titipJualan(penjualMakanan penjualLain) {
        System.out.println("_____________________________________");
        System.out.println("\n" + this.nama + " menitip makanan ke " + penjualLain.nama);

        int total = this.makanan.harga * this.jumlah;
        penjualLain.uang += total;

        System.out.println("Titipan: " + this.makanan.menu + " x" + this.jumlah);
        System.out.println("Total: Rp." + total);
        System.out.println(penjualLain.nama + " menerima uang tersebut");
        System.out.println("_____________________________________");
    }

    public void cekStatus() {
        System.out.println("\n ===== " + nama + " Status =====");
        System.out.println("Nama\t: " + nama);
        makanan.tampilkanMakanan();
        System.out.println("Jumlah\t: " + jumlah);
        System.out.println("Uang\t: Rp." + uang);
    }
}
