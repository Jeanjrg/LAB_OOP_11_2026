package TP6;

import java.util.ArrayList;
import java.util.List;

class LibraryLogger {

    class LogEntry {
        String borrowTime;
        String title;
        String member;
        String returnTime;

        public LogEntry(String borrowTime, String title, String member, String returnTime) {
            this.borrowTime = borrowTime;
            this.title = title;
            this.member = member;
            this.returnTime = returnTime;
        }
    }

    List<LogEntry> logs = new ArrayList<>();

    public String getCurrentTime() {
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        java.time.format.DateTimeFormatter format =
                java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(format);
    }

    public void logBorrow(String title, String member) {
        logs.add(new LogEntry(getCurrentTime(), title, member, "-"));
    }

    public void logReturn(String title, String member) {
        for (LogEntry log : logs) {
            if (log.title.equals(title) &&
                log.member.equals(member) &&
                log.returnTime.equals("-")) {

                log.returnTime = getCurrentTime();
                break;
            }
        }
    }

    public String logActivity(String activity) {
        String time = getCurrentTime();
        String log = time + " " + activity;

        logs.add(new LogEntry(time, activity, "-", "-"));

        return log;
    }

    public String potong(String text, int max) {
        if (text.length() > max) {
            return text.substring(0, max - 3) + "...";
        }
        return text;
    }

    public String getLogs() {
        StringBuilder sb = new StringBuilder();

        sb.append("+---------------------+------------------------------+------------+---------------------+\n");
        sb.append("| Dipinjam pada       | Judul                        | Member     | Dikembalikan pada   |\n");
        sb.append("+---------------------+------------------------------+------------+---------------------+\n");

        for (LogEntry log : logs) {
            sb.append(String.format("| %-19s | %-28s | %-10s | %-19s |\n",
                    log.borrowTime,
                    potong(log.title, 28),
                    potong(log.member, 10),
                    log.returnTime));
        }

        sb.append("+---------------------+------------------------------+------------+---------------------+");

        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
    }
}