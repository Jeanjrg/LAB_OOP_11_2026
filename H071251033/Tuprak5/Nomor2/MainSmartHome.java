package H071251033.Tuprak5.Nomor2;

public class MainSmartHome {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp("Philips", 12.0);
        SmartCCTV cctv = new SmartCCTV("Xiaomi", 15.0);
        SmartSpeaker speaker = new SmartSpeaker("Google Nest", 25.0);

        System.out.println("--- Uji Coba Smart Lamp ---");
        lampu.infoPower();
        lampu.prosesPerintah("NYALA");

        System.out.println("\n--- Uji Coba Smart CCTV ---");
        cctv.infoPower();
        cctv.hubungkanWiFi();

        System.out.println("\n--- Uji Coba Smart Speaker ---");
        speaker.infoPower();        
        speaker.cekFungsi();        
        speaker.hubungkanWiFi();     
        speaker.prosesPerintah("Putar lagu favorit"); 
    }
}