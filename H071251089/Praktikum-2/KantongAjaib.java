public class KantongAjaib {
    // 3 Attribute
    String pemilik;
    int jumlahEnergi;
    AlatAjaib isiKantong;


    // Constructor

    // 1. Constructor Default (Tanpa parameter)
    public KantongAjaib() {
        this.pemilik = "Doraemon";
        this.jumlahEnergi = 100;
        this.isiKantong = new AlatAjaib("Baling-baling Bambu", 50);
    }

    // 2. Constructor dengan Parameter
    public KantongAjaib(String pemilik, int jumlahEnergi, AlatAjaib alat) {
        this.pemilik = pemilik;
        this.jumlahEnergi = jumlahEnergi;
        this.isiKantong = alat;
    }


    // Behavior/Method

    // Method 1: Berinteraksi langsung dengan atribut objek tersebut
    public void cekIsiKantong() {
        System.out.println("\nKantong milik : " + pemilik);
        System.out.println("Alat di dalam : " + isiKantong.namaAlat);
        System.err.println("Kekuatan alat : " + isiKantong.kekuatan);
        System.out.println("Energi saat ini : " + jumlahEnergi);
    }

    // Method 2: Interaksi antar objek dari class yang sama
    public void memberiEnergi(KantongAjaib target) {
        int transfer = 20;

        System.out.println("\nEnergi " + target.pemilik + " adalah " + target.jumlahEnergi);

        if (this.jumlahEnergi <= transfer) {
            target.jumlahEnergi += this.jumlahEnergi;
            transfer = jumlahEnergi;
            this.jumlahEnergi = 0;
        } else {
            target.jumlahEnergi += transfer;
            this.jumlahEnergi -= transfer;
        }
        
        System.out.println(this.pemilik + " memberikan " + transfer + " energi ke " + target.pemilik);
        System.out.println(this.pemilik + " sisa memiliki " + this.jumlahEnergi + " energi");
        System.out.println("Energi " + target.pemilik + " sekarang : " + target.jumlahEnergi);
    }
}