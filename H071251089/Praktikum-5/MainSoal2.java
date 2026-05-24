public class MainSoal2 {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp("Yeelight", 10);
        SmartCCTV cctv = new SmartCCTV("EZVIZ", 12);
        SmartSpeaker speaker = new SmartSpeaker("Amazon Echo", 15);

        // Uji coba Smart Lampu
        lampu.cekFungsi();
        lampu.prosesPerintah("NYALA");
        lampu.infoPower();
        System.out.println("------------------------------------");

        // Uji coba Smart CCTV
        cctv.cekFungsi();
        cctv.hubungkanWifi();
        cctv.infoPower();
        System.out.println("------------------------------------");

        // Uji coba Smart Speaker
        speaker.cekFungsi();
        speaker.hubungkanWifi();
        speaker.prosesPerintah("NYALA".toUpperCase());
        speaker.infoPower();
    }
}
