public class MainSmartHome {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp("Philips", 20);
        SmartCCTV cctv = new SmartCCTV("UNHAS", 50);
        SmartSpeaker speaker = new SmartSpeaker("JBL", 30);

        speaker.infoPower(); 
        speaker.cekFungsi();

        speaker.hubungkanWiFi();

        speaker.prosesPerintah("Putar Musik");
    }
}