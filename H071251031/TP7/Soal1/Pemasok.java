package TP7.Soal1;
import java.util.Random;

public class Pemasok implements Runnable {
    Gudang gudang;
    String nama;
    Random random = new Random();

    public Pemasok (Gudang gudang, String nama){
        this.gudang = gudang;
        this.nama = nama;
    }

    @Override
    public void run(){
        try {

            while (!Thread.currentThread().isInterrupted()) {
                
                int jumlah = random.nextInt(15) + 1;

                gudang.tambahStok(jumlah, nama);

                Thread.sleep((random.nextInt(2) + 1) * 1000);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
