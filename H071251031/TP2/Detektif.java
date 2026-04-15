package TP2;

import java.util.Random;

public class Detektif {
    public String nama;
    public int kecerdasan;
    public int energi;
    public Kasus kasusAktif;

    public Detektif() {
        this.nama = "Detektif Tanpa Nama";
        this.kecerdasan = 50;
        this.energi = 50;
        this.kasusAktif = null;
    }

    public Detektif(String nama, int kecerdasan, int energi, Kasus kasusAktif) {
        this.nama = nama;
        this.kecerdasan = kecerdasan;
        this.energi = energi;
        this.kasusAktif = kasusAktif;
    }

    public int getKemampuanAnalisis(Random random) {
        int keberuntungan = random.nextInt(31);
        System.out.println(nama + " mendapat faktor keberuntungan: " + keberuntungan);
        return kecerdasan + keberuntungan;
    }

    public void analisisSolo() {
        if (kasusAktif == null) {
            System.out.println(nama + " belum memiliki kasus.");
            return;
        }

        if (energi <= 0) {
            System.out.println(nama + " kelelahan dan tidak bisa menganalisis.");
            return;
        }

        Random random = new Random();
        int energiTerkuras = random.nextInt(20) + 5;
        energi = Math.max(0, energi - energiTerkuras);

        System.out.println("\n" + nama + " menganalisis kasus: " + kasusAktif.namaKasus);
        System.out.println("Energi terkuras       : " + energiTerkuras);

        int kemampuan = getKemampuanAnalisis(random);
        int batasLulus = kasusAktif.tingkatKesulitan * 10;

        System.out.println("Kemampuan analisis    : " + kemampuan);
        System.out.println("Batas kesulitan       : " + batasLulus);

        if (kemampuan >= batasLulus) {
            kasusAktif.terpecahkan = true;
            System.out.println("Berhasil! Kasus terpecahkan.");
        } else {
            System.out.println("Gagal. Kasus terlalu sulit.");
        }

        System.out.println("Energi tersisa        : " + energi);
    }

    public void investigasi(Detektif rekan, Kasus kasus) {
        if (kasus == null) {
            System.out.println("Kasus tidak valid.");
            return;
        }

        if (energi <= 0 || rekan.energi <= 0) {
            System.out.println("Investigasi tidak bisa dilakukan karena salah satu detektif kelelahan.");
            return;
        }

        Random random = new Random();
        int energiTerkuras = random.nextInt(20) + 10;

        energi = Math.max(0, energi - energiTerkuras);
        rekan.energi = Math.max(0, rekan.energi - energiTerkuras);

        System.out.println("\n" + nama + " berkolaborasi dengan " + rekan.nama);
        System.out.println("Kasus                  : " + kasus.namaKasus);
        System.out.println("Energi terkuras masing : " + energiTerkuras);

        int kemampuanGabungan =
                getKemampuanAnalisis(random) +
                rekan.getKemampuanAnalisis(random);

        int batasLulus = kasus.tingkatKesulitan * 10;

        System.out.println("Kemampuan gabungan     : " + kemampuanGabungan);
        System.out.println("Batas kesulitan        : " + batasLulus);

        if (kemampuanGabungan >= batasLulus) {
            kasus.terpecahkan = true;
            System.out.println("Berhasil! Kasus terpecahkan bersama.");
        } else {
            System.out.println("Gagal. Kasus tidak bisa dipecahkan.");
        }

        System.out.println("Energi " + nama + " tersisa  : " + energi);
        System.out.println("Energi " + rekan.nama + " tersisa: " + rekan.energi);
    }

    public void infoDetektif() {
        System.out.println("\n=== " + nama + " ===");
        System.out.println("Kecerdasan : " + kecerdasan);
        System.out.println("Energi     : " + energi);

        if (kasusAktif != null) {
            kasusAktif.infoKasus();
        } else {
            System.out.println("Belum menangani kasus.");
        }
    }
}