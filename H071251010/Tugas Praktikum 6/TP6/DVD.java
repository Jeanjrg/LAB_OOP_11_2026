public class DVD extends LibraryItem {
    private int duration;
    public DVD(String title, int itemId, int duration) { super(title, itemId); this.duration = duration; }
    @Override public String getDescription() { return "DVD: " + title + ", durasi " + duration + " mnt, ID: " + itemId; }
    @Override public double calculateFine(int daysLate) { return daysLate * 25000; }
    @Override public String borrowItem(int days) {
        if (days > 7) return "GAGAL: Maksimal peminjaman DVD 7 hari.";
        return isBorrowed ? "GAGAL: Item sedang dipinjam." : "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }
}