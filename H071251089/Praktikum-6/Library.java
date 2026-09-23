import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class LibraryLogger {
    private ArrayList<String> logs = new ArrayList<>();;

    public String logActivity(String title, String memberName, int days, boolean isBorrowed) {
        LocalDateTime tglPinjam = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        if (isBorrowed) {
            LocalDateTime batasHariPinjam = tglPinjam.plusDays(days);

            logs.add(String.format("| %s | %-15s | %-15s | %s |", tglPinjam.format(formatter), title, memberName, batasHariPinjam.format(formatter)));
            return tglPinjam.format(formatter) + " " + title + " dipinjam oleh " + memberName;
        } else {
            LocalDateTime keterlambatan = tglPinjam.plusDays(days);
            logs.add(String.format("| %s | %-15s | %-15s | %-19s |", keterlambatan.format(formatter), title, memberName, "- Dikembalikan"));
            return keterlambatan.format(formatter) + " " + title + " dikembalikan oleh " + memberName;
        }
        
        
    }
    
    public void getLogs() {
        if (logs.isEmpty()) {
            throw new IllegalStateException("Log kosong.");
        }

        System.out.println("+---------------------+-----------------+-----------------+---------------------+");
        System.out.println("| Waktu               | Judul           | Member          | Status              |");
        System.out.println("+---------------------+-----------------+-----------------+---------------------+");

        for (String log : logs) {
            System.out.println(log);
        }

        System.out.println("+---------------------+-----------------+-----------------+---------------------+");
    }

    public void clearLogs() { 
        logs.clear(); 
    }
}


public class Library {
    private ArrayList<LibraryItem> items = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public String addMember(Member member) { 
        members.add(member); 
        return "ID Member " + member.getMemberId() + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        
        throw new NoSuchElementException("Item ID tidak ditemukan.");
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        
        throw new NoSuchElementException("Member ID tidak ditemukan.");
    }

    public void getLibraryStatus() {
        System.out.println("+-------+-----------------+------------+");
        System.out.println("| ID    | Judul           | Status     |");
        System.out.println("+-------+-----------------+------------+");
        for (LibraryItem item : items) {
            String status;
            if (item.getIsBorrowed()) {
                status = "Dipinjam";
            } else {
                status = "Tersedia";
            }
    
            System.out.printf("| %-5d | %-15s | %-10s |\n", item.getItemId(), item.getTitle(), status);
        }

        System.out.println("+-------+-----------------+------------+");
    }

    public void getAllLogs() { logger.getLogs(); }
    public LibraryLogger getLogger() { return logger; }
}