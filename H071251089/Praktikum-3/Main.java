public class Main {
    public static void main(String[] args) {
        DompetDigital dompet = new DompetDigital("140407", "312-9098");

        System.out.println("--- Pengujian Aplikasi " + dompet.namaAplikasi + " ---");

        // Informasi identitas akun menggunakan Getter.
        System.out.println("\n1. Informasi identitas akun menggunakan Getter.");
        System.out.println("ID Nasabah : " + dompet.idNasabah);

        // Uji coba metode Setter (Ubah PIN) dengan memasukkan PIN lama yang salah.
        System.out.println("\n2. Uji coba metode Setter (Ubah PIN) dengan memasukkan PIN lama yang salah.");
        dompet.setPinBaru("@140407", "098765");

        // Uji coba metode Setter (Ubah PIN) dengan memenuhi syarat yang benar.
        System.out.println("\n3. Uji coba metode Setter (Ubah PIN) dengan memenuhi syarat yang benar.");
        dompet.setPinBaru("140407", "098765");

        // Setor tunai dengan nominal yang valid.
        System.out.println("\n4. Setor tunai dengan nominal yang valid.");
        dompet.setorTunai(1250000);

        // Setor tunai dengan nominal yang nonvalid.
        System.out.println("\n5. Setor tunai dengan nominal yang nonvalid.");
        dompet.setorTunai(-500000);

        // Tarik tunai menggunakan PIN yang benar.
        System.out.println("\n5. Tarik tunai menggunakan PIN yang benar.");
        dompet.tarikTunai("098765", 250000);

        // Tarik tunai menggunakan PIN yang salh.
        System.out.println("\n6. Tarik tunai menggunakan PIN yang salah.");
        dompet.tarikTunai("123456", 250000);

        //Informasi Sisa Saldo
        System.out.println("\n--- Informasi Sisa Saldo ---");
        System.out.println("Sisa Saldo : " + dompet.getSisaSaldo());
    }
}