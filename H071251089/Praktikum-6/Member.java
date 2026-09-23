import java.util.ArrayList;

public class Member {
    private String name;
    private int memberId;
    private ArrayList<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.getIsBorrowed()) {
            throw new IllegalStateException("Item sudah dipinjam");
        }

        String pinjam = item.borrowItem(days);
        borrowedItems.add(item);
        return pinjam;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            throw new IllegalStateException("Item " + item.getTitle() + " tidak ada dalam daftar pinjaman ID Member " + memberId);
        }

        item.statusReturnItem();
        borrowedItems.remove(item);
        return "Item "+ item.getTitle() + " dikembalikan dengan denda: Rp" + item.calculateFine(daysLate);
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            throw new IllegalStateException("Tidak ada item yang dipinjam");
        } 

        System.out.println("+-------+-----------------+");
        System.out.println("| ID    | Judul           |");
        System.out.println("+-------+-----------------+");

        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-5d | %-15s |\n", item.getItemId(), item.getTitle());
        }

        System.out.println("+-------+-----------------+");
    }

    public String getName() { return name; }
    public int getMemberId() { return memberId; }
}