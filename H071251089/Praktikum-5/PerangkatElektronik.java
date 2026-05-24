interface IInteraksiInternet {
    void hubungkanWifi();
}

interface IKontrolSuara {
    void prosesPerintah(String perintah);
}

public abstract class PerangkatElektronik {
    String merk;
    double dayaListrik;

    public PerangkatElektronik(String merk, double dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    public abstract void cekFungsi();
    
    public void infoPower() {
        System.out.println(this.merk + " sedang menyedot daya sebesar " + this.dayaListrik + " Watt.");
    }
}

class SmartLamp extends PerangkatElektronik implements IKontrolSuara {
    public SmartLamp(String merk, double dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Merek Lampu : " + this.merk);
        System.out.println("Daya Listrik Lampu : " + this.dayaListrik);
        System.out.println("Fungsi : Penerangan Ruangan.\n");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Lampu memproses perintah : " + perintah);
        if (perintah.equals("NYALA")) {
            System.out.println("Lampu Berpijar!");
        } else {
            System.out.println("lampu Masih OFF!");
        }
    }
}

class SmartCCTV extends PerangkatElektronik implements IInteraksiInternet {
    public SmartCCTV(String merk, double dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Merek CCTV : " + this.merk);
        System.out.println("Daya Listrik CCTV : " + this.dayaListrik);
        System.out.println("Fungsi : Pengawas Keamanan.\n");
    }

    @Override
    public void hubungkanWifi() {
        System.out.println("CCTV terhubung. Mengirim data ke server ...");
    }
}

class SmartSpeaker extends PerangkatElektronik implements IInteraksiInternet, IKontrolSuara {
    public SmartSpeaker(String merk, double dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Merek Speaker : " + this.merk);
        System.out.println("Daya Listrik Speaker : " + this.dayaListrik);
        System.out.println("Fungsi : Pmembantu Suara dan Musik\n");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equals("NYALA")) {
            System.out.println("Speaker Bersuara!");
        } else {
            System.out.println("Speaker Masih OFF!");
        }
    }

    @Override
    public void hubungkanWifi() {
        System.out.println("Speaker terhubung. Mengirim data ke server ...");
    }
}