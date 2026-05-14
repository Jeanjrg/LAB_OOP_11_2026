package TP7.Soal2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        List<String> dokumen = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            dokumen.add("Dokumen_" + i + ".txt");
        }

        ConcurrentHashMap<String, Integer> hasil = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, String> threadHandler = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Long> durasiProses = new ConcurrentHashMap<>();

        ExecutorService executor = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(dokumen.size());

        for (String file : dokumen) {
            executor.execute(new DocumentTask(file, hasil, threadHandler, durasiProses, latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executor.shutdown();

        System.out.println("\n===== HASIL AKHIR =====\n");
        System.out.printf("%-20s %-20s %-15s %-15s%n", "Nama Dokumen", "Thread", "Jumlah Kata", "Durasi(ms)");
        System.out.println("---------------------------------------------------------------------");

        int totalKata = 0;
        int totalDurasi = 0;

        for (String file : hasil.keySet()) {
            long kata = hasil.get(file);
            String thread = threadHandler.get(file);
            long durasi = durasiProses.get(file);

            totalKata += kata;
            totalDurasi += durasi;

            System.out.printf("%-20s %-20s %-15d %-15d%n", file, thread, kata, durasi);
        }

        double rataRata = (double) totalDurasi / hasil.size();
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Total Kata : " + totalKata);
        System.out.printf("Rata-rata Waktu Proses: %.2f ms%n", rataRata);
    }
}