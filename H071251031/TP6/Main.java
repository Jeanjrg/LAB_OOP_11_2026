package TP6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n=== SISTEM PERPUSTAKAAN ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = input.nextInt();
            input.nextLine(); // buang newline

            try {
                switch (pilihan) {

                    case 1:
                        System.out.println("\nPilih Jenis Item:");
                        System.out.println("1. Buku");
                        System.out.println("2. DVD");
                        System.out.print("Pilihan: ");
                        int jenis = input.nextInt();
                        input.nextLine();

                        System.out.print("Judul: ");
                        String title = input.nextLine();

                        System.out.print("ID: ");
                        int id = input.nextInt();
                        input.nextLine();

                        if (jenis == 1) {
                            System.out.print("Author: ");
                            String author = input.nextLine();

                            Book book = new Book(title, id, author);
                            System.out.println(library.addItem(book));

                        } else if (jenis == 2) {
                            System.out.print("Durasi (menit): ");
                            int duration = input.nextInt();

                            DVD dvd = new DVD(title, id, duration);
                            System.out.println(library.addItem(dvd));

                        } else {
                            System.out.println("Jenis tidak valid.");
                        }
                        break;

                    case 2:
                        System.out.print("Nama: ");
                        String name = input.nextLine();

                        System.out.print("ID Member: ");
                        int mId = input.nextInt();

                        Member member = new Member(name, mId);
                        library.members.add(member);

                        System.out.println("Member berhasil ditambahkan.");
                        break;

                    case 3: // Pinjam Item
                        System.out.print("ID Member: ");
                        int borrowMemberId = input.nextInt();

                        System.out.print("ID Item: ");
                        int itemId = input.nextInt();

                        System.out.print("Jumlah hari: ");
                        int days = input.nextInt();

                        Member m = library.findMemberById(borrowMemberId);
                        LibraryItem item = library.findItemById(itemId);

                        String result = m.borrow(item, days);
                        library.logger.logBorrow(item.title, m.name);
                        System.out.println(result);
                        break;

                    case 4: // Kembalikan Item
                        System.out.print("ID Member: ");
                        int returnMemberId = input.nextInt();

                        System.out.print("ID Item: ");
                        int returnItemId = input.nextInt();

                        System.out.print("Hari keterlambatan: ");
                        int late = input.nextInt();

                        Member rm = library.findMemberById(returnMemberId);
                        LibraryItem rItem = library.findItemById(returnItemId);

                        String res = rm.returnItem(rItem, late);
                        library.logger.logReturn(rItem.title, rm.name);
                        System.out.println(res);
                        break;

                    case 5: // Status
                        System.out.println("\n=== STATUS LIBRARY ===");
                        System.out.println(library.getLibraryStatus());
                        break;

                    case 6: // Lihat Log
                        System.out.println("\n=== LOG AKTIVITAS ===");
                        System.out.println(library.logger.getLogs());
                        break;

                    case 7: {
                        System.out.print("ID Member: ");
                        int idMember = input.nextInt();

                        Member memberCari = library.findMemberById(idMember);

                        System.out.println(memberCari.getBorrowedItemsWithHeader());
                        break;
                    }
                    case 8:
                        System.out.println("Terima kasih!");
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