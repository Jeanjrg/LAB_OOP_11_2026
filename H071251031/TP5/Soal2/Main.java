package TP5.Soal2;

public class Main {
    public static void main(String[] args) {

        SmartLamp lamp = new SmartLamp("Philips", 10);
        SmartCCTV cctv = new SmartCCTV("Xiaomi", 15);
        SmartSpeaker speaker = new SmartSpeaker("JBL", 20);

        // SmartLamp
        lamp.cekFungsi();
        lamp.infoPower();
        lamp.prosesPerintah("NYALA");

        System.out.println();

        // SmartCCTV
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWiFi();

        System.out.println();

        // SmartSpeaker
        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWiFi();
        speaker.prosesPerintah("Putar musik Hindia - Tarot");
    }
}