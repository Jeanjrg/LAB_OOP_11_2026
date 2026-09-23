public class Main {
    
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp("Philips", 15);
        SmartCCTV cctv = new SmartCCTV("Xiaomi", 10);
        SmartSpeaker speaker = new SmartSpeaker("Google Home", 30);

        System.out.println("\n=== SMART LAMP ===");
        lampu.cekFungsi();
        lampu.infoPower();
        lampu.prosesPerintah("Nyala");

        System.out.println("\n=== SMART CCTV ===");
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWifi();

        System.out.println("\n=== SMART SPEAKER ===");
        speaker.infoPower();
        speaker.cekFungsi();
        speaker.hubungkanWifi();
        
        speaker.prosesPerintah("Putar lagu jazz.");
    }
}
