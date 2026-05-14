package H071251033.Tuprak6;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia.");
        }
        String result = item.borrowItem(days);
        item.setBorrowed(true);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            return "Item tidak ditemukan di daftar pinjaman.";
        }

        double fine = item.calculateFine(daysLate);

        item.returnItem();

        borrowedItems.remove(item);
        return "Item " + item.getTitle() + " dikembalikan. Denda: Rp " + (int)fine;
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }
        System.out.println("+-------+--------------+");
        System.out.println("|  ID   |    Judul     |");
        System.out.println("+-------+--------------+");
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-5d | %-12s |\n", item.getItemId(), item.getTitle());
        }
        System.out.println("+-------+--------------+");
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }
}