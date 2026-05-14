package TP7.Soal1;
import java.util.Random;

public class Kurir implements Runnable{
    Gudang gudang;
    String nama;
    Random random = new Random();

    public Kurir(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama = nama;
    }

    @Override
    public void run() {

        try {

            while (!Thread.currentThread().isInterrupted()) {

                int jumlah = random.nextInt(10) + 1;

                gudang.ambilStok(jumlah, nama);

                Thread.sleep((random.nextInt(2) + 2) * 1000);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
