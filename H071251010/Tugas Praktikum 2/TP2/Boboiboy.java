package TP2;

public class Boboiboy {
    String nama;
    int energy = 50;

    Elemen elemen = new Elemen();
    Kemampuan kemampuan = new Kemampuan();


    public Boboiboy() {}

    public Boboiboy(String nama, String elemen, int power, String skill, String efek, int energy) {
        this.nama = nama;
        this.elemen.jenisElemen = elemen;
        this.elemen.basePower = power;
        this.kemampuan.namaSkill = skill;
        this.kemampuan.efek = efek;
        this.energy = energy;
    }

    public void gunakanSkill(Boboiboy musuh) {
        System.out.println(nama + " menggunakan skill ke " + musuh.nama);

        int damage = elemen.getPower();

        if (elemen.jenisElemen.equalsIgnoreCase("Halilintar")) {
            damage += 5;
            System.out.println("Serangan sangat cepat!");
        } 
        else if (elemen.jenisElemen.equalsIgnoreCase("Topan")) {
            damage += 2;
            System.out.println("Musuh terganggu oleh angin!");
        } 
        else if (elemen.jenisElemen.equalsIgnoreCase("Gempa")) {
            this.energy += 3;
            System.out.println("Menambah energi karena kekuatan tanah!");
        }

        musuh.energy -= damage;

        System.out.println("Damage: " + damage);
    }

    public void checkStatus() {
        System.out.println("=== Status " + nama + " ===");
        System.out.println("Energy : " + energy);
        System.out.println("Elemen : " + elemen.jenisElemen);
        System.out.println("Power  : " + elemen.getPower());
        System.out.println("Skill  : " + kemampuan.getEfek());
    }
}