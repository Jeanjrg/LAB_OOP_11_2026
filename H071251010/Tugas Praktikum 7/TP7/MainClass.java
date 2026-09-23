import java.util.concurrent.*;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        Gudang gudangUtama = new Gudang(30);
        
        ExecutorService poolPemasok = Executors.newFixedThreadPool(2);
        ExecutorService poolKurir = Executors.newFixedThreadPool(3);
        
        Thread threadMonitor = new Thread(new Monitoring(gudangUtama));
        threadMonitor.start();

        for (int i = 0; i < 2; i++) poolPemasok.execute(new Pemasok(gudangUtama));
        for (int i = 0; i < 3; i++) poolKurir.execute(new Kurir(gudangUtama));

        TimeUnit.SECONDS.sleep(15);

        System.out.println("\n--- Menghentikan Sistem ---");
        
        threadMonitor.interrupt();
        
        poolPemasok.shutdown(); 
        poolKurir.shutdown();
        
        poolPemasok.shutdownNow(); 
        poolKurir.shutdownNow();

        if (poolPemasok.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Sistem Berhenti Aman.");
        }
    }
}