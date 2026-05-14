package H071251033.Tuprak5.Nomor2;

public class SmartLamp extends PerangkatElektronik implements KontrolSuara {
    
    public SmartLamp(String merk, double dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Fungsi SmartLamp: Memberikan pencahayaan pintar.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        } else {
            System.out.println("Lampu menunggu perintah 'NYALA'.");
        }
    }
}