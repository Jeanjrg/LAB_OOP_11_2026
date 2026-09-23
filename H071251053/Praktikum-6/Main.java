import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilihan: ");
            int menu = input.nextInt(); 
            input.nextLine();

            try {
                if (menu == 1) {
                    System.out.print("Jenis (1.Buku / 2.DVD): ");
                    int tipe = input.nextInt(); input.nextLine();
                    System.out.print("Judul: "); String jdl = input.nextLine();
                    System.out.print("ID: "); int id = input.nextInt(); input.nextLine();
                    if (tipe == 1) {
                        System.out.print("Author: "); String aut = input.nextLine();
                        System.out.println(lib.addItem(new Book(jdl, id, aut)));
                    } else {
                        System.out.print("Durasi (menit): "); int dur = input.nextInt();
                        System.out.println(lib.addItem(new DVD(jdl, id, dur)));
                    }
                } else if (menu == 2) {
                    System.out.print("Nama Member: "); String nm = input.nextLine();
                    System.out.print("ID Member: "); int mid = input.nextInt();
                    lib.addMember(new Member(nm, mid));
                    System.out.println("Member berhasil ditambahkan.");
                } else if (menu == 3) {
                    System.out.print("ID Member: "); int mid = input.nextInt();
                    System.out.print("ID Item: "); int iid = input.nextInt();
                    System.out.print("Durasi (hari): "); int hri = input.nextInt();
                    Member m = lib.findMemberById(mid);
                    ALibraryItem i = lib.findItemById(iid);
                    System.out.println(m.borrow(i, hri));
                    lib.logger.logActivity("[" + i.getClass().getSimpleName() + "] " + i.title + " dipinjam oleh " + m.name);
                } else if (menu == 4) {
                    System.out.print("ID Member: "); int mid = input.nextInt();
                    System.out.print("ID Item: "); int iid = input.nextInt();
                    System.out.print("Terlambat (hari): "); int telat = input.nextInt();
                    Member m = lib.findMemberById(mid);
                    ALibraryItem i = lib.findItemById(iid);
                    System.out.println(m.returnItem(i, telat));
                    lib.logger.logActivity("[" + i.getClass().getSimpleName() + "] " + i.title + " dikembalikan oleh " + m.name);
                } else if (menu == 5) {
                    System.out.println(lib.getLibraryStatus());
                } else if (menu == 6) {
                    System.out.println(lib.getAllLogs());
                } else if (menu == 7) {
                    System.out.print("ID Member: "); int mid = input.nextInt();
                    lib.findMemberById(mid).getBorrowedItems();
                } else if (menu == 8) break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        input.close();
    }
}
