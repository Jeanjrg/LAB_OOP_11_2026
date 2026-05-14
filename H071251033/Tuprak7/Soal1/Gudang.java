package H071251033.Tuprak7.Soal1;

public class Gudang {
    private int stok = 0;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah) {
        while (stok + jumlah > kapasitasMaksimal) {
            try {
                System.out.println("[Pemasok] Gudang penuh, menunggu...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        stok += jumlah;
        System.out.println("[Pemasok] Menambah "
                + jumlah + " barang. Stok sekarang: " + stok);

        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) {
        while (stok < jumlah) {
            try {
                System.out.println("[Kurir] Stok tidak cukup, menunggu...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        stok -= jumlah;
        System.out.println("[Kurir] Mengambil "
                + jumlah + " barang. Stok sekarang: " + stok);

        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public synchronized int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}