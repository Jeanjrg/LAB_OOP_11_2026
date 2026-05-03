import java.util.Scanner;

//superclass datar
class BangunDatar {
    double luas, keliling;
    void tampilkanHasil(String nama) {
        System.out.println("Luas " + nama + ": " + luas);
        System.out.println("Keliling " + nama + ": " + keliling);
    }
}

//superclass ruang
class BangunRuang {
    double luasPermukaan, volume;
    void tampilkanHasil(String nama) {
        System.out.println("Luas Permukaan " + nama + ": " + luasPermukaan);
        System.out.println("Volume " + nama + ": " + volume);
    }
}

//subclass ruang
class Kubus extends BangunRuang {
    double sisi;
    Kubus(double sisi) { this.sisi = sisi; }
    void hitung() {
        this.luasPermukaan = 6 * (sisi * sisi);
        this.volume = sisi * sisi * sisi;
    }
}

class Balok extends BangunRuang {
    double p, l, t;
    Balok(double p, double l, double t) { this.p = p; this.l = l; this.t = t; }
    void hitung() {
        this.luasPermukaan = 2 * ((p * l) + (p * t) + (l * t));
        this.volume = p * l * t;
    }
}

class Bola extends BangunRuang {
    double r;
    Bola(double r) { this.r = r; }
    void hitung() {
        this.luasPermukaan = 4 * Math.PI * r * r;
        this.volume = (4.0/3.0) * Math.PI * (r * r * r);
    }
}

class Tabung extends BangunRuang {
    double r, t;
    Tabung(double r, double t) { this.r = r; this.t = t; }
    void hitung() {
        this.luasPermukaan = 2 * Math.PI * r * (r + t);
        this.volume = Math.PI * r * r * t;
    }
}

//subclass datar
class Persegi extends BangunDatar {
    double sisi;
    Persegi(double sisi) { this.sisi = sisi; }
    void hitung() {
        this.luas = sisi * sisi;
        this.keliling = 4 * sisi;
    }
}

class PersegiPanjang extends BangunDatar {
    double p, l;
    PersegiPanjang(double p, double l) { this.p = p; this.l = l; }
    void hitung() {
        this.luas = p * l;
        this.keliling = 2 * (p + l);
    }
}

class Lingkaran extends BangunDatar {
    double r;
    Lingkaran(double r) { this.r = r; }
    void hitung() {
        this.luas = Math.PI * r * r;
        this.keliling = 2 * Math.PI * r;
    }
}

class Trapesium extends BangunDatar {
    double s1, s2, s3, s4, tinggi;
    Trapesium(double s1, double s2, double s3, double s4, double tinggi) {
        this.s1 = s1; this.s2 = s2; this.s3 = s3; this.s4 = s4; this.tinggi = tinggi;
    }
    void hitung() {
        this.luas = ((s1 + s2) * tinggi) / 2;
        this.keliling = s1 + s2 + s3 + s4;
    }
}

//main class
public class Geometri {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan = 0;
        
        while (pilihan < 1 || pilihan > 8) {
            System.out.println("\n---------------------------------------");
            System.out.println("====== BANGUN RUANG ======");
            System.out.println("1. KUBUS\n2. BALOK\n3. BOLA\n4. TABUNG");
            System.out.println("\n====== BANGUN DATAR ======");
            System.out.println("5. PERSEGI\n6. PERSEGI PANJANG\n7. LINGKARAN\n8. TRAPESIUM");
            System.out.println("---------------------------------------");
            System.out.print("Pilihan: ");

            if (input.hasNextInt()) {
                pilihan = input.nextInt();
                if (pilihan < 1 || pilihan > 8) System.out.println("Pilihan tidak tersedia!");
            } else {
                System.out.println("Error: Masukkan angka!");
                input.next();
            }
        }

        System.out.println("---------------------------------------");

        switch (pilihan) {
            case 1:
                System.out.print("Sisi Kubus: "); Kubus kbs = new Kubus(input.nextDouble());
                kbs.hitung(); kbs.tampilkanHasil("Kubus"); break;
            case 2:
                System.out.print("Panjang: "); double p = input.nextDouble();
                System.out.print("Lebar: "); double l = input.nextDouble();
                System.out.print("Tinggi: "); double t = input.nextDouble();
                Balok blk = new Balok(p, l, t); blk.hitung(); blk.tampilkanHasil("Balok"); break;
            case 3:
                System.out.print("Jari-jari Bola: "); Bola bla = new Bola(input.nextDouble());
                bla.hitung(); bla.tampilkanHasil("Bola"); break;
            case 4:
                System.out.print("Jari-jari: "); double rT = input.nextDouble();
                System.out.print("Tinggi: "); double tT = input.nextDouble();
                Tabung tbg = new Tabung(rT, tT); tbg.hitung(); tbg.tampilkanHasil("Tabung"); break;
            case 5:
                System.out.print("Sisi Persegi: "); Persegi psg = new Persegi(input.nextDouble());
                psg.hitung(); psg.tampilkanHasil("Persegi"); break;
            case 6:
                System.out.print("Panjang: "); double pp = input.nextDouble();
                System.out.print("Lebar: "); double lp = input.nextDouble();
                PersegiPanjang pjg = new PersegiPanjang(pp, lp); pjg.hitung(); pjg.tampilkanHasil("Persegi Panjang"); break;
            case 7:
                System.out.print("Jari-jari Lingkaran: "); Lingkaran lkr = new Lingkaran(input.nextDouble());
                lkr.hitung(); lkr.tampilkanHasil("Lingkaran"); break;
            case 8:
                System.out.print("Sisi 1: "); double s1 = input.nextDouble();
                System.out.print("Sisi 2: "); double s2 = input.nextDouble();
                System.out.print("Sisi 3: "); double s3 = input.nextDouble();
                System.out.print("Sisi 4: "); double s4 = input.nextDouble();
                System.out.print("Tinggi: "); double tg = input.nextDouble();
                Trapesium tps = new Trapesium(s1, s2, s3, s4, tg); tps.hitung(); tps.tampilkanHasil("Trapesium"); break;
        }
        input.close();
    }
}