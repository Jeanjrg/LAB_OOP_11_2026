package TP2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean jalan = true;

// daftar kasus tetap
    Kasus[] daftarKasus = {
        new Kasus("Anjing Keluarga Baskerville", 4),
        new Kasus("Pembunuhan di Baker Street", 8),
        new Kasus("The Final Problem", 10)
};

while (jalan) {
    System.out.println("\n===== SIMULASI DETEKTIF =====");

    int pilihDetektif = 0;
    while (true) {
        try {
            System.out.println("Pilih Detektif:");
            System.out.println("1. Sherlock Holmes");
            System.out.println("2. Dr. Watson");
            System.out.print("Pilihan: ");
            pilihDetektif = input.nextInt();

            if (pilihDetektif == 1 || pilihDetektif == 2) break;
            else System.out.println("Pilihan harus 1 atau 2!");

        } catch (Exception e) {
            System.out.println("Input harus berupa angka!");
            input.next(); // buang input salah
        }
    }

    Detektif detektif;
    if (pilihDetektif == 1) {
        detektif = new Detektif("Sherlock Holmes", 95, 100, null);
    } else {
        detektif = new Detektif("Dr. Watson", 70, 100, null);
    }

    int pilihKasus = 0;
    while (true) {
        try {
            System.out.println("\nPilih Kasus:");
            for (int i = 0; i < daftarKasus.length; i++) {
                System.out.println((i + 1) + ". "
                        + daftarKasus[i].namaKasus
                        + " (Kesulitan: "
                        + daftarKasus[i].tingkatKesulitan + ")");
            }

            System.out.print("Pilihan: ");
            pilihKasus = input.nextInt();

            if (pilihKasus >= 1 && pilihKasus <= daftarKasus.length) break;
            else System.out.println("Pilihan tidak valid!");

        } catch (Exception e) {
            System.out.println("Input harus berupa angka!");
            input.next();
        }
    }

    Kasus kasusDipilih = daftarKasus[pilihKasus - 1];
    kasusDipilih.terpecahkan = false; // reset kasus
    detektif.kasusAktif = kasusDipilih;

    int aksi = 0;
    while (true) {
        try {
            System.out.println("\nPilih Aksi:");
            System.out.println("1. Analisis Solo");
            System.out.println("2. Investigasi Bersama");
            System.out.print("Pilihan: ");
            aksi = input.nextInt();

            if (aksi == 1 || aksi == 2) break;
            else System.out.println("Pilihan harus 1 atau 2!");

        } catch (Exception e) {
            System.out.println("Input harus berupa angka!");
            input.next();
        }
    }

    if (aksi == 1) {
        System.out.println("\n=== ANALISIS SOLO ===");
        detektif.analisisSolo();

    } else {
        System.out.println("\n=== KOLABORASI ===");
        Detektif rekan = new Detektif("Rekan Detektif", 70, 100, null);
        detektif.investigasi(rekan, kasusDipilih);
    }

    System.out.println("\n=== STATUS KASUS ===");
    kasusDipilih.infoKasus();

    System.out.println("\n=== INFO DETEKTIF ===");
    detektif.infoDetektif();

    String ulang;
    while (true) {
        System.out.print("\nIngin mencoba lagi? (y/n): ");
        ulang = input.next();

        if (ulang.equalsIgnoreCase("y") || ulang.equalsIgnoreCase("n")) {
            break;
        } else {
            System.out.println("Masukkan hanya y atau n!");
        }
    }
    
    if (ulang.equalsIgnoreCase("n")) {
        jalan = false;
    }
}
    System.out.println("\nTerima kasih telah menggunakan simulasi detektif!");
    input.close();
    }
}