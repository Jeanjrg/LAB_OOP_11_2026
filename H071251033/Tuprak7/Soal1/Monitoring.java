package H071251033.Tuprak7.Soal1;

public class Monitoring implements Runnable {
    private final Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int stok = gudang.getStok();
                int kapasitas = gudang.getKapasitasMaksimal();
                int persen = (stok * 100) / kapasitas;
                
                int barLength = 10;
                int filled = persen / 10;
                
                StringBuilder bar = new StringBuilder("[");
                for (int i = 0; i < barLength; i++) {
                    if (i < filled) bar.append("#");
                    else bar.append("-");
                }
                bar.append("]");

                System.out.println("Status Gudang: " + bar + " " + persen + "%");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}