public class Main {
    public static void main(String[] args) {

        DompetDigital akun = new DompetDigital("IDN001", "777777");

        System.out.println("ID Nasabah: " + akun.getIdNasabah());

        akun.ubahPin("123456", "111111");
        akun.ubahPin("777777", "111111");

        akun.transfer(100000);
        akun.transfer(-5000);

        akun.tarik(20000, "777777");
        akun.tarik(20000, "111111");

        System.out.println("Saldo akhir: Rp" + (int) akun.getSaldo());
    }
}