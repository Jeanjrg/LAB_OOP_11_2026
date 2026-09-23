import java.util.*;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems = new ArrayList<>();

    public Member(String name, int memberId) { this.name = name; this.memberId = memberId; }
    public String getName() { return name; }
    public int getMemberId() { return memberId; }

    public String borrow(LibraryItem item, int days) {
        String result = item.borrowItem(days);
        if (result.startsWith("GAGAL")) return result;
        item.isBorrowed = true;
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        int fine = (int) item.calculateFine(daysLate);
        item.returnItem();
        borrowedItems.remove(item);
        return "Item " + item.title + " kembali. Denda: Rp " + fine;
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) { System.out.println("Tidak ada item dipinjam."); return; }
        System.out.println("+-------+------------------------------+");
        System.out.println("| ID    | Judul                        |");
        System.out.println("+-------+------------------------------+");
        for (LibraryItem item : borrowedItems) {
            String row = "| " + item.itemId;
            while (row.length() < 8) row += " ";
            row += "| " + item.title;
            while (row.length() < 39) row += " ";
            System.out.println(row + "|");
        }
        System.out.println("+-------+------------------------------+");
    }
}