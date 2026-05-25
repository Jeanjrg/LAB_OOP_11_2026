import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// Class DataProcessor
class DataProcessor {
    private final Random random = new Random();

    // Mensimulasikan proses pembacaan file dengan Thread.sleep dan mengembalikan jumlah kata
    public int process(String fileName) {
        try {
            // Simulasi waktu pemrosesan acak antara 500ms - 2000ms 
            int durasi = 500 + random.nextInt(150); 
            Thread.sleep(durasi);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Menyalakan ulang tanda interupsi
        }
        
        // Mengembalikan jumlah kata acak (misal simulasi antara 50 hingga 500 kata)
        return 50 + random.nextInt(451);
    }
}


// Representasi entri laporan untuk mempermudah cetak tabel klasemen akhir
class LogProses {
    String namaThread;
    int jumlahKata;
    long durasiProses;

    public LogProses(String namaThread, int jumlahKata, long durasiProses) {
        this.namaThread = namaThread;
        this.jumlahKata = jumlahKata;
        this.durasiProses = durasiProses;
    }
}


// Main Class
public class Main2 {
    public static void main(String[] args) {
        int jumlahDokumen = 10;
        int jumlahThread = 4;

        
        // Inisialisasi DataProcessor
        DataProcessor processor = new DataProcessor();

        // Thread Management: ExecutorService dengan 4 thread 
        ExecutorService executor = Executors.newFixedThreadPool(jumlahThread); 

        // Thread Management: ConcurrentHashMap untuk menjamin thread-safety
        ConcurrentHashMap<String, LogProses> wadahKolektif = new ConcurrentHashMap<>();

        // Synchronization Barrier: CountDownLatch agar thread utama menunggu seluruh dokumen selesai diproses 
        CountDownLatch latch = new CountDownLatch(jumlahDokumen);


        System.out.println("=== SEARCH ENGINE CORE: PROSES INDEXING DIMULAI ===");
        long waktuMulaiTotal = System.currentTimeMillis();

        // Memproses minimal 10 dokumen simulasi
        for (int i = 1; i <= jumlahDokumen; i++) {
            String namaDokumen = "Dokumen_" + (char) ('A' + (i - 1)) + ".txt";

            // Mengirimkan tugas indexing ke Executor Service
            executor.execute(() -> {
                String threadName = Thread.currentThread().getName();
                long waktuMulaiTask = System.currentTimeMillis();

                // Memproses dokumen dan mendapatkan jumlah kata
                int kataDitemukan = processor.process(namaDokumen);

                long waktuSelesaiTask = System.currentTimeMillis();
                long durasiTask = waktuSelesaiTask - waktuMulaiTask;

                // Menyimpan hasil pemrosesan ke ConcurrentHashMap (Wadah Kolektif)
                wadahKolektif.put(namaDokumen, new LogProses(threadName, kataDitemukan, durasiTask));
                System.out.println("[" + threadName + "] Selesai memproses " + namaDokumen + " (" + kataDitemukan + " kata).");

                // Mengurangi hitungan Latch setelah satu tugas selesai
                latch.countDown();
            });
        }

        try {
            // Program utama (main thread) akan terkunci di sini sampai hitungan latch menjadi 0 
            latch.await(); 
        } catch (InterruptedException e) {
            System.out.println("Thread utama terinterupsi.");
        }

        // Mematikan executor service dengan aman
        executor.shutdown();

        long waktuSelesaiTotal = System.currentTimeMillis();
        long totalDurasiNyata = waktuSelesaiTotal - waktuMulaiTotal;

        // 5. Output Akhir (Klasemen)
        System.out.println("\n=========================================================");
        System.out.println("               KLASEMEN AKHIR INDEXING                  ");
        System.out.println("=========================================================");
        System.out.printf("%-15s | %-15s | %-15s\n", "Nama Dokumen", "Thread", "Durasi Proses");
        System.out.println("---------------------------------------------------------");

        int totalKataKeseluruhan = 0;
        long totalWaktuPemrosesanSemuaThread = 0;

        // Iterasi map untuk menampilkan hasil ringkasan tabel dan kalkulasi total data
        for (String docName : wadahKolektif.keySet()) {
            LogProses log = wadahKolektif.get(docName);
            System.out.printf("%-15s | %-15s | %d ms\n", docName, log.namaThread, log.durasiProses);

            totalKataKeseluruhan += log.jumlahKata;
            totalWaktuPemrosesanSemuaThread += log.durasiProses;
        }

        // Menghitung rata-rata waktu pemrosesan dokumen oleh thread
        double rataRataWaktu = (double) totalWaktuPemrosesanSemuaThread / jumlahDokumen;

        System.out.println("=========================================================");
        System.out.println("STATISTIK KESELURUHANN:");
        System.out.println(" -> Total Kata Keseluruhan      : " + totalKataKeseluruhan + " kata");
        System.out.printf(" -> Rata-rata Waktu Pemrosesan  :  %.2f ms per dokumen\n", rataRataWaktu);
        System.out.println(" -> Total Waktu Eksekusi Nyata  : " + totalDurasiNyata + " ms (Paralel " + jumlahThread + " Thread)");
        System.out.println("=========================================================");
    }
}