package H071251033.Tuprak7.Soal1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainLogistik {
    public static void main(String[] args) {
        Gudang gudang = new Gudang(20);

        ExecutorService pemasokPool = Executors.newFixedThreadPool(2);
        ExecutorService kurirPool = Executors.newFixedThreadPool(3);

        Thread monitorThread = new Thread(new Monitoring(gudang));
        monitorThread.start();

        // Jalankan pemasok
        for (int i = 0; i < 2; i++) {
            pemasokPool.execute(new Pemasok(gudang));
        }

        // Jalankan kurir
        for (int i = 0; i < 3; i++) {
            kurirPool.execute(new Kurir(gudang));
        }

        try {
            // Sistem berjalan 15 detik
            Thread.sleep(15000);

            System.out.println("\n--- Menghentikan Sistem ---");

            pemasokPool.shutdown();
            kurirPool.shutdown();

            if (!pemasokPool.awaitTermination(5, TimeUnit.SECONDS)) {
                pemasokPool.shutdownNow();
            }

            if (!kurirPool.awaitTermination(5, TimeUnit.SECONDS)) {
                kurirPool.shutdownNow();
            }

            monitorThread.interrupt();
            monitorThread.join();

            System.out.println("Sistem berhenti dengan aman.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}