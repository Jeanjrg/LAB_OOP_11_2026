class BangunRuang extends BangunGeometri {
    
    // 1. Kubus 
    void hitungKubus(double sisi) {
        luas = 6 * (sisi * sisi);
        volume = Math.pow(sisi, 3);
        System.out.printf("\nLuas Kubus: %.1f", luas);
        System.out.printf("\nVolume Kubus: %.1f", volume);
    }

    // 2. Balok 
    void hitungBalok(double panjang, double lebar, double tinggi) {
        luas = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
        volume = panjang * lebar * tinggi;
        System.out.printf("\nLuas Balok: %.1f", luas);
        System.out.printf("\nVolume Balok: %.1f", volume);
    }

    // 3. Bola 
    void hitungBola(double jari2) {
        luas = 4 * Math.PI * Math.pow(jari2, 2);
        volume = (4.0 / 3.0) * Math.PI * Math.pow(jari2, 3);
        System.out.printf("\nLuas Bola: %.1f", luas);
        System.out.printf("\nVolume Bola: %.1f", volume);
    }

    // 4. Tabung 
    void hitungTabung(double jari2, double t) {
        luas = 2 * Math.PI * jari2 * (jari2 + t);
        volume = Math.PI * Math.pow(jari2, 2) * t;
        System.out.printf("\nLuas Tabung: %.1f", luas);
        System.out.printf("\nVolume Tabung: %.1f", volume);
    }
}
