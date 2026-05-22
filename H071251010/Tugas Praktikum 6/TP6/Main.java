import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item\n2. Tambah Anggota\n3. Pinjam Item\n4. Kembalikan Item\n5. Lihat Status Perpustakaan\n6. Lihat Log Aktivitas\n7. Lihat Item yang Dipinjam Anggota\n8. Keluar");
            System.out.print("Pilih menu: ");
            int menu = input.nextInt();

            if (menu == 1) {
                System.out.print("Tipe (1.Buku 2.DVD): "); int tipe = input.nextInt();
                System.out.print("ID: "); int id = input.nextInt(); input.nextLine();
                System.out.print("Judul: "); String judul = input.nextLine();
                if (tipe == 1) { System.out.print("Author: "); lib.addItem(new Book(judul, id, input.nextLine())); }
                else { System.out.print("Durasi (mnt): "); lib.addItem(new DVD(judul, id, input.nextInt())); }
            } else if (menu == 2) {
                System.out.print("ID Member: "); int id = input.nextInt(); input.nextLine();
                System.out.print("Nama Member: "); lib.addMember(new Member(input.nextLine(), id));
            } else if (menu == 3) {
                System.out.print("ID Member: "); Member m = lib.findMember(input.nextInt());
                System.out.print("ID Item: "); LibraryItem i = lib.findItem(input.nextInt());
                System.out.print("Lama Pinjam (hari): "); int hari = input.nextInt();
                if (m != null && i != null) {
                    String result = m.borrow(i, hari);
                    System.out.println(result);
                    if (!result.startsWith("GAGAL")) {
                        String tP = LocalDateTime.now().format(dtf);
                        String tK = LocalDateTime.now().plusDays(hari).format(dtf);
                        lib.getLogger().logActivity(i.title, m.getName(), tP, tK);
                    }
                } else System.out.println("Data tidak ditemukan.");
            } else if (menu == 4) {
                System.out.print("ID Member: "); Member m = lib.findMember(input.nextInt());
                System.out.print("ID Item: "); LibraryItem i = lib.findItem(input.nextInt());
                System.out.print("Hari Terlambat: "); int telat = input.nextInt();
                if (m != null && i != null) {
                    System.out.println(m.returnItem(i, telat));
                    String tK = LocalDateTime.now().format(dtf);
                    lib.getLogger().logActivity(i.title, m.getName(), "Kembali", tK);
                }
            } else if (menu == 5) lib.getLibraryStatus();
            else if (menu == 6) lib.getLogger().showLogs();
            else if (menu == 7) {
                System.out.print("ID Member: "); Member m = lib.findMember(input.nextInt());
                if (m != null) m.getBorrowedItems();
            } else if (menu == 8) break;
        }
        } catch (Exception e) {
            System.out.println("Error saat inisialisasi: " + e.getMessage());
        }
    }
}