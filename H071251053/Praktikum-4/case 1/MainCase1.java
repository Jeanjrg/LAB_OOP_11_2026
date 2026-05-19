import java.util.Scanner;

public class MainCase1 {
    
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        BangunRuang ruang = new BangunRuang();
        BangunDatar datar = new BangunDatar();

        System.out.println("======== BANGUN RUANG ========"); 
        System.out.println("1. KUBUS"); 
        System.out.println("2. BALOK"); 
        System.out.println("3. BOLA"); 
        System.out.println("4. TABUNG"); 
        System.out.println("\n======== BANGUN DATAR ========"); 
        System.out.println("5. PERSEGI"); 
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN"); 
        System.out.println("8. TRAPESIUM"); 
        
        System.out.print("\nPilihan: "); 
        int pilihan = a.nextInt();
        System.out.println("------------------------------");

        switch (pilihan) {
            case 1:
                System.out.println("Masukkan sisi kubus: ");
                double sisi = a.nextDouble();
                ruang.hitungKubus(sisi);
                break;
            case 2:
                System.out.println("Masukkan panjang balok: ");
                double panjang = a.nextDouble();
                System.out.println("Masukkan lebar balok: ");
                double lebar = a.nextDouble();
                System.out.println("Masukkan tinggi balok: ");
                double tinggi = a.nextDouble();
                ruang.hitungBalok(panjang, lebar, tinggi);
                break;
            case 3:
                System.out.println("Masukkan jari-jari bola: ");
                double jari2 = a.nextDouble();
                ruang.hitungBola(jari2);
                break;
            case 4:
                System.out.println("Masukkan jari-jari tabung: ");
                double jarijari = a.nextDouble();
                System.out.println("Masukkan tinggi tabung: ");
                double t = a.nextDouble();
                ruang.hitungTabung(jarijari, t);
                break;
            case 5:
                System.out.println("Masukkan sisi persegi: ");
                double s = a.nextDouble();
                datar.hitungPersegi(s);
                break;
            case 6:
                System.out.println("Masukkan panjang persegi panjang: ");
                double p = a.nextDouble();
                System.out.println("Masukkan lebar persegi panjang: ");
                double l = a.nextDouble();
                datar.hitungPersegiPanjang(p, l);
                break;
            case 7:
                System.out.println("Masukkan jari-jari lingkaran: ");
                double jari = a.nextDouble();
                datar.hitungPersegi(jari);
                break;
            case 8: 
                System.out.print("Masukkan sisi 1 trapesium: ");
                double s1 = a.nextDouble();
                System.out.print("Masukkan sisi 2 trapesium: ");
                double s2 = a.nextDouble();
                System.out.print("Masukkan sisi 3 trapesium: ");
                double s3 = a.nextDouble();
                System.out.print("Masukkan sisi 4 trapesium: ");
                double s4 = a.nextDouble();
                System.out.print("Masukkan tinggi trapesium: ");
                double tnggi = a.nextDouble();
                datar.hitungTrapesium(s1, s2, s3, s4, tnggi); // 
                break;
            default: System.out.println("Maaf, inputan tidak valid.");
        }
        System.out.println("\n------------------------------");
        a.close();
    }
}
