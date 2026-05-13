package H071251033.Tuprak7.Soal1;

import java.util.Random;

public class Kurir implements Runnable {
    private final Gudang gudang;
    private final Random random = new Random();

    public Kurir(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlah = random.nextInt(5) + 1; // Ambil 1-5 barang
                gudang.ambilStok(jumlah);
                Thread.sleep(2000 + random.nextInt(1000)); // Delay 2-3 detik
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}