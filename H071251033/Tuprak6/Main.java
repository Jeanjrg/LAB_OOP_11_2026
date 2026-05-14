package H071251033.Tuprak6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Status Perpustakaan");
            System.out.println("6. Lihat Log");
            System.out.println("7. Lihat Pinjaman Member");
            System.out.println("8. Keluar");

            System.out.print("Pilih menu: ");
            String pilihan = sc.nextLine();

            try {
                switch (pilihan) {

                    case "1":
                        System.out.println("\n=== Tambah Item ===");
                        System.out.print("Tipe (1. Buku / 2. DVD): ");
                        int tipe = Integer.parseInt(sc.nextLine());

                        System.out.print("Judul: ");
                        String title = sc.nextLine();

                        System.out.print("ID Item: ");
                        int itemId = Integer.parseInt(sc.nextLine());

                        if (tipe == 1) {
                            System.out.print("Penulis: ");
                            String author = sc.nextLine();

                            Book book = new Book(title, itemId, author);

                            System.out.println(lib.addItem(book));

                        } else if (tipe == 2) {
                            System.out.print("Durasi (menit): ");
                            int duration = Integer.parseInt(sc.nextLine());

                            DVD dvd = new DVD(title, itemId, duration);

                            System.out.println(lib.addItem(dvd));

                        } else {
                            System.out.println("Tipe item tidak valid.");
                        }

                        break;

                    case "2":
                        System.out.println("\n=== Tambah Anggota ===");

                        System.out.print("Nama: ");
                        String nama = sc.nextLine();

                        System.out.print("ID Member: ");
                        String memberId = sc.nextLine();

                        Member member = new Member(nama, memberId);

                        lib.addMember(member);

                        System.out.println("Member berhasil ditambahkan.");

                        break;

                    case "3":
                        System.out.println("\n=== Peminjaman Item ===");

                        System.out.print("ID Member: ");
                        Member peminjam = lib.findMemberById(sc.nextLine());

                        System.out.print("ID Item: ");
                        LibraryItem itemPinjam = lib.findItemById(
                                Integer.parseInt(sc.nextLine())
                        );

                        System.out.print("Lama pinjam (hari): ");
                        int days = Integer.parseInt(sc.nextLine());

                        String borrowResult = peminjam.borrow(itemPinjam, days);

                        System.out.println(borrowResult);

                        lib.getLogger().logActivity(
                                itemPinjam.getTitle()
                                        + " dipinjam oleh "
                                        + peminjam.getName()
                        );

                        break;

                    case "4":
                        System.out.println("\n=== Pengembalian Item ===");

                        System.out.print("ID Member: ");
                        Member pengembali = lib.findMemberById(sc.nextLine());

                        System.out.print("ID Item: ");
                        LibraryItem itemKembali = lib.findItemById(
                                Integer.parseInt(sc.nextLine())
                        );

                        System.out.print("Keterlambatan (hari): ");
                        int daysLate = Integer.parseInt(sc.nextLine());

                        String returnResult = pengembali.returnItem(
                                itemKembali,
                                daysLate
                        );

                        System.out.println(returnResult);

                        lib.getLogger().logActivity(
                                itemKembali.getTitle()
                                        + " dikembalikan oleh "
                                        + pengembali.getName()
                        );

                        break;

                    case "5":
                        System.out.println("\n=== Status Perpustakaan ===");
                        System.out.println(lib.getLibraryStatus());

                        break;

                    case "6":
                        System.out.println("\n=== Log Aktivitas ===");
                        System.out.println(lib.getAllLogs());

                        break;

                    case "7":
                        System.out.println("\n=== Daftar Pinjaman Member ===");

                        System.out.print("ID Member: ");

                        Member memberPinjaman = lib.findMemberById(
                                sc.nextLine()
                        );

                        memberPinjaman.getBorrowedItems();

                        break;

                    case "8":
                        System.out.println("Program selesai.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Menu tidak valid.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}