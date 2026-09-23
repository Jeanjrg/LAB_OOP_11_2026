class BangunDatar extends BangunGeometri {

    // 5. Persegi 
    void hitungPersegi(double sisi) {
        luas = sisi * sisi;
        keliling = 4 * sisi;
        System.out.printf("\nLuas Persegi: %.1f", luas);
        System.out.printf("\nKeliling Persegi: %.1f", keliling);
    }

    // 6. Persegi Panjang 
    void hitungPersegiPanjang(double panjang, double lebar) {
        luas = panjang * lebar;
        keliling = 2 * (panjang * lebar);
        System.out.printf("\nLuas Persegi Panjang: %.1f", luas);
        System.out.printf("\nKeliling Persegi Panjang: %.1f", keliling);
    }

    // 7. Lingkaran 
    void hitungLingkaran(double jari2) {
        luas = Math.PI * jari2 * jari2;
        keliling = 2 * Math.PI * jari2;
        System.out.printf("\nLuas Lingkaran: %.1f", luas);
        System.out.printf("\nKeliling Lingkaran: %.1f", keliling);
    }

    // 8. Trapesium 
    void hitungTrapesium(double sisi1, double sisi2, double sisi3, double sisi4, double t) {
        luas = 0.5 * (sisi1 + sisi2) * t;
        keliling = sisi1 + sisi2 + sisi3 + sisi4;
        System.out.printf("\nLuas Trapesium: %.1f", luas);
        System.out.printf("\nKeliling Trapesium: %.1f", keliling);
    }
}
