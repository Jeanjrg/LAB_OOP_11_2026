package H071251033.Tuprak7.Soal1;

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
                int jumlah = random.nextInt(5) + 1; // Tambah 1-5 barang
                gudang.tambahStok(jumlah);
                Thread.sleep(1000 + random.nextInt(1000)); // Delay 1-2 detik
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}