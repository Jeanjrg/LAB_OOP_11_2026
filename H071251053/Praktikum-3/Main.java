public class Main {
    
    public static void main(String[] args) {
        DompetDigital ewallet = new DompetDigital("MyNasabahId", "123456");

        System.out.println("\n===== Informasi Akun =====");
        System.out.println("ID Nasabah: " + ewallet.getIdNasabah());
        System.out.println("Mata Uang: " + ewallet.getMataUang());

        System.out.println("\n1. Uji Ubah PIN (salah)");
        ewallet.setPin("111111", "654321");

        System.out.println("\n2. Uji Ubah PIN (benar)");
        ewallet.setPin("123456", "654321");

        System.out.println("\n3. Setor Tunai Valid");
        ewallet.getSetorTunai(500000);

        System.out.println("\n4. Setor Tunai Tidak Valid");
        ewallet.getSetorTunai(-100000);

        System.out.println("\n5. Tarik Tunai dengan PIN Lama");
        ewallet.tarikTunai(100000, "123456");

        System.out.println("\n6. Tarik Tunai dengan PIN Baru");
        ewallet.tarikTunai(100000, "654321");

        System.out.println("\n===== Saldo Akhir =====");
        System.out.println("Saldo Akhir : Rp" + ewallet.getSaldo());
    }
}
