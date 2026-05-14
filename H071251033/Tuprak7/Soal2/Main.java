package H071251033.Tuprak7.Soal2;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int jumlahThread = 4;
        int jumlahDokumen = 10;

        DataProcessor processor = new DataProcessor();
        ExecutorService executor = Executors.newFixedThreadPool(jumlahThread);
        CountDownLatch latch = new CountDownLatch(jumlahDokumen);
        ConcurrentHashMap<String, Integer> wordResults = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Long> durationResults = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, String> threadResults = new ConcurrentHashMap<>();

        System.out.println("--- Memulai High-Performance Data Indexer ---\n");

        for (int i = 1; i <= jumlahDokumen; i++) {
            String fileName = "Dokumen_" + (char) ('A' + (i - 1)) + ".txt";

            executor.execute(new IndexingTask(
                    fileName, processor, wordResults,
                    durationResults, threadResults, latch));
        }

        executor.shutdown();

        try {
            latch.await();

            System.out.println("\n--- Klasemen Hasil Indexing ---");
            System.out.printf("%-15s | %-20s | %-12s%n",
                    "Nama Dokumen", "Thread", "Durasi");
            System.out.println("----------------------------------------------------------");

            int totalKata = 0;
            long totalDurasi = 0;

            for (int i = 1; i <= jumlahDokumen; i++) {
                String docName = "Dokumen_" + (char) ('A' + (i - 1)) + ".txt";

                int jumlahKata = wordResults.get(docName);
                long durasi = durationResults.get(docName);
                String threadName = threadResults.get(docName);

                totalKata += jumlahKata;
                totalDurasi += durasi;

                System.out.printf("%-15s | %-20s | %-12d ms%n",
                        docName, threadName, durasi);
            }

            double rataRata = (double) totalDurasi / jumlahDokumen;

            System.out.println("----------------------------------------------------------");
            System.out.println("Total Kata Keseluruhan : " + totalKata);
            System.out.printf("Rata-rata Waktu Pemrosesan : %.2f ms%n", rataRata);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}