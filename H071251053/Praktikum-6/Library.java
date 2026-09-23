import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    List<ALibraryItem> items = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    LibraryLogger logger = new LibraryLogger();

    public String addItem(ALibraryItem item) {
        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ALibraryItem findItemById(int itemId) {
        for (ALibraryItem item : items) {
            if (item.itemId == itemId) return item;
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public Member findMemberById(int memberId) {
        for (Member m : members) {
            if (m.memberId == memberId) return m;
        }
        throw new NoSuchElementException("Member ID tidak ditemukan.");
    }

    public String getLibraryStatus() {
        String status = "+-------+-----------------------+------------+\n";
        status += "|  ID   |  Judul                |  Status    |\n";
        status += "+-------+-----------------------+------------+\n";
        for (ALibraryItem item : items) {
            String stat = item.isBorrowed ? "Dipinjam" : "Tersedia";
            status += String.format("| %-5d | %-21s | %-10s |\n", item.itemId, item.title, stat);
        }
        status += "+-------+-----------------------+------------+";
        return status;
    }

    public String getAllLogs() {
        return logger.getLogs();
    }
}
