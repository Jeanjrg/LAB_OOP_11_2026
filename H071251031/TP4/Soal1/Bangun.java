package TP4.Soal1;

// SUPER CLASS
public class Bangun {
    void hitung() {
    }
}

class BangunDatar extends Bangun {
    double luas;
    double keliling;
}

class Persegi extends BangunDatar {
    double sisi;

    @Override
    void hitung() {
        luas = sisi * sisi;
        keliling = 4 * sisi;
    }
}

class PersegiPanjang extends BangunDatar {
    double p, l;

    @Override
    void hitung() {
        luas = p * l;
        keliling = 2 * (p + l);
    }
}

class Lingkaran extends BangunDatar {
    double r;

    @Override
    void hitung() {
        luas = Math.PI * r * r;
        keliling = 2 * Math.PI * r;
    }
}

class Trapesium extends BangunDatar {
    double a, b, c, d, t;

    @Override
    void hitung() {
        luas = 0.5 * (a + b) * t;
        keliling = a + b + c + d;
    }
}

class BangunRuang extends Bangun {
    double luasPermukaan;
    double volume;
}

class Kubus extends BangunRuang {
    double sisi;

    @Override
    void hitung() {
        luasPermukaan = 6 * sisi * sisi;
        volume = sisi * sisi * sisi;
    }
}

class Balok extends BangunRuang {
    double p, l, t;

    @Override
    void hitung() {
        luasPermukaan = 2 * (p*l + p*t + l*t);
        volume = p * l * t;
    }
}

class Bola extends BangunRuang {
    double r;

    @Override
    void hitung() {
        luasPermukaan = 4 * Math.PI * r * r;
        volume = (4.0/3.0) * Math.PI * r * r * r;
    }
}

class Tabung extends BangunRuang {
    double r, t;

    @Override
    void hitung() {
        luasPermukaan = 2 * Math.PI * r * (r + t);
        volume = Math.PI * r * r * t;
    }
}