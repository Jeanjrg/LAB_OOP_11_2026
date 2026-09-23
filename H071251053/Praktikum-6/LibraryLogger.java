import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    List<String> logs = new ArrayList<>();

    public void logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logs.add(timestamp + " " + activity);
    }

    public String getLogs() {
        if (logs.isEmpty()) return "Log kosong.";
        String result = "";
        for (String log : logs) {
            result += log + "\n";
        }
        return result;
    }

    public void clearLogs() {
        logs.clear();
    }
}
