public class Monitoring implements Runnable {
    private final Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int currentStok = gudang.getStok();
                int max = gudang.getKapasitasMaksimal();
                int persen = (currentStok * 100) / max;
                
                int barLen = 10;
                int filled = (currentStok * barLen) / max;
                StringBuilder bar = new StringBuilder("[");
                for (int i = 0; i < barLen; i++) {
                    bar.append(i < filled ? "#" : "-");
                }
                bar.append("]");

                System.out.println("\nStatus Gudang: " + bar + " " + persen + "%");
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
