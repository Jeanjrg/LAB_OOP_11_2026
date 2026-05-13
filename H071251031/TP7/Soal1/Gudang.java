package TP7.Soal1;

public class Gudang {
    int stok;
    int kapasitasMaksimal;

    public Gudang (int kapasitasMaksimal){
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.stok = 0;
    }

    public synchronized void tambahStok(int jumlah, String namaPemasok){
        try {

            while (stok + jumlah > kapasitasMaksimal) {
                System.out.println(namaPemasok + " menunggu, gudang penuh...");
                wait();
            }

            stok += jumlah;

            System.out.println(
                namaPemasok + " menambahkan " + jumlah + " barang. " + "Stok sekarang: " + stok
            );

            notifyAll();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void ambilStok(int jumlah, String namaKurir){
        try {

            while (stok < jumlah){
                System.out.println(namaKurir + "menunggu, stok tidak cukup... ");
                wait();
            }

            stok -= jumlah;

            System.out.println(
                namaKurir + " mengambil " + jumlah + " barang. " + "Stok sekarang: " + stok
            );

            notifyAll();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}

