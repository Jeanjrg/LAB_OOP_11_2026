package H071251033.Tuprak6;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);

        return item.getTitle() + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }

        throw new NoSuchElementException("ID Item tidak ditemukan.");
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        
        throw new NoSuchElementException("ID Member tidak ditemukan.");
    }

    public String getLibraryStatus() {
        if (items.isEmpty()) {
            return "Belum ada item di perpustakaan.";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("+-------+----------------------+------------+\n");
        sb.append("|  ID   |        Judul         |   Status   |\n");
        sb.append("+-------+----------------------+------------+\n");

        for (LibraryItem item : items) {
            sb.append(String.format(
                    "| %-5d | %-20s | %-10s |\n",
                    item.getItemId(),
                    item.getTitle(),
                    item.isBorrowed() ? "Dipinjam" : "Tersedia"
            ));
        }

        sb.append("+-------+----------------------+------------+\n");

        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}