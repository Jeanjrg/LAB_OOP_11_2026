public class Gudang {
    private int stok;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.stok = 0;
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah) {
        while (this.stok + jumlah > this.kapasitasMaksimal) {
            try { wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        this.stok += jumlah;
        System.out.println(">>> Pemasok menambah " + jumlah + ". Stok saat ini: " + this.stok);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) {
        while (this.stok < jumlah) {
            try { wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        this.stok -= jumlah;
        System.out.println("<<< Kurir mengambil " + jumlah + ". Stok tersisa: " + this.stok);
        notifyAll(); 
    }

    public synchronized int getStok() { return this.stok; }
    public int getKapasitasMaksimal() { return this.kapasitasMaksimal; }
}

