package TP2;

public class Kasus {
    public String namaKasus;
    public int tingkatKesulitan;
    public boolean terpecahkan;

    // Constructor default
    public Kasus() {
        this.namaKasus = "Kasus Tidak Diketahui";
        this.tingkatKesulitan = 1;
        this.terpecahkan = false;
    }

    // Constructor dengan parameter
    public Kasus(String namaKasus, int tingkatKesulitan) {
        this.namaKasus = namaKasus;
        this.tingkatKesulitan = tingkatKesulitan;
        this.terpecahkan = false;
    }

    public void infoKasus() {
        System.out.println("Nama Kasus        : " + namaKasus);
        System.out.println("Tingkat Kesulitan : " + tingkatKesulitan + "/10");
        System.out.println("Status            : " + (terpecahkan ? "Terpecahkan" : "Belum Terpecahkan"));
    }
}