public class Gudang {
    private int stok = 0;
    private int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah, String namaPemasok) throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println(namaPemasok + " menunggu... (Gudang Penuh)");
            wait(); 
        }
        stok += jumlah;
        System.out.printf("%s menambah %d. Stok saat ini: %d\n", namaPemasok, jumlah, stok);
        notifyAll(); 
    }

    public synchronized void ambilStok(int jumlah, String namaKurir) throws InterruptedException {
        while (stok < jumlah) {
            System.out.println(namaKurir + " menunggu... (Stok Kosong)");
            wait(); 
        }
        stok -= jumlah;
        System.out.printf("%s mengambil %d. Stok saat ini: %d\n", namaKurir, jumlah, stok);
        notifyAll(); 
    }

    public int getStok() { 
        return stok; 
    }
    
    public int getKapasitasMaksimal() { 
        return kapasitasMaksimal; 
    }
}