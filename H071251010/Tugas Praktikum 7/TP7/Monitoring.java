public class Monitoring implements Runnable { 
    private final Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                tampilkanProgres();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) { }
    }

    private void tampilkanProgres() {
        int s = this.gudang.getStok();
        int k = this.gudang.getKapasitasMaksimal();
        
        StringBuilder tagar = new StringBuilder();
        int jumlahTagar = (s * 20) / k;
        
        for (int i = 0; i < 20; i++) {
            tagar.append(i < jumlahTagar ? "#" : "-");
        }
        
        System.out.println("Status Gudang: [" + tagar.toString() + "] " + ((s * 100) / k) + "%");
    }
}