import java.util.concurrent.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        int jumlahDokumen = 10; 
        int jumlahThread = 4; 
        
        DataProcessor processor = new DataProcessor();
        ConcurrentHashMap<String, String> finalResults = new ConcurrentHashMap<>(); 
        CountDownLatch latch = new CountDownLatch(jumlahDokumen); 
        ExecutorService executor = Executors.newFixedThreadPool(jumlahThread); 

        System.out.println("--- Memulai Indexing Dokumen ---\n");
        long startTotalTime = System.currentTimeMillis();

        for (int i = 1; i <= jumlahDokumen; i++) {
            String fileName = "Dokumen_" + (char)('A' + (i - 1)) + ".txt";
            executor.execute(new IndexingTask(fileName, processor, finalResults, latch));
        }

        try {
            latch.await();
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long totalDuration = System.currentTimeMillis() - startTotalTime;
        displayKlasemen(finalResults, jumlahDokumen);
    }

    private static void displayKlasemen(ConcurrentHashMap<String, String> results, int totalDocs) {
        System.out.println("\n--- RINGKASAN PEMROSESAN ---");
        System.out.printf("%-15s | %-15s | %-12s | %-10s\n", 
                          "Nama Dokumen", "Thread", "Durasi", "Jumlah Kata"); 
        System.out.println("------------------------------------------------------------");

        int totalKata = 0;
        long totalMs = 0;

        for (Map.Entry<String, String> entry : results.entrySet()) {
            String[] data = entry.getValue().split(" \\| ");
            int kata = Integer.parseInt(data[0].replace(" kata", ""));
            long ms = Long.parseLong(data[1].replace(" ms", ""));
            String threadName = data[2];

            totalKata += kata;
            totalMs += ms;

            System.out.printf("%-15s | %-15s | %-12s | %-10d\n", 
                              entry.getKey(), threadName, ms + " ms", kata); 
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("Total Kata Keseluruhan : " + totalKata); 
        System.out.printf("Rata-rata Waktu Proses : %.2f ms\n", (double) totalMs / totalDocs); 
    }
}
