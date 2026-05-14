package TP7.Soal1;

public class Monitoring implements Runnable{
    Gudang gudang;

    public Monitoring(Gudang gudang){
        this.gudang = gudang;
    }

     @Override
    public void run() {

        try {

            while (!Thread.currentThread().isInterrupted()) {

                tampilkanStatus();

                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void tampilkanStatus() {

        int stok = gudang.getStok();
        int kapasitas = gudang.getKapasitasMaksimal();

        int bar = (stok * 20) / kapasitas;

        StringBuilder visual = new StringBuilder();

        for (int i = 0; i < 20; i++) {

            if (i < bar) {
                visual.append("#");
            } else {
                visual.append("-");
            }
        }

        System.out.println( "\nStatus Gudang: "+"[" + visual + "] " + stok + "%");
        System.out.println();
    }
}