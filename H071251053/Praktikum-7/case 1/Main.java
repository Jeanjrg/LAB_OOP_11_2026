import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    
    public static void main(String[] args) {
        Gudang gudang = new Gudang(15); 

        ExecutorService poolPemasok = Executors.newFixedThreadPool(2);
        ExecutorService poolKurir = Executors.newFixedThreadPool(3);

        Thread monitorThread = new Thread(new Monitoring(gudang));
        monitorThread.start();

        for (int i = 1; i <= 2; i++) {
            poolPemasok.execute(new Pemasok(gudang, "Pemasok-" + i));
        }

        for (int i = 1; i <= 3; i++) {
            poolKurir.execute(new Kurir(gudang, "Kurir-" + i));
        }

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- Menghentikan Sistem ---");
        poolPemasok.shutdownNow();
        poolKurir.shutdownNow();
        monitorThread.interrupt();

        try {
            if (!poolPemasok.awaitTermination(5, TimeUnit.SECONDS)) 
                poolPemasok.shutdownNow();
            if (!poolKurir.awaitTermination(5, TimeUnit.SECONDS)) 
                poolKurir.shutdownNow();
        } catch (InterruptedException e) {
            poolPemasok.shutdownNow();
            poolKurir.shutdownNow();
        }
        
        System.out.println("Sistem logistik berhenti.");
    }
}