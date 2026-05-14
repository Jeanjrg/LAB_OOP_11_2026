package H071251033.Tuprak4.Nomor1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Bangun Datar");
            System.out.println("2. Bangun Ruang");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    menuBangunDatar(input);
                    break;
                case 2:
                    menuBangunRuang(input);
                    break;
                case 3:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 3);

        input.close();
    }

    public static void menuBangunDatar(Scanner input) {
        System.out.println("\n1. Persegi\n2. Persegi Panjang\n3. Lingkaran\n4. Trapesium");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();

        switch (pilih) {
            case 1:
                System.out.print("Sisi: ");
                new Persegi(input.nextDouble()).tampil();
                break;
            case 2:
                System.out.print("Panjang: ");
                double p = input.nextDouble();
                System.out.print("Lebar: ");
                double l = input.nextDouble();
                new PersegiPanjang(p, l).tampil();
                break;
            case 3:
                System.out.print("Jari-jari: ");
                new Lingkaran(input.nextDouble()).tampil();
                break;
            case 4:
                System.out.print("Atas: ");
                double a = input.nextDouble();
                System.out.print("Bawah: ");
                double b = input.nextDouble();
                System.out.print("Miring1: ");
                double m1 = input.nextDouble();
                System.out.print("Miring2: ");
                double m2 = input.nextDouble();
                System.out.print("Tinggi: ");
                double t = input.nextDouble();
                new Trapesium(a,b,m1,m2,t).tampil();
                break;
        }
    }

    public static void menuBangunRuang(Scanner input) {
        System.out.println("\n1. Kubus\n2. Balok\n3. Bola\n4. Tabung");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();

        switch (pilih) {
            case 1:
                System.out.print("Sisi: ");
                new Kubus(input.nextDouble()).tampil();
                break;
            case 2:
                System.out.print("Panjang: ");
                double p = input.nextDouble();
                System.out.print("Lebar: ");
                double l = input.nextDouble();
                System.out.print("Tinggi: ");
                double t = input.nextDouble();
                new Balok(p,l,t).tampil();
                break;
            case 3:
                System.out.print("Jari-jari: ");
                new Bola(input.nextDouble()).tampil();
                break;
            case 4:
                System.out.print("Jari-jari: ");
                double r = input.nextDouble();
                System.out.print("Tinggi: ");
                double tt = input.nextDouble();
                new Tabung(r,tt).tampil();
                break;
        }
    }
}