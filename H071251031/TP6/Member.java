package TP6;

import java.util.ArrayList;
import java.util.List;

class Member {
    String name;
    int memberId;
    List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed) {
            throw new IllegalStateException("Item sedang tidak tersedia.");
        }

        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            throw new IllegalStateException("Item tidak ada dalam daftar pinjaman.");
        }

        double fine = item.calculateFine(daysLate);
        item.returnItem();
        borrowedItems.remove(item);

        return "Item " + item.title + 
               " berhasil dikembalikan dengan denda: Rp " + fine;
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam.");
        } else {
            for (LibraryItem item : borrowedItems) {
                System.out.println("- " + item.title);
            }
        }
    }

    public String potong(String text, int max) {
        if (text.length() > max) {
            return text.substring(0, max - 3) + "...";
        }
        return text;
    }

    public String getBorrowedItemsWithHeader() {
        StringBuilder sb = new StringBuilder();

        // Header Member
        sb.append("+======================================+\n");
        sb.append(String.format("| Member: %-28s |\n", name));
        sb.append(String.format("| ID    : %-28d |\n", memberId));
        sb.append("+======================================+\n");

        // Tabel Item
        sb.append("+-----+----------------------+------------+\n");
        sb.append("| ID  | Judul                | Tipe       |\n");
        sb.append("+-----+----------------------+------------+\n");

        if (borrowedItems.isEmpty()) {
            sb.append("| -   | Tidak ada item       | -          |\n");
        } else {
            for (LibraryItem item : borrowedItems) {
                String tipe = item instanceof Book ? "Buku" : "DVD";

                sb.append(String.format("| %-3d | %-20s | %-10s |\n",
                        item.itemId,
                        potong(item.title, 20),
                        tipe));
            }
        }

        sb.append("+-----+----------------------+------------+");

        return sb.toString();
    }
}