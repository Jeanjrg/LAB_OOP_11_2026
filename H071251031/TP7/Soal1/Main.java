package TP7.Soal1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Gudang gudang = new Gudang(100);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.execute(new Pemasok(gudang, "Pemasok-1"));
        executor.execute(new Pemasok(gudang, "Pemasok-2"));

        executor.execute(new Kurir(gudang, "Kurir-1"));
        executor.execute(new Kurir(gudang, "Kurir-2"));
        executor.execute(new Kurir(gudang, "Kurir-3"));

        Thread monitoringThread = new Thread(new Monitoring(gudang));
        monitoringThread.start();

        try {

            Thread.sleep(15000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executor.shutdown();

        try {

            if (!executor.awaitTermination(5, TimeUnit.SECONDS)){
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        monitoringThread.interrupt();

        System.out.println("\nSistem gudang dihentikan.");
    }
}