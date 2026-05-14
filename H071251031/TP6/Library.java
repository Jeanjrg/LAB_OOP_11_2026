package TP6;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Library {
    List<LibraryItem> items;
    List<Member> members;
    LibraryLogger logger;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.itemId == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Item tidak ditemukan.");
    }

    public Member findMemberById(int memberId) {
        for (Member m : members) {
            if (m.memberId == memberId) {
                return m;
            }
        }
        throw new NoSuchElementException("Member tidak ditemukan.");
    }

    public String potong(String text, int max) {
        if (text.length() > max) {
            return text.substring(0, max - 3) + "...";
        }
        return text;
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();

        sb.append("+-----+----------------------+------------+\n");
        sb.append("| ID  | Judul                | Status     |\n");
        sb.append("+-----+----------------------+------------+\n");

        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";

            sb.append(String.format("| %-3d | %-20s | %-10s |\n",
                    item.itemId,
                    potong(item.title, 20),
                    status));
        }

        sb.append("+-----+----------------------+------------+");

        return sb.toString();
    }
}
