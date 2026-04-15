public class main {
    public static void main(String[] args) {
        DompetDigital dompet1 = new DompetDigital(0, "Ade Fahreza", "adezar", 1000000, "081234509876");
        dompet1.setPin("dezz", "09876");
        dompet1.setPin("adezar", "123456");
        dompet1.narikSetoran(100000);
        dompet1.narikSetoran(-15000);
        dompet1.tarikTunai("adezar", 50000);
        dompet1.tarikTunai("123456", 50000);
        System.out.println(dompet1.getSaldo());

    }
}