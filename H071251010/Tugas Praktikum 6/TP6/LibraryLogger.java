import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LibraryLogger {
    private List<String> logs = new ArrayList<>(); 
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void logActivity(String judul, String member, String tglPinjam, String tglKembali) {
        logs.add(tglPinjam + ";" + judul + ";" + member + ";" + tglKembali);
    }

    public void showLogs() {
        if (logs.isEmpty()) {
            System.out.println("Log kosong.");
            return;
        }

        System.out.println("+---------------------+------------------------------+--------------------+---------------------+");
        System.out.println("| Dipinjam pada       | Judul                        | Member             | Dikembalikan pada   |");
        System.out.println("+---------------------+------------------------------+--------------------+---------------------+");

        for (String log : logs) {
            String[] data = log.split(";");
            String tglP = data[0];
            String judul = data[1];
            String member = data[2];
            String tglK = data[3];

            String row = "| " + tglP;
            while (row.length() < 22) row += " ";
            row += "| " + judul;
            while (row.length() < 53) row += " ";
            row += "| " + member;
            while (row.length() < 74) row += " ";
            row += "| " + tglK;
            while (row.length() < 96) row += " ";

            System.out.println(row + "|");
        }
        System.out.println("+---------------------+------------------------------+--------------------+---------------------+");
    }

    public void clearLogs() {
        logs.clear();
    }
}