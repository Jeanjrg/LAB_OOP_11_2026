package H071251033.Tuprak3;

public class Main {
    public static void main(String[] args) {

        DompetDigital dompet = new DompetDigital("USR001", "123456");

        System.out.println("ID Nasabah: " + dompet.getIdNasabah());
        dompet.ubahPin("000000", "654321");
        dompet.ubahPin("123456", "654321");

        dompet.setor(500000);
        dompet.setor(-100);

        dompet.tarik(100000, "123456");
        dompet.tarik(100000, "654321");

        System.out.println("Saldo akhir: " + dompet.getSaldo());
    }
}