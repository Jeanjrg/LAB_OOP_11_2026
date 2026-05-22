import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public void addItem(LibraryItem i) { items.add(i); }
    public void addMember(Member m) { members.add(m); }
    public LibraryItem findItem(int id) { for (LibraryItem i : items) if (i.itemId == id) return i; return null; }
    public Member findMember(int id) { for (Member m : members) if (m.getMemberId() == id) return m; return null; }
    public LibraryLogger getLogger() { return logger; }

    public void getLibraryStatus() {
        System.out.println("+-------+------------------------------+------------+");
        System.out.println("| ID    | Judul                        | Status     |");
        System.out.println("+-------+------------------------------+------------+");
        for (LibraryItem i : items) {
            String r = "| " + i.itemId; while (r.length() < 8) r += " ";
            r += "| " + i.title; while (r.length() < 39) r += " ";
            r += "| " + (i.isBorrowed ? "Dipinjam" : "Tersedia"); while (r.length() < 52) r += " ";
            System.out.println(r + "|");
        }
        System.out.println("+-------+------------------------------+------------+");
    }
}