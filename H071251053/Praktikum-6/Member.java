import java.util.ArrayList;
import java.util.List;

public class Member {
    String name;
    int memberId;
    List<ALibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(ALibraryItem item, int days) {
        if (item.isBorrowed) {
            throw new IllegalStateException("Item tidak tersedia (sudah dipinjam).");
        }
        String result = item.borrowItem(days); 
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(ALibraryItem item, int daysLate) {
        double fine = item.calculateFine(daysLate);
        item.returnItem();
        borrowedItems.remove(item);
        return "Item " + item.title + " berhasil dikembalikan dengan denda: Rp " + String.format("%.0f", fine);
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }
        System.out.println("+-------+--------------+");
        System.out.println("|  ID   |    Judul     |");
        System.out.println("+-------+--------------+");
        for (ALibraryItem item : borrowedItems) {
            System.out.printf("|  %-4d |  %-10s  |\n", item.itemId, item.title);
        }
        System.out.println("+-------+--------------+");
    }
}