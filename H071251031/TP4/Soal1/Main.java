package TP4.Soal1;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
            System.out.println("==========================================");
            System.out.println("=====         BANGUN RUANG           =====");
            System.out.println("1. KUBUS");
            System.out.println("2. BALOK");
            System.out.println("3. BOLA");
            System.out.println("4. TABUNG");

            System.out.println("\n=====         BANGUN DATAR          =====");
            System.out.println("5. PERSEGI");
            System.out.println("6. PERSEGI PANJANG");
            System.out.println("7. LINGKARAN");
            System.out.println("8. TRAPESIUM");
            System.out.println("==========================================");

            System.out.print("\nPilihan: ");
            int pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    Kubus k = new Kubus();
                    System.out.print("Masukkan sisi: ");
                    k.sisi = input.nextDouble();
                    k.hitung();
                    System.out.println("Luas Permukaan Kubus: " + k.luasPermukaan);
                    System.out.println("Volume Kubus: " + k.volume);
                    break;

                case 2:
                    Balok b = new Balok();
                    System.out.print("Panjang: ");
                    b.p = input.nextDouble();
                    System.out.print("Lebar: ");
                    b.l = input.nextDouble();
                    System.out.print("Tinggi: ");
                    b.t = input.nextDouble();
                    b.hitung();
                    System.out.println("Luas Permukaan Balok: " + b.luasPermukaan);
                    System.out.println("Volume Balok: " + b.volume);
                    break;

                case 3:
                    Bola bo = new Bola();
                    System.out.print("Jari-jari: ");
                    bo.r = input.nextDouble();
                    bo.hitung();
                    System.out.println("Luas Permukaan Bola: " + bo.luasPermukaan);
                    System.out.println("Volume Bola: " + bo.volume);
                    break;

                case 4:
                    Tabung tb = new Tabung();
                    System.out.print("Jari-jari: ");
                    tb.r = input.nextDouble();
                    System.out.print("Tinggi: ");
                    tb.t = input.nextDouble();
                    tb.hitung();
                    System.out.println("Luas Permukaan Tabung: " + tb.luasPermukaan);
                    System.out.println("Volume Tabung: " + tb.volume);
                    break;

                case 5:
                    Persegi p = new Persegi();
                    System.out.print("Sisi: ");
                    p.sisi = input.nextDouble();
                    p.hitung();
                    System.out.println("Luas Persegi: " + p.luas);
                    System.out.println("Keliling Persegi: " + p.keliling);
                    break;

                case 6:
                    PersegiPanjang pp = new PersegiPanjang();
                    System.out.print("Panjang: ");
                    pp.p = input.nextDouble();
                    System.out.print("Lebar: ");
                    pp.l = input.nextDouble();
                    pp.hitung();
                    System.out.println("Luas Persegi Panjang: " + pp.luas);
                    System.out.println("Keliling Persegi Panjang: " + pp.keliling);
                    break;

                case 7:
                    Lingkaran l = new Lingkaran();
                    System.out.print("Jari-jari: ");
                    l.r = input.nextDouble();
                    l.hitung();
                    System.out.println("Luas Lingkaran: " + l.luas);
                    System.out.println("Keliling Lingkaran: " + l.keliling);
                    break;

                case 8:
                    Trapesium t = new Trapesium();
                   System.out.print("Sisi Atas: ");
                    t.a = input.nextDouble();
                    System.out.print("Sisi Bawah: ");
                    t.b = input.nextDouble();
                    System.out.print("Sisi Miring 1: ");
                    t.c = input.nextDouble();
                    System.out.print("Sisi Miring 2: ");
                    t.d = input.nextDouble();
                    System.out.print("Tinggi: ");
                    t.t = input.nextDouble();
                    t.hitung();
                    System.out.println("Luas Trapesium: " + t.luas);
                    System.out.println("Keliling Trapesium: " + t.keliling);
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

        System.out.println("\nProgram selesai.");
        input.close();
    }
}