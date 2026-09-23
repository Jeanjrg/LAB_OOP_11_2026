import java.util.Random;

public class Pemasok implements Runnable {
    private final Gudang gudang;
    private final Random random = new Random();

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                this.gudang.tambahStok(this.random.nextInt(5) + 1);
                Thread.sleep(1000 + this.random.nextInt(1000));
            }
        } catch (InterruptedException e) {
        
        }
    }
}