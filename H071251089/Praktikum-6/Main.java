import java.util.Scanner;

public class Main {
    public void sistemMenu() {
        System.out.println("=== Sistem Manajemen Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
    }

    

    public static void main(String[] args) {
        Scanner np = new Scanner(System.in);
        Library lib = new Library();
        Main main = new Main();
        
        // local variable
        int days = 0;

        int pil = 0;
        while (pil != 8) { 
            main.sistemMenu();
            System.out.print(">>> Pilih menu (1-8) : "); pil = np.nextInt();
            
            try {
                switch (pil) {
                    case 1 : 
                        System.out.print("Tipe (1. Buku, 2. DVD): "); int type = np.nextInt(); np.nextLine();
                        System.out.print("Judul: "); String title = np.nextLine();
                        System.out.print("ID Item: "); int itemId = np.nextInt(); np.nextLine();

                        if (type == 1) {
                            System.out.print("Penulis: "); String author = np.nextLine();
                            System.out.println(lib.addItem(new Book(title, itemId, author)));
                        } else {
                            System.out.print("Durasi (menit): "); int duration = np.nextInt();
                            System.out.println(lib.addItem(new DVD(title, itemId, duration)));
                        } 

                        System.out.println();
                        break;

                    case 2 :
                        np.nextLine();
                        System.out.print("Nama: "); String name = np.nextLine();
                        System.out.print("ID Member: "); int memberId = np.nextInt();

                        System.out.println(lib.addMember(new Member(name, memberId)));
                        System.out.println();
                        break;

                    case 3 :
                        System.out.print("ID Member: "); memberId = np.nextInt();
                        Member member = lib.findMemberById(memberId);

                        System.out.print("ID Item: "); itemId = np.nextInt();
                        LibraryItem item = lib.findItemById(itemId);

                        System.out.print("Durasi Pinjam (hari): "); days = np.nextInt();
                        System.out.println(member.borrow(item, days));

                        System.out.println(lib.getLogger().logActivity(item.getTitle(), member.getName(), days, item.getIsBorrowed()));
                        System.out.println();
                        break;

                    case 4 :
                        System.out.print("ID Member: "); memberId = np.nextInt();
                        member = lib.findMemberById(memberId);

                        System.out.print("ID Item: "); itemId = np.nextInt();
                        item = lib.findItemById(itemId);

                        System.out.print("Keterlambatan (hari): "); int daysLate = np.nextInt();                        
                        System.out.println(member.returnItem(item, daysLate));

                        System.out.println(lib.getLogger().logActivity(item.getTitle(), member.getName(), daysLate + days, item.getIsBorrowed()));
                        System.out.println();
                        break;

                    case 5 :
                        lib.getLibraryStatus(); 
                        System.out.println();
                        break;

                    case 6 :
                        lib.getAllLogs(); 
                        System.out.println();
                        break;

                    case 7 :
                        System.out.print("ID Member: "); memberId = np.nextInt();
                        lib.findMemberById(memberId).getBorrowedItems();
                        System.out.println();
                        break;
                    
                    case 8 :
                        break;

                    default :
                        System.out.println("Input tidak tersedia.\n");  
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Pastikan input berupa angka!");
                np.nextLine();
                System.out.println(); 
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println();
            }
        }
    }
    
    // public static int ambilInputAngka(Scanner np, String pesanPrompt) {
    //     while (true) {
    //         System.out.print(pesanPrompt);
    //         try {
    //             int input = np.nextInt();
    //             return input;
    //         } catch (java.util.InputMismatchException e) {
    //             System.out.println(">> Error: Pastikan input berupa angka!"); np.nextLine();
    //             System.out.println();
    //         }
    //     }
    // }
}