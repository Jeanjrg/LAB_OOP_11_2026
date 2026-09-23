import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


// 1. Class Gudang (Shared Resource)
class Gudang {
    private int stok = 0;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    // Method synchronized untuk menambah stok (Producer)
    public synchronized void tambahStok(int jumlah, String namaPemasok) {
        // Jika penuh atau penambahan melebihi kapasitas, thread pemasok harus menunggu
        while (stok + jumlah > kapasitasMaksimal) {
            try {
                System.out.println("[WAIT] " + namaPemasok + " ingin menambah " + jumlah + " barang, tetapi gudang penuh (Stok saat ini: " + stok + "). Menunggu...");
                wait(); // Thread tidur sampai ada kurir yang mengambil barang
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        
        stok += jumlah;
        System.out.println("[PRODUCED] " + namaPemasok + " menambah " + jumlah + " barang. (Stok saat ini: " + stok + ")");
        notifyAll(); // Membangunkan thread lain (terutama Kurir yang sedang menunggu barang)
    }

    // Method synchronized untuk mengambil stok (Consumer)
    public synchronized void ambilStok(int jumlah, String namaKurir) {
        // Jika stok kosong atau barang yang diminta kurang, thread kurir harus menunggu
        while (stok < jumlah) {
            try {
                System.out.println("[WAIT] " + namaKurir + " ingin mengambil " + jumlah + " barang, tetapi stok tidak cukup (Stok saat ini: " + stok + "). Menunggu...");
                wait(); // Thread tidur sampai ada pemasok yang menambah barang
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        stok -= jumlah;
        System.out.println("[CONSUMED] " + namaKurir + " mengambil " + jumlah + " barang. (Stok saat ini: " + stok + ")");
        notifyAll(); // Membangunkan thread lain (terutama Pemasok yang sedang menunggu ruang kosong)
    }

    public synchronized int getStok() {
        return this.stok;
    }

    public int getKapasitasMaksimal() {
        return this.kapasitasMaksimal;
    }
}


// 2. Class Pemasok (Producer Thread)
class Pemasok implements Runnable {
    private final Gudang gudang;
    private final String nama;
    private final Random random = new Random();

    public Pemasok(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama = nama;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // Menambahkan barang secara acak (misal antara 1 - 5 barang)
                int jumlahBarang = random.nextInt(5) + 1;
                gudang.tambahStok(jumlahBarang, nama);

                // Berhenti/jeda secara acak setiap 1-2 detik
                int jeda = 1000 + random.nextInt(1001);
                Thread.sleep(jeda);
            }
        } catch (InterruptedException e) {}
    }
}


// 3. Class Kurir (Consumer Thread)
class Kurir implements Runnable {
    private final Gudang gudang;
    private final String nama;
    private final Random random = new Random();

    public Kurir(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama = nama;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // Mengambil barang secara acak (misal antara 1 - 4 barang)
                int jumlahBarang = random.nextInt(4) + 1;
                gudang.ambilStok(jumlahBarang, nama);

                // Berhenti/jeda secara acak setiap 2-3 detik
                int jeda = 2000 + random.nextInt(1001);
                Thread.sleep(jeda);
            }
        } catch (InterruptedException e) {}
    }
}


// 4. Class Monitoring (Observer Thread)
class Monitoring implements Runnable {
    private final Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // Ambil data stok saat ini
                int stokSaatIni = gudang.getStok();
                int kapasitasMaks = gudang.getKapasitasMaksimal();
                
                // Hitung persentase kapasitas gudang
                int persentase = (stokSaatIni * 100) / kapasitasMaks;

                // Membuat visualisasi progress bar (total 20 karakter)
                int jumlahHashtag = persentase / 5;
                String progressBar = "";
                
                for (int i = 0; i < 20; i++) {
                    if (i < jumlahHashtag) {
                        progressBar += "#";
                    } else {
                        progressBar += "-";
                    }
                }

                // Cetak laporan visual sesuai format contoh output
                System.out.println("\nStatus Gudang: [" + progressBar + "] " + persentase + "%\n");

                // Menampilkan laporan visual setiap 1 detik
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {}
    }
}


// 5. Main Class
public class Main1 {
    public static void main(String[] args) {
        // Inisialisasi Gudang dengan kapasitas maksimal (contoh: 20 barang)
        Gudang centralWarehouse = new Gudang(20);

        // Inisialisasi ExecutorService untuk mengelola pool pemasok dan kurir
        ExecutorService poolPemasok = Executors.newFixedThreadPool(2); // 2 thread pemasok
        ExecutorService poolKurir = Executors.newFixedThreadPool(3);   // 3 thread kurir

        // Membuat satu thread terpisah untuk Monitoring (Observer)
        Thread threadMonitoring = new Thread(new Monitoring(centralWarehouse));

        
        System.out.println("=== SISTEM LOGISTIK CENTRAL WAREHOUSE DIMULAI ===");

        // Jalankan Pemasok 
        poolPemasok.execute(new Pemasok(centralWarehouse, "Pemasok-1"));
        poolPemasok.execute(new Pemasok(centralWarehouse, "Pemasok-2"));

        // Jalankan Kurir
        poolKurir.execute(new Kurir(centralWarehouse, "Kurir-1"));
        poolKurir.execute(new Kurir(centralWarehouse, "Kurir-2"));
        poolKurir.execute(new Kurir(centralWarehouse, "Kurir-3"));

        // Jalankan thread monitoring
        threadMonitoring.start();

        // Jalankan sistem selama 15 detik
        try {
            Thread.sleep(15000); // 15 detik dalam milidetik 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Hentikan semua thread secara aman setelah 15 detik
        System.out.println("\n=== SHUTDOWN SISTEM: MENGHENTIKAN SEMUA PROSES SECARA AMAN ===");
        
        // Mematikan pool pemasok dan kurir
        poolPemasok.shutdownNow();
        poolKurir.shutdownNow();
        
        // Menghentikan thread monitoring dengan interupsi
        threadMonitoring.interrupt();

        try {
            // Menunggu proses shutdown selesai secara formal (awaitTermination)
            if (!poolPemasok.awaitTermination(3, TimeUnit.SECONDS)) {
                System.out.println("Pool Pemasok tidak berhenti sepenuhnya.");
            }
            if (!poolKurir.awaitTermination(3, TimeUnit.SECONDS)) {
                System.out.println("Pool Kurir tidak berhenti sepenuhnya.");
            }
        } catch (InterruptedException e) {
            System.out.println("Proses penghentian paksa terinterupsi.");
        }

        System.out.println("Sistem logistik selesai dihentikan dengan aman.");
    }
}