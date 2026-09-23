import java.util.concurrent.*;
import java.util.Map;

public class MainProcessor {
    public static void main(String[] args) throws InterruptedException {
        DataProcessor processor = new DataProcessor();
        
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        Map<String, Integer> hasilKata = new ConcurrentHashMap<>();
        Map<String, Long> waktuProses = new ConcurrentHashMap<>();
        Map<String, String> infoThread = new ConcurrentHashMap<>();
        
        CountDownLatch barrier = new CountDownLatch(10);
        long startAwal = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            String namaFile = "Dokumen_" + (char)('A' + i) + ".txt";
            executor.execute(() -> {
                long mulai = System.currentTimeMillis();
                
                int jumlah = processor.process(namaFile);
                
                hasilKata.put(namaFile, jumlah);
                waktuProses.put(namaFile, System.currentTimeMillis() - mulai);
                infoThread.put(namaFile, Thread.currentThread().getName());
                
                System.out.println("[" + Thread.currentThread().getName() + "] Selesai memproses " + namaFile + " (" + jumlah + " kata).");
                
                barrier.countDown();
            });
        }

        barrier.await();
        executor.shutdown();
        
        cetakKlasemen(hasilKata, waktuProses, infoThread, System.currentTimeMillis() - startAwal);
    }

    private static void cetakKlasemen(Map<String, Integer> h, Map<String, Long> w, Map<String, String> t, long totalDurasi) {
        System.out.println("\n--- Klasemen Akhir Search Engine ---");
        System.out.printf("%-15s | %-15s | %-10s | %-10s\n", "Nama Dokumen", "Thread", "Waktu(ms)", "Kata");
        System.out.println("-------------------------------------------------------------");
        
        int totalKata = 0;
        for (String file : h.keySet()) {
            totalKata += h.get(file);
            System.out.printf("%-15s | %-15s | %-10d | %-10d\n", file, t.get(file), w.get(file), h.get(file));
        }
        
        System.out.println("-------------------------------------------------------------");
        
        System.out.println("Total Kata Keseluruhan : " + totalKata);
        System.out.println("Rata-rata Waktu Proses : " + (totalDurasi / 10) + " ms");
    }
}