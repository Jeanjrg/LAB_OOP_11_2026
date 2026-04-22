package TP3;

// import java.util.Scanner;

public class Main {
    // static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Sistem Dompet Digital ===\n");

        DompetDigital dompet = new DompetDigital("USR-20250001", "123456");

        // System.out.println("Pilih Mode:");
        // System.out.println("1. Mode Sesuai Urutan");
        // System.out.println("2. Mode Interaktif");
        //     int mode;
        //     while (true) {
        //         mode = inputAngka("Masukkan pilihan: ");
        //         if (mode == 1 || mode == 2) {
        //             break;
        //         }
        //         System.out.println("Pilihan hanya 1 atau 2!");
        //     }

        // if (mode == 1) {
            System.out.println("\n=== MODE DEMO OTOMATIS ===");

            // 1. Info akun
            System.out.println("\n[1] Info Akun");
            System.out.println("ID Nasabah  : " + dompet.getIdNasabah());
            System.out.println("Status Akun : " + dompet.getStatusAkun());
            System.out.printf("Saldo       : Rp%.0f%n", dompet.getSaldo());

            // 2. Ubah PIN salah
            System.out.println("\n[2] Ubah PIN (Salah)");
            dompet.setPinBaru("000000", "654321");

            // 3. Ubah PIN benar
            System.out.println("\n[3] Ubah PIN (Benar)");
            dompet.setPinBaru("123456", "654321");

            // 4. Setor valid
            System.out.println("\n[4] Setor Tunai (Valid)");
            dompet.setoran(5000);

            // 5. Setor ilegal
            System.out.println("\n[5] Setor Tunai (Negatif)");

            // dompet.setorTunai(-50000);

            // 6. Tarik PIN salah
            System.out.println("\n[6] Tarik Tunai (PIN Salah)");
            dompet.tarikTunai(50000, "123456");

            // 7. Tarik PIN benar
            System.out.println("\n[7] Tarik Tunai (PIN Benar)");
            dompet.tarikTunai(50000, "654321");

            // 8. Saldo akhir
            System.out.println("\n[8] Saldo Akhir");
            System.out.printf("Saldo akhir: Rp%.0f%n", dompet.getSaldo());

            System.out.println("\n=== DEMO SELESAI ===");
            return;
    }
}
//                 boolean running = true;
//                 while (running) {
//                     System.out.println("\n=== MENU INTERAKTIF ===");
//                     System.out.println("1. Lihat Info Akun");
//                     System.out.println("2. Ubah PIN");
//                     System.out.println("3. Setor Tunai");
//                     System.out.println("4. Tarik Tunai");
//                     System.out.println("5. Cek Saldo");
//                     System.out.println("0. Keluar");

//             int pilihan = inputAngka("Pilih menu: ");

//             switch (pilihan) {
//                 case 1 -> {
//                     System.out.println("\nInfo Akun");
//                     System.out.println("ID Nasabah  : " + dompet.getIdNasabah());
//                     System.out.println("Status Akun : " + dompet.getStatusAkun());
//                     System.out.printf("Saldo       : Rp%.0f%n", dompet.getSaldo());
//                 }
//                 case 2 -> {
//                     System.out.println("\nUbah PIN");
//                     System.out.print("PIN lama : ");
//                     String pinLama = scanner.nextLine().trim();
//                     System.out.print("PIN baru : ");
//                     String pinBaru = scanner.nextLine().trim();
//                     dompet.setPinBaru(pinLama, pinBaru);
//                 }
//                 case 3 -> {
//                     System.out.println("\nSetor Tunai");
//                     double nominal = inputDouble("Nominal (Rp): ");
//                     dompet.setorTunai(nominal);
//                 }
//                 case 4 -> {
//                     System.out.println("\nTarik Tunai");
//                     double nominal = inputDouble("Nominal (Rp): ");
//                     System.out.print("PIN : ");
//                     String pin = scanner.nextLine().trim();
//                     dompet.tarikTunai(nominal, pin);
//                 }
//                 case 5 -> {
//                     System.out.println("\nCek Saldo");
//                     System.out.printf("Saldo Anda: Rp%.0f%n", dompet.getSaldo());
//                 }
//                 case 0 -> {
//                     System.out.println("Terima kasih. Program selesai.");
//                     running = false;
//                 }
//                 default -> System.out.println("Pilihan tidak valid, coba lagi.");
//             }
//         }

//         scanner.close();
//     }

//     static int inputAngka(String prompt) {
//         while (true) {
//             System.out.print(prompt);
//             try {
//                 return Integer.parseInt(scanner.nextLine().trim());
//             } catch (NumberFormatException e) {
//                 System.out.println("Masukkan angka yang valid.");
//             }
//         }
//     }

//     static double inputDouble(String prompt) {
//         while (true) {
//             System.out.print(prompt);
//             try {
//                 return Double.parseDouble(scanner.nextLine().trim());
//             } catch (NumberFormatException e) {
//                 System.out.println("Masukkan nominal yang valid.");
//             }
//         }
//     }
// }